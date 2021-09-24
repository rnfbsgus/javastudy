package chat01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.List;

public class ChatServerTread extends Thread {
	private String nickname;
	private List<Writer> listWriters;
	private Socket socket = null;

	public ChatServerTread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;

	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		System.out.println(data);
		
		/* writer pool에 저장 */
		addWriter(writer);
		
		// ack
		((PrintWriter)writer).println("join:ok");
		((PrintWriter)writer).flush();
	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	@Override
	public void run() {
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					ChatServer.log("클라이언트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				} 

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1],printWriter);
				} else if ("quit".equals(tokens[0])) {
					doQuit(printWriter);
					break;
				} else {
					ChatServer.log("에러:알 수 없는 요청(" + tokens[0] + ")");
				}
			}
		}  catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void doMessage(String string,Writer writer) {
		String data = nickname + ":" + string;
		broadcast(data);
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}
	

	private void removeWriter(Writer writer) {
		synchronized (listWriters) {
		listWriters.remove(writer);
		}
	}

	public static void log(String string) {
		System.out.println(string);
	}

}

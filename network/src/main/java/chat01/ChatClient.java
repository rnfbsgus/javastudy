package chat01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 4545;
	private static ChatClientRecieveThread chatClientRecieveThread = null;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			// 1.키보드 연결
			scanner = new Scanner(System.in);
			// 2.소켓 생성
			socket = new Socket();
			// 3.연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("connected");
			// 4.reader writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			// 5.join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();
			// 6. ChatClientRecieveThread 시작
			chatClientRecieveThread = new ChatClientRecieveThread(br);
			chatClientRecieveThread.start();
			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				if ("quit".equals(input) == true) {
					chatClientRecieveThread.flag = true;
					pw.println("quit");
					break;
				} else {
					pw.println("message:" + input);
				}
			}
		} catch (SocketException e) {

		} catch (IOException e) {
			log("error:" + e);
		} finally {
			chatClientRecieveThread.flag = true;
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String string) {
		System.out.println(string);
	}

}

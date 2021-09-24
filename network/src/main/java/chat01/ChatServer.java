package chat01;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 4545;
	private static List<Writer> listWriters = new ArrayList<Writer>();

	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림 " + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerTread(socket, listWriters).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void log(String string) {
		System.out.println(string);
	}

}

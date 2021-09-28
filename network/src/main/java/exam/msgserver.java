package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class msgserver {

	public static void main(String[] args) {
		try {
			int socketport = 6000;
			ServerSocket serversocket = new ServerSocket(socketport);
			// 클라이언트 접속시 사용할 socket
			Socket socketUser = null;
			System.out.println("socket :" + socketport + "으로 서버가 열렸습니다.");
			
			//소켓 서버가 종료될 때까지 반복
			while(true) {
				//소켓 서버로 접속 시 socketUser에 접속자 정보 할당
				socketUser = serversocket.accept();
				//접속자의 getLocalAddress 가져오기
				System.out.println("Client가 접속함 : " + socketUser.getLocalAddress());
				//InputStream - 클라이언트에서 서버로
				InputStream input = socketUser.getInputStream();
				//socket의 InputStream 정보를 InputStream in에 넣은 뒤
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				//BufferedReader에 위 InputStream을 담아 사용
				
				//클라이언트에서 온 메세지 확인
				System.out.println(reader.readLine());
				
				//OutputStream - 서버에서 클라이언트로
				OutputStream out = socketUser.getOutputStream();
				//socket의 OutputStream정보를 OutputStream out에 넣은 뒤
				PrintWriter writer = new PrintWriter(out, true);
				//BufferedReader에 위 InputStream을 담아 사용
				
				//서버에서 클라이언트로 메세지 보내기
				writer.println("SERVER TO CLIENT");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

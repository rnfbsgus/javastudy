package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class msgClient {

	public static void main(String[] args) {
		try {
			//소켓 서버에 접속
			Socket socket = new Socket("220.119.14.225",6000);
			System.out.println("socket 서버에 접속 성공!");
			
			//OutputStream - 클라이언트에서 Server로 메세지 발송
			OutputStream out = socket.getOutputStream();
			//socket의 OutputStream 정보를 OutputStream out에 넣은 뒤
			PrintWriter writer = new PrintWriter(out,true);
			//PrintWriter에 위 OutputStream을 담아 사용
			
			writer.println("CLIENT TO SERVER");
			
			//InputStream - Server에서 보낸 메세지 클라이언트로 가져옴
			InputStream input = socket.getInputStream();
			//socket의 InputStream 정보를 InputStream in에 넣은 뒤
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			//BufferedReader에 위 InputStream을 담아 사용
			
			//서버에서 온 메세지 확인
			System.out.println(reader.readLine());
			System.out.println("Client Socket CLOSE");
			//소켓종료
			socket.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package chat01;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.SocketException;

public class ChatClientRecieveThread extends Thread {
	private BufferedReader bufferedReader ;
	public boolean flag = false;
	public ChatClientRecieveThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}


	@Override
	public void run() {
		try {
			while(!flag) {
				String read = bufferedReader.readLine();
				if( read == null) {
					ChatClient.log("서버로 부터 연결 끊김");
					break;
				}
					System.out.println(read);
			}
			
		} catch(SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			flag=true;
			e.printStackTrace();
		} 
		
	}


}
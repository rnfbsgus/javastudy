package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NSLookup {

	public static void main(String[] args) {
		String line = "www.douzone.com";
		InetAddress inetAddress[] = null;
		try {
			 inetAddress = InetAddress.getAllByName(line);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<inetAddress.length; i++) {
			System.out.println(inetAddress[i].getHostName());
			System.out.println(inetAddress[i].getHostAddress());
		}
	}

}

package kr.or.ddit.basic.tcp;

import java.io.IOException;
import java.net.Socket;

public class T04_TcpClient2 {
	public static void main(String[] args) {
		try {
			
			// Socket socket = new Socket("127.0.0.1", 7777);
			Socket socket = new Socket("localhost", 7777);
			
			T05_Sender sender = new T05_Sender(socket);
			T06_Receiver receiver = new T06_Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
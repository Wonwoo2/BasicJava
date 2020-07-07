package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 소켓을 통해서 메시지를 보내는 역할을 담당
 */
public class T05_Sender extends Thread {
	Socket socket;
	DataOutputStream dos;
	String name;
	
	public T05_Sender(Socket socket) {
		this.socket = socket;
		name = "[" + socket.getInetAddress() + " : " + socket.getPort() + "]";
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		while(dos != null) {
			try {
				dos.writeUTF(name + " >>> " + scan.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		scan.close();
	}
}
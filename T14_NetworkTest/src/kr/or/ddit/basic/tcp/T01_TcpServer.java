package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class T01_TcpServer {
	public static void main(String[] args) {
		// TCP 소켓통신을 하기 위해 ServerSocket객체 생성
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 접속을 기다립니다.");
			
			// accpet() 메서드는 client에서 연결요청이 올 때까지 계속 기다린다. (Blcoking)
			// 연결 요청이 오면 Socket 객체를 생성해서 Client의 Socket과 연결된다.
			Socket socket = server.accept();
			
			// ------------------------------------------------------------
			// 이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다.
			System.out.println("접속한 클라이언트 정보");
			System.out.println("주소 : " + socket.getInetAddress());
			
			// Client에서 메시지 보내기
			// OutputStream 객체를 구성하여 전송한다.
			
			// 접속한 Socket의 getOuputStream() 메서드를 이용하여 구한다.
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("어서오세요");		// 메시지 보내기
			System.out.println("메시지를 보냈습니다.");
			
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
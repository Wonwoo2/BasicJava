package kr.or.ddit.basic.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class T02_UdpClient {
	
	public void start() throws IOException{
		DatagramSocket datagramSocket = new DatagramSocket();		// 소켓객체 생성
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		// 데이터가 저장될 공간으로 byte배열을 생성한다. (패킷 수신용)
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 8888);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.send(outPacket);		// 패킷 전송
		datagramSocket.receive(inPacket);	// 패킷 수신
		
		System.out.println("현재 서버 시간 => " + new String(inPacket.getData()));
		
		datagramSocket.close();			// 소켓 종료
	}

	public static void main(String[] args) throws IOException {
		new T02_UdpClient().start();
	}
}
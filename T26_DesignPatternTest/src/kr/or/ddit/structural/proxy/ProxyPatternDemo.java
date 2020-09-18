package kr.or.ddit.structural.proxy;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		
		Image image = new ProxyImage("test_10mb.jpg");
		
		//디스크로부터 이미지 일기
		image.display();
		System.out.println("---------------------------------");
		
		//디스크로부터 이미지 읽지 않고 보여주기
		image.display();
	}
	
}

package kr.or.ddit.basic;

public class T08_TrheadPriorityTest {

	public static void main(String[] args) {
		ThreadTest1 th1 = new ThreadTest1();
		ThreadTest2 th2 = new ThreadTest2();
		
		// 우선 순위는 start() 메서드를 호출하기 전에 설정해야 한다.
		th1.setPriority(10);
		th2.setPriority(1);
		
		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());

		
		th2.start();
		th1.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("최대 우선순위 : " + Thread.MAX_PRIORITY);	// 10
		System.out.println("최소 우선순위 : " + Thread.MIN_PRIORITY);	// 1
		System.out.println("보통 우선순위 : " + Thread.NORM_PRIORITY);	// 5
		
	}

}

class ThreadTest1 extends Thread {
	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch ++) {
			System.out.println(ch);
			
			// 아무것도 하지 않는 반복문(시간 떼우기용)
			for (int i = 0; i <= 1000000000; i ++) {}
			
		}
		
	}
}

class ThreadTest2 extends Thread {
	@Override
	public void run() {
		for (char ch = 'a'; ch <= 'z'; ch ++) {
			System.out.println(ch);
			
			// 아무것도 하지 않는 반복문(시간 떼우기용)
			for (int i = 0; i <= 1000000000; i ++) {}
			
		}
		
	}
}
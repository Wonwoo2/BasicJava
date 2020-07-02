package kr.or.ddit.basic;

public class T15_SynkThreadTest {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		WorkThread th1 = new WorkThread("1번 쓰레드", sObj);
		WorkThread th2 = new WorkThread("2번 쓰레드", sObj);
		
		th1.start();
		th2.start();
		
	}
}

// 공통으로 사용할 객체
class ShareObject {
	private int sum = 0;
	
	// synchronized : 동기화  ==> 동기화를 사용하는 이유는 여러 쓰레드가 사용하는 공유 객체 데이터들의 문제점을 해결하기 위해서 사용
	public void add() {
		synchronized (this) {	// this는 동기화 영역을 현재 객체로 지정하겠다는 의미			
			for (int i  = 0; i < 1000000000; i ++) {}	// 동기화 처리 전까지의 시간벌기용
			
			// 동기화 처리는 가장 필요한 부분만 하는 것이 좋다.
			// 동기화를 많이 하면 할수록 성능부분에 있어 많이 떨어진다.
		
			int n = sum;
			n += 10;	// 10 증가
			sum = n;
		
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
	
	public int getSum() {
		return sum;
	}
}

// 작업을 수행하는 쓰레드
class WorkThread extends Thread {
	ShareObject sObj;
	
	public WorkThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i ++) {
			sObj.add();
		}
	}
}
package kr.or.ddit.basic;

/**
 *  wait()와 notify()를 이용한 두 쓰레드가 번갈아 가면서
 *  한번씩 실행하는 예제
 */
public class T19_WaitNotifyTest {
	/*
	 *  wait() 메서드 => 동기화 영역에서 락을 풀고 
	 *  wait-Set영역(공유객체별 존재)으로 이동시킨다.(일시정지 상태가 되는 것을 의미)
	 *  
	 *  notify() 또는 notifyAll() 메서드 => wait-Set영역에 있는 쓰레드를 채워서
	 *  								실행될 수 있도록 한다.(notify()는 하나,
	 *  								notyfyAll()은 wait-Set에 있는 전부 깨운다.)
	 *  
	 *  => wait()과 notify(), notifyAll(0 메서드는 동기화 영역에서만 실행할 수 있고,
	 *  Object클래스에서 제공하는 메서드 이다.
	 */
	
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methdA() {
		System.out.println("methdA() 메서드 작업 중");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methdB() {
		System.out.println("methdB() 메서드 작업 중");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// workObject와 methodA() 메서드만 호출하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i ++) {
			workObj.methdA();
		}
		System.out.println("ThreadA 종료");
	}
}

//workObject와 methodA() 메서드만 호출하는 쓰레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i ++) {
			workObj.methdB();
		}
		System.out.println("ThreadB 종료");
	}
}
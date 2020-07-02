package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class T06_ThreadTest {
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread inputTh = new DataInput();
		Thread countTh = new CountDown();
		
		inputTh.start();
		countTh.start();
	}
}

class DataInput extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		
		// 입력이 완료되면 inputCheck 변수를 true로 변경한다.
		T06_ThreadTest.inputCheck = true;
		
		System.out.println("입력한 값은 : " + str + "입니다.");
	}
}
// 카운트다운 처리를 위한 쓰레드 클래스
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i >= 1; i --) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면
			// run() 메서드를 종료시킨다. 즉 현재 쓰레드를 종료시킨다.
			if(T06_ThreadTest.inputCheck == true) {
				return;		// run() 메서드가 종료되면 쓰레드도 종료된다.
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 10초가 경과되었는데도 입력이 없으면 프로그램을 종료한다.
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}
package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 *  컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 *  
 *  컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
 *  사용자의 가위 바위 보는 showInputDialog() 메서드를 이용하여 입력 받는다.
 *  
 *  입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 *  5초 안에 입력이 없으면 게임을 진 것으로 처리한다.
 *  
 *  5초 안에 입력이 완료되면 승패를 출력한다.
 *  
 *  결과 예시)
 *  === 결과 ===
 *  컴퓨터 : 가위
 *  당   신 : 바위
 *  결   과 : 당신이 이겼습니다.
 */
public class T07_ThreadGame {
	
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		System.out.println("==== 가위 바위 보 게임을 시작합니다. ====");
		Thread count = new Count();
		count.start();
		String computerStr[] = new String[] {
				"가위", "바위", "보"
		};
		
		int index = (int)(Math.random() * 3);
		String user = JOptionPane.showInputDialog("가위 / 바위 / 보");
		String computer = computerStr[index];
		
		
		inputCheck = true;
		
		if(user.equals(computer)) {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + user);
			System.out.println("결  과 : 비겼습니다.");
			System.out.println("==== 가위 바위 보 게임을 종료합니다. ====");
		} else if((user.equals("가위") && computer.equals("보")) ||
				(user.equals("바위") && computer.equals("가위")) ||
				(user.equals("보") && computer.equals("바위"))) {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + user);
			System.out.println("결  과 : 사용자가 이겼습니다.");
			System.out.println("==== 가위 바위 보 게임을 종료합니다. ====");
		} else {
			System.out.println("컴퓨터 : " + computer);
			System.out.println("사용자 : " + user);
			System.out.println("결  과 : 컴퓨터가 이겼습니다.");
			System.out.println("==== 가위 바위 보 게임을 종료합니다. ====");
		}
	
	}
}

// 5초 타이머 클래스
class Count extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i --) {
			if(T07_ThreadGame.inputCheck == true) {
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("==== 가위 바위 보 게임을 종료합니다. ====");
		System.exit(0);
	}
}
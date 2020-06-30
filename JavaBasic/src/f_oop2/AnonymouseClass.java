package f_oop2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymouseClass {

	public static void main(String[] args) {
		// 하나의 부모 클래스나 인터페이스를 상속 받아 클래스를 선언함과 동시에 객체를 생성하는 클래스
		// GUI를 만들 때 주로 사용한다
		// CUI
		Button b = new Button();
		b.addActionListener(new ActionListener() {	
			// 익명 클래스, ActionListener라는 인터페이스를 상속 받음
			// ActionListener를 상속받은 자식 클래스
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 누르면 실행");
			}
		});
	}
}

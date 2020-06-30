package e_oop;

import useful.ScanUtil;

public class SimLiTestV2 {
	String yesOrNo;
	
	
	void question01() {
		System.out.println("나는 금사빠다(금방 사랑에 빠진다) (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question02();
		} else if(yesOrNo.equals("NO")) {
			question04();
		}
	}
	void question02() {
		System.out.println("연애할 때 끌려다니는 타입이다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question05();
		} else if(yesOrNo.equals("NO")) {
			question06();
		}
	}
	void question03() {
		System.out.println("데이트 코스는 미리 짜는게 편하다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question06();
		} else if(yesOrNo.equals("NO")) {
			question05();
		}
	}
	void question04() {
		System.out.println("감정기복이 크지 않다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question07();
		} else if(yesOrNo.equals("NO")) {
			question05();
		}
	}
	void question05() {
		System.out.println("감정표현에 솔직한 편이다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question08();
		} else if(yesOrNo.equals("NO")) {
			question06();
		}
	}
	void question06() {
		System.out.println("활동적인 데이트가 좋다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question08();
		} else if(yesOrNo.equals("NO")) {
			question09();
		}
	}
	void question07() {
		System.out.println("연락이 없어도 믿고 기다리는 편이다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			System.out.println("당신의 연애 유형 : A");
			typeA();
		} else if(yesOrNo.equals("NO")) {
			question08();
		}
	}
	void question08() {
		System.out.println("이성친구는 존재할 수 없다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			question09();
		} else if(yesOrNo.equals("NO")) {
			System.out.println("당신의 연애 유형 : B");
			typeB();
		}
	}
	void question09() {
		System.out.println("아무것도 아닌 일에 쉽게 섭섭함이 쌓인다 (Yes/No)");
		yesOrNo = ScanUtil.nextLine().toUpperCase();
		if(yesOrNo.equals("YES")) {
			System.out.println("당신의 연애 유형 : D");
			typeD();
		} else if(yesOrNo.equals("NO")) {
			System.out.println("당신의 연애 유형 : C");
			typeC();
		}
	}
	
	void typeA() {
		System.out.println("서로에 대한 신뢰감이 깊고, 존중해주는 어른스러운 연애를 하는 타입!");
	}
	void typeB() {
		System.out.println("구속을 하는 것도, 받는 것도 싫은 자유로운 연애를 하는 타입!");
	}
	void typeC() {
		System.out.println("이것은 의리인가 사랑인가 친구같이 편안한 연애를 하는 타입!");
	}
	void typeD() {
		System.out.println("무조건 잘해주고, 무조건 맞춰주는 다 퍼주는 연애를 하는 타입!");
	}
	
	public static void main(String[] args) {
		SimLiTestV2 slt = new SimLiTestV2();
		
		System.out.println("연애심리테스트를 시작합니다.");
		slt.question01();
	}
}
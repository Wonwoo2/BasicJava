package e_oop;

public class Static {
	
	/*
	 * - 클래스를 사용하기 위해선 객체를 생성해서 메모리 위에 올려두어야한다
	 * - static을 붙이면 객체생성을 하지 않고도 사용할 수 있다
	 * - 값을 공유하기 위해 static을 붙인다
	 * - 메서드에서 인스턴스 변수를 사용하지 않을 때 static을 붙이는 것을 고려한다 클래스 변수와 관련된 변수인 경우 유틸리티 성향의
	 * - 메서드인 경우(Math.random())
	 * 
	 *  전역변수
	 *  	- static이 붙은 전역 변수 : 클래스변수
	 *  	- static이 붙지 않은 전역 변수 : 인스턴스 변수
	 *  
	 *  메서드
	 *  	- static이 붙은 메서드 : 클래스 메서드
	 *  	- static이 붙지 않은 전역 변수 : 인스턴스 메서드
	 */
	static int var;

	public static void main(String[] args) {
		Human 철수 = new Human("철수");
		Human 영희 = new Human("영희");
		철수.saveMoney(100000);
		영희.saveMoney(200000);
		
		철수.saveDateMoney(200000);
		영희.saveDateMoney(200000); // 노란줄은 오류는 아니지만 오류가 생길 수도 있다는 것을 경고하는 것
		
		Human.saveDateMoney(10000); // static 변수는 객체를 통해 호출하는 것이아닌 클래스를 통해 호출한다
		
		/*System.out.print("문자열 입력 > ");
		String str = ScanUtil.nextLine();
		System.out.println("입력 받은 문자열 : " + str);
		
		System.out.print("숫자 입력 > ");
		int num = ScanUtil.nextInt();
		System.out.println("입력 받은 숫자 : " + num);*/
		
	}
}

class Human {
	
	String name;
	int account;
	
	Human(String name) {
		this.name = name;
	}
	
	void saveMoney(int money) {
		account += money;
		System.out.println(name + "의통장 잔고 : " + account);
	}
	
	static int dateAccount;
	
	static void saveDateMoney(int money) {
		dateAccount += money;
		System.out.println("데이트 통장 잔고 : " + dateAccount);
	}
}
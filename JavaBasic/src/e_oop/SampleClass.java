package e_oop;

public class SampleClass {
	public static void main(String[] args) {
		int local = 10; // 지역변수 : 메서드 안에서만 사용하는 변수
	}
	int field = 10; // 전역변수 : 클래스 전체 영역에서 사용하는 변수
			   // 초기화하지 않아도 기본값으로 초기화된다.
	
	boolean bool = false; // boolean 타입의 기본값은 false;
	String str = null; // 참조형 스트링 변수의 기본값은 null;
	
	/*
	 *  - 메서드 : 변수를 가지고 할 일
	 *  - 선언 방법 : 리턴타입 메서드명(파라미터) { }
	 *  - 파라미터(매개변수) : 실행에 필요한 정보
	 *  - 리턴타입(반환타입) : 실행 후 돌려줘야하는 결과물
	 */
	
	void method1() {
		System.out.println("파라미터도 리턴타입도 없는 메서드");
	}
	
	String method2(int parameter) {
		return parameter + " 를 받아 명령을 수행하고 결과물을 리턴하는 메서드";
	}
	
	void flowTest1() {
		System.out.println("flowTest1 시작 : 1"); // 1
		flowTest3();
		System.out.println("flowTest1 종료 : 6"); // 6
	}
	
	void flowTest2() {
		System.out.println("flowTest2 시작 : 3"); // 3
		System.out.println("flowTest2 종료 : 4"); // 4
	}
	
	void flowTest3() {
		System.out.println("flowTest3 시작 : 2"); // 2
		flowTest2();
		System.out.println("flowTest3 종료 : 5"); // 5
	}
	
}
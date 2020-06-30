package f_oop2.ex_abstract.ex_interface;

public interface SampleInterface {
	/*
	 *  - 일반적인 메서드는 구현할 수 없다
	 *  - 상수와 추상메서드를 구현할 수 있다
	 *  - 인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야한다
	 *  - 모든 멤버변수의 제어자가 같기 때문에 생략이 가능하다
	 *  - 인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다
	 *  - 모든 메서드의 제어자가 같기 때문에 생략이 가능하다
	 *  - 상속 받는 여러 인터페이스에 같은 이름의 추상메서드가 있을 경우 하나의 메서드만 상속 받고 정의한다
	 */
	
	public static final int NUM1 = 1;
	int Num2 = 2; // 제어자를 생략해도 상수로 선언된다
	
	public abstract void method1();
	void method(); // 제어자를 생략해도 추상메서드로 선언된다
	
}

interface SampleInterface2 {
	void method2();
	void method3();
}

class SampleImplement implements SampleInterface, SampleInterface2 {

	@Override
	public void method1() {
		
	}

	@Override
	public void method() {	
		
	}

	@Override
	public void method2() {

	}

	@Override
	public void method3() {
		
	}
	
}

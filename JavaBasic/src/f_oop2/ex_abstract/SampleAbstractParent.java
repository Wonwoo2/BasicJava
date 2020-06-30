package f_oop2.ex_abstract;

public abstract class SampleAbstractParent {
	// 추상클래스 = 앞에 abstract를 붙여준다
	
	void method() // 선언부
	{
		// 구현부
	} // 일반적인 메서드
	
	abstract void abstractMethod();
	/* 추상메서드를 하나라도 가지고 있으면 추상클래스
	 * 추상메서드는 선언부만 있고 구현부가 없다
	 * 추상메서드라는 것을 알려주기 위해 abstract라는 제어자를 붙인다
	 * 부모 클래스의 역할만 한다
	 * 자식클래스에 추상메서드를 강제한다
	*/
}

class SampleAbstractChild extends SampleAbstractParent {
	/*
	 *  추상 메서드를 상속 받으면 추상클래스여야한다
	 *  추상 메서드를 오버라이딩해야한다
	 */
	@Override
	void abstractMethod() {
		
	}
	
	
}

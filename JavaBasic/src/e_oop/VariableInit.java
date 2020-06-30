package e_oop;

public class VariableInit {
	
	// 명시적 초기화 : 변수를 선언함과 동시에 변수의 값을 초기화 해준 것
	int var = 10; // 인스턴스 변수
	static int staticVar = 20; // 클래스 변수
	
	// 초기화 블럭 : 여러 문장이 필요한 초기화를 해야할 때 사용한다
	{
		for(int i = 1; i <= 10; i ++) {
			var += i;
		}
	}
	
	static { // static이 붙은 변수를 초기화 할 때 static붙여서 초기화 블럭을 사용한다
		staticVar = 50;
	}
	
	/*
	 * 생성자
	 * - 클래스와 같은 이름의 메서드
	 * - 인스턴스 변수(전역 변수)를 초기화하기 위해 사용한다
	 * - 클래스에 생성자는 반드시 하나 이상 존재해야 한다
	 * - 직접 선언해주지 않으면 컴파일러가 기본 생성자를 만들어준다
	 * - 생성자는 리턴타입이 없다 
	 */
	
	// 파라미터를 받아서 초기화하기 위해 생성자를 만든다
	VariableInit(int var) { 
		for(int i = 1; i <= var; i ++) { 
			this.var += i;
		}
		// this : 클래스의 인스턴스 주소가 저장된 변수
		// 인스턴스변수와 지역변수의 이름이 같을 때 구분하기 위해 인스턴스 변수 앞에 붙여서 사용한다
	}
	// 오버로딩 : 같은 이름의 메서드를 정의하는 것
	// 오버로딩 조건 : 파라미터의 갯수나 타입이 달라야 한다
	VariableInit() {
		this(100);
		// this() : 생성자에서 다른 생성자를 호출할 때 사용한다
		// this() 이전의 코드가 의미 없는 코드가 될 수 있기 때문에 this()는 생성자의 첫줄에서만 사용할 수 있다
	}
	
	public static void main(String[] args) {
		new VariableInit(10);
		new VariableInit();
	}
}

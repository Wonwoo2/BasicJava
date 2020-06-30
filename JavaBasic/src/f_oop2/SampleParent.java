package f_oop2;

public class SampleParent { // 아무것도 상속 받지 않는 경우는 오브젝트 클래스를 상속받는다(extends Object)
							// Object클래스는 모든 클래스의 부모클래스다
							// SampleChild가 SampleParent를 상속받고 있으면서도 Object클래스를 상속받고 있다
							// 상속하는 이유는 여러 클래스에서 중복된 작업을 피하기 위해서 한다

	String var;
	
	{
		var = "초기화 블럭은 물려주지 않는다";
	}
	
	SampleParent() {
		var = "생성자도 물려주지 않는다";
	}
	
	int method(int a, int b) {
		return a + b;
	}

}

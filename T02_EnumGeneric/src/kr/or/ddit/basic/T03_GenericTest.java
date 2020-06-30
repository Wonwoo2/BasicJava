package kr.or.ddit.basic;

class NonGenericClass {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

class MyGeneric<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

public class T03_GenericTest {
	/*
	 *  제네릭 클래스 만드는 방법
	 *  형식)
	 *  	class 클래스명<제네릭타입글자> {
	 *  		제네릭타입글자 변수명;		// 변수 선언에 제네릭을 사용할 경우
	 * 			...
	 * 			제네릭타입글자메서드명() {	// 변환값이 있는 메서드에서 사용
	 * 				...
	 * 				return 값;
	 * 			}
	 * 			...
	 *  	}
	 *  
	 *  
	 *  -- 제네릭 타입 글자 --
	 *  T => Type
	 *  K => Key
	 *  V => Value
	 *  E => Element(자료구조에 들어가는 것들을 나타낼 때 사용)
	 *  
	 *  제네릭을 이용하면 원하는 타입을 정해놓을 수 있다
	 *  예를 들어 Object를 사용하면 모든 타입을 허용하기 때문에
	 *  데이터를 가져오거나 출력할시에 형변환을 해야하지만
	 *  제네릭을 사용하면 명시한 타입으로 정해지기 때문에 형변환을 할 필요가 없다
	 */
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		
		String rtnNg1 = (String)ng1.getVal();
		System.out.println("문자열 반환값 rtnNg1 : " + rtnNg1);
		
		Integer irtnNg2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 irtnNg2 : " + irtnNg2);
		System.out.println();
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setVal("우리나라");
		mg2.setVal(500);
		
		rtnNg1 = mg1.getVal();
		irtnNg2 = mg2.getVal();
		
		System.out.println("제네릭 문자열 반환값 : " + rtnNg1);
		System.out.println("제네릭 정수형 반환값 : " + irtnNg2);

	}
}
package f_oop2;

public class Singleton {
	// 생성된 객체는 하나, 다른 모든 클래스들이 공유한다
	// 스스로 객체를 생성해야한다
	// 디비연결에 주로 사용
	
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	/*
	 *  싱글톤 사용 이유
	 *  - 메모리 절약
	 *  - 속도 향상
	 *  - 객체 공유
	 */
}
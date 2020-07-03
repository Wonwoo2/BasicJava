package kr.or.ddit.basic;

/**
 *  애너테이션 사용 예제
 */
public class T01_Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("메서드 1에서 출력되었습니다.");
	}
	
	@PrintAnnotation("%")		// 타입을 지정해주지 않았지만 value로 인식
	public void method2() {
		System.out.println("메서드 2에서 출력되었습니다.");
	}
	
	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("메서드 3에서 출력되었습니다.");
	}
}
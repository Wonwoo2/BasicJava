package f_oop2;

public class JVM {
	
	/*
	 *  JVM(Java Virtual Machine)
	 *  - 자바로 만들어진 프로그램이 실행되는 컴퓨터 안의 가상 컴퓨터
	 *  - 운영체제 -> JVM -> 자바프로그램
	 *  - 장점 : 운영체제에 상관없이 실행할 수 있다.
	 *  - 단점 : 속도가 느리다.
	 *  
	 *  JVM 메모리 구조
	 *  - Method Area : 클래스 관련 정보가 저장된다. (static 붙은)
	 *  - Call Stack : 현재 호출되어 있는 메서드가 저장된다. (실행중인 메서드)
	 *  - Heap : 객체가 저장된다. (static이 붙지 않은)
	 *  
	 *  ㅣ			     ㅣ
	 *  ㅣ__println()__ㅣ
	 *  ㅣ__method()___ㅣ
	 *  ㅣ__main()_____ㅣ ==> Call Stack 호출순서 main(대기상태) - method(대기상태) - println(현재 실행중인 메서드)
	 *  
	 *  println이 끝나면 method
	 *  method가 끝나면 main순서로 실행한다
	 */

}

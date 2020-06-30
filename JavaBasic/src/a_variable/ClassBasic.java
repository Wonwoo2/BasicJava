//패키지 : 클래스의 위치
package a_variable;

//주석 : 프로그램 코드로 인식하지 않는 문장(주로 코드를 설명하는데 사용)
//한줄주석 : Ctrl + shift + c
/*범위주석 : Ctrl + Shift + /(해제 : \) */
public class ClassBasic {// {} : 블럭(범위)
// 블럭이 시작되면 탭1칸으로 계층을 표현한다.
// 변수 : 데이터를 담는 그릇
	int var = 10;

	// 메서드 : 클래스의 기능
	// main 메서드 : 프로그램을 시작하는 메서드
	public static void main(String[] args) {
		// 하고싶은 일을메서드 안에 적는다.
		System.out.println("Hello"); // 괄호안에 있는 내용을 출력하는 메서드
		System.out.print("Hello"); // 줄바꿈을 하지 않는다.
		System.out.print("Hello"); // 줄바꿈을 하지 않는다.
		System.out.printf("%s", "Hello");// 출력 포맷을 지정한다.
		// ;(세미콜론) : 문장의 마침표
		// 코드는 기본적으로 위에서 아래로 왼쪽에서 오른쪽으로 실행된다.
		// main메서드의 마지막 문장까지 실행되면 프로그램이 종료된다.

	}

}

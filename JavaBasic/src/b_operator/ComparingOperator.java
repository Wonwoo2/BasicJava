package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		/*
		 *  비교 연산자
		 *  - <, >, <=, >=, ==, !=
		 *  - 문자열 비교 : equals()
		 */
		
		boolean b = 10 < 20; //비교 연산자의 결과는 boolean이다.
		System.out.println(b);
		
		b = 10 <= 20 - 15; //산술연산 후 비교연산을 수행한다. (산술연산이 우선순위가 높다.)
		System.out.println(b);
		
		b = "abc" == "abc"; // 참조형 타입은 값이 저장되어 있는 주소를 저장하기 때문에 주소를 비교한다.
		System.out.println(b);
		
		b = "abc" == new String("abc"); // new는 새로운 주소를 생성한다.
		System.out.println(b);
		
		b = "abc".equals(new String("abc"));
		System.out.println(b);
		
		b = !"abc".equals("abc");
		System.out.println(b);
		
		// int 타입의 x와 y 변수를 만들고, 다음의 문장들을 코드로 작성해주세요.
		int x = 10, y = 5;
		// 1. x가 y보다 크다.
		System.out.println(x > y);
		// 2. x는 y보다 작거나 같다.
		System.out.println(x <= y);
		
		// 3. x+5와 y는 같다.
		System.out.println(x + 5 == y);
		
		// 4. x는 3의 배수이다.
		System.out.println(x % 3 == 0);
		
		// 5. y는 홀수이다.
		System.out.println(y % 2 == 1);
		
		// 6. x와 3y는 다르다.
		System.out.println(x != 3 * y);
		
		// 7. "변수"와 "데이터"는 같다.
		System.out.println("변수".equals("데이터"));
		
		// 8. "기본형"과 "참조형"은 다르다.
		System.out.println(!"기본형".equals("참조형"));
		

	}
}
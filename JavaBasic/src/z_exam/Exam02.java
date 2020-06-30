package z_exam;

public class Exam02 {

	public static void main(String[] args) {
		
		/*
		 * [2-1] 다음 표의 빈 칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.
		 * 		종류/크기 1 byte		2 byte		4 byte		8 byte
		 * 		논리형	boolean
		 * 		문자형				char
		 * 		정수형	byte		short		int			long
		 * 		실수형 							float		double
		 * 
		 * [2-2] 주민등록번호를 숫자로 저장하고 한다. 이 값을 저장하기 위해서는 어떤 자료형(data type)을
		 * 선택해야 할까? regNo라는 이름의 변수를 선언하고 자신의 주민등록번호로 초기화 하는 한줄의 코드를 적으시오.
		 * 		long regNo = 9304041406214L;
		 * 
		 * [2-3] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.
		 * 		int i = 100;
		 * 		long l = 100L;
		 * 		final float PI = 3.14f;
		 * 
		 * 		- 리터럴 : 100, 100L, 3.14f
		 * 		- 변수 : i, l
		 * 		- 키워드 : final, int, long, float
		 * 		- 상수 : PI
		 * 
		 * [2-4] 다음 중 기본형(primitive type)이 아닌 것은? => b 
		 * 		a. int
		 * 		b. Byte => 대문자로 시작하면 키워드가 아니다. 대문자로 시작하면 클래스 이름이다.
		 * 		c. double
		 * 		d. boolean
		 * 
		 * [2-5] 다음 문장들의 출력결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 '오류' 라고 적으시오.
		 * 		System.out.println( "1" + "2" )		→(12)
		 * 		System.out.println(true + "")		→(true) => 문자열을 만나면 문자열로 통일되어 출력됨 // boolean 다른타입과 연산이 안됨
		 * 		System.out.println( 'A' + 'B')		→(131)
		 * 		System.out.println('1' + 2)			→(51)
		 * 		System.out.println('1' + '2')		→(99)
		 * 		System.out.println('J' + "ava")		→(Java)
		 * 		System.out.println(true + null)		→(오류) => boolean과 마찬가지로 null도 다른 타입과 연산이 안됨
		 * 
		 * [2-6] 다음 중 키워드가 아닌 것은? (모두 고르시오) => b, c, d, e
		 * 		a. if
		 * 		b. True
		 * 		c. NULL
		 * 		d. Class
		 * 		e. System (클래스 이름)
		 * 
		 * [2-7] 다음 중 변수의 이름으로 사용할 수 있는 것은? (모두 고르시오) => a, d, e, g
		 * 		a. $stem
		 * 		b. channel#5 => 특수문자 #을 사용 할 수 없음
		 * 		c. 7eleven => 앞에 숫자가 올 수 없음
		 * 		d. If
		 * 		e. 자바
		 * 		f. new => 키워드이기 때문에 변수명으로 사용할 수 없음
		 * 		g. $MAX_NUM
		 * 		h. hello@com => 특수문자 @를 사용할 수 없음
		 * 
		 * [2-8] 참조형 변수(reference type)(4 byte)와 같은 크기의 기본형(primitive type)은? (모두 고르시오) => a, d
		 * 		a. int
		 * 		b. long
		 * 		c. short
		 * 		d. float
		 * 		e. double
		 * 
		 * [2-9] 다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오) d, e
		 * 		byte b = 10;
		 * 		char oh = 'A';
		 * 		int i = 100;
		 * 		long l = 1000L;
		 * 
		 * 		a. b = (byte)i;
		 * 		b. oh = (char)b; => oh 와 b변수의 표현 범위가 다르기 때문에 형변환을 생략할 수 없음
		 * 		c. short s = (short)oh; => 정수는 -까지 표현, char는 0부터 +만 표현
		 * 		d. float f = (flaot)l;
		 * 		e. i = (int)oh;
		 *
		 * [2-10] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)
		 *		=> 0 ~ 65535
		 *		char는 2byte(2 * 8 = 16 bit) 이므로 2의 16제곱 개의 값을 표현할 수 있다
		 *
		 * [2-11] 다음중 변수를 잘못 초기화 한 것은? (모두 고르시오) a, b, c, d
		 * 		a. byte b = 256;
		 * 		b. char o = '';
		 * 		c. char answer = 'no'; => 문자열은 ""로 표현
		 * 		d. float f = 3.14 => 접미사 f 빠짐
		 * 		e. double d = 1.4e3f; => f생략 가능
		 * 
		 * [2-12] 다음 중 main메서드의 선언부로 알맞은 것은? (모두 고르시오) => a, b, c, e
		 * 		a. public static void main(String[] args)
		 * 		b. public static void main(String args[])
		 * 		c. public static void main(String[] arv)
		 * 		d. public void static main(String[] args)
		 * 		e. static public void main(String[] args)
		 * 
		 * [2-13] 다음 중 타입과 기본값이 잘못 연결된 것은? (모두 고르시오) c, e, f
		 * 		a. boolean - false
		 * 		b. char - '\u0000'
		 * 		c. float - 0.0 => float 타입이기 때문에  접미사f를 붙여야함
		 * 		d. int - 0
		 * 		e. long - 0 => long 타입이기 때문에 접미사l를 붙여야함
		 * 		f. String - "" => null이 기본값
		 */
	}
}
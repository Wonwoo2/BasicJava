package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 *  비트 연산자
		 *  - |, &, ^, ~, <<, >>
		 *  - 비트 단위로 연산한다.
		 *  
		 *  기타 연산자
		 *  - .(참조연산자) : 특정 범위 내에 속해 있는 멤버를 지칭할 떄 사용한다.
		 *  - (type) : 형변환(casting)
		 *  - ? : (삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일경우 수행할 문장
		 */
		
		// 1byte : 01010101 (8bit)
		
		int x = 10;
		int y = 20;
		int result = (x < y) ? x : y;
		
		System.out.println(result);
		
		// 주민등록번호 뒷자리의 첫 번째 숫자가 1이면 남자 2면 여자
		int regNo = 5;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println("당신의 설병은 " + gender + " 입니다.");
		
		gender = regNo == 1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		// 2개의 숫자를 입력 받고, 둘 중 더 큰 숫자를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 개의 숫자를 입력해주세요>");
		int a = sc.nextInt();
		System.out.println("입력 받은 숫자 : " + a + " 입니다.");
		int b = sc.nextInt();
		System.out.println("입력 받은 숫자 : " + b + " 입니다.");
		
		int result1 = a > b ? a : b;
		System.out.println("두 개의 숫자 중 큰 숫자는 " + result1 + " 입니다.");
		
		// 숫자를 입력 받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		// 그외의 숫자를 입력하면 확인불가를 출력해주세요.
		
		System.out.println("숫자를 입력해주세요>");
		int c = sc.nextInt();
		System.out.println("입력 받은 숫자 : " + c + " 입니다.");
		
		String result2 = c == 1 || c == 3 ? "남자" : ((c == 2 || c == 4) ? "여자" : "확인불가");
		System.out.println(result2);
		
	}
}
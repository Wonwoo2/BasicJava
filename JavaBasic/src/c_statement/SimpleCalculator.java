package c_statement;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		// 두 개의 숫자와 연산자를 입력 받아 연산 결과를 알려주는 프로그램을 만들어주세요.
		// if문 , switch문
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int input1, input2;
		String input3;
		
		System.out.println("첫 번째 숫자를 입력해주세요>");
		input1 = Integer.parseInt(sc.nextLine());

		System.out.println("연산자를 입력해주세요>");
		input3 = sc.nextLine();
		
		System.out.println("두 번째 숫자를 입력해주세요>");
		input2 = Integer.parseInt(sc.nextLine());
		
		
		if(input3.equals("+")) {
			sum = input1 + input2;
			System.out.println("두 숫자의 덧셈 : " + sum);
		} else if(input3.equals("-")) {
			sum = input1 - input2;
			System.out.println("두 숫자의 뺄셈 : " + sum);
		} else if(input3.equals("*")) {
			sum = input1 * input2;
			System.out.println("두 숫자의 곱셈 : " + sum);
		} else if(input3.equals("/")) {
			System.out.println("두 숫자의 나눗셈 : " + sum);
		} else {
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
		}
		
		sum = 0;
		input1 = 0;
		input2 = 0;
		input3 = null;
		
		System.out.println("첫 번째 숫자를 입력해주세요>");
		input1 = Integer.parseInt(sc.nextLine());

		System.out.println("연산자를 입력해주세요>");
		input3 = sc.nextLine();
		
		System.out.println("두 번째 숫자를 입력해주세요>");
		input2 = Integer.parseInt(sc.nextLine());

		switch(input3){
		case "+" :
			sum = input1 + input2;
			System.out.println("두 수의 덧셈 : " + sum);
			break;
		case "-" :
			sum = input1 - input2;
			System.out.println("두 수의 뺄셈 : " + sum);
			break;
		case "*" :
			sum = input1 * input2;
			System.out.println("두 수의 곱셈 : " + sum);
			break;
		case "/" :
			sum = input1 / input2;
			System.out.println("두 수의 나눗셈 : " + sum);
			break;
		default :
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
			break;
		}
		
		
	}

}

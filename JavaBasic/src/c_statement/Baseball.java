package c_statement;

import java.util.Scanner;

public class Baseball {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = 0;
		int tmp = 0;
		int strike = 0;
		int ball = 0;
		int out = 0;

		int answer1 = 0;
		int answer2 = 0;
		int answer3 = 0;

		while (true) {
			answer1 = (int) (Math.random() * 9) + 1;
			answer2 = (int) (Math.random() * 9) + 1;
			answer3 = (int) (Math.random() * 9) + 1;

			if (answer1 == answer2) {
				answer2 = (int) (Math.random() * 9) + 1;
			} else if (answer2 == answer3 || answer1 == answer3) {
				answer3 = (int) (Math.random() * 9) + 1;
			} else {
				break;
			}
		}
		System.out.println(answer1 + "" + answer2 + "" + answer3);
		
		while(true) {
			System.out.print("세 자리 숫자를 입력하세요 : (1~999)");
			input = sc.nextInt();
			
			strike = 0;
			ball = 0;
			out = 0;
			
			if (input > 999 || input < 1) {
				if (input == 0) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				System.out.println("잘못입력하셨습니다. 다시 입력해 주세요");
				continue;
			}
			
			tmp = input / 100;
			for(int i = 1; i <= 3; i ++){
				if(tmp == answer1) {
					strike++;
					break;
				} else if(tmp == answer2 || tmp == answer3) {
					ball++;
					break;
				} else {
					out++;
					break;
				}
			}
			
			tmp = input / 10;
			tmp = tmp % 10;
			for(int i = 1; i <= 3; i ++){
				if(tmp == answer2) {
					strike++;
					break;
				} else if(tmp == answer3 || tmp == answer1) {
					ball++;
					break;
				} else {
					out++;
					break;
				}
			}
			
			tmp = 0;
			tmp = input % 10;
			for(int i = 1; i <= 3; i ++){
				if(tmp == answer3) {
					strike++;
					break;
				} else if(tmp == answer2 || tmp == answer1) {
					ball++;
					break;
				} else {
					out++;
					break;
				}
			}
			System.out.println(strike + " 스트라이크");
			System.out.println(ball + " 볼");
			System.out.println(out + " 아웃");

			if (strike == 3) {
					System.out.println("정답입니다.");
					break;
			}
		}

	}
}


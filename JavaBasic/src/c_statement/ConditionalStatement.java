package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 *  if문
		 *  - if		: 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
		 *  - else if	: 다수의 조건이 필요할때 if 뒤에 추가한다.
		 *  - else		: 결과가 true인 조건식이 하나도 없는 경우를 위해 추가한다.
		 *  
		 *  if(조건식){}
		 *  else if(조건식){}
		 *  else{}
		 */
		
		int a = 10;
		
		if(a < 100) {
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}
		
		int regNo = 3;
		String gender = null;
		
		if(regNo == 1) {
			gender = "남자";
		} else if(regNo == 2) {
			gender = "여자";
		} else if(regNo == 3) {
			gender = "남자";
		} else if(regNo == 4) {
			gender = "여자";
		} else {
			gender = "확인불가";
		}
		
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		regNo = 1;
		gender = null;
		
		if(regNo == 1 || regNo == 3) {
			gender = "남자";
		} else if(regNo == 2 || regNo == 4) {
			gender = "여자";
		} else {
			gender = "확인불가";
		}
		
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		// 성적에 등급을 부여하는 프로그램
		int score = 88;
		String grade = null;
		
		if(score >= 90) {
			grade = "A";
		} else if(80 <= score && score < 90) {
			grade = "B";
		} else if(70 <= score) {
			grade = "C";
		} else if(60 <= score) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		System.out.println(score + "점에 해당하는 등급은 " + grade + " 입니다.");
		
		// 등급 안에서 +와 -를 나누어보자.
		score = 97;
		grade = null;
		
		if(90 <= score) {
			grade = "A";
			if(97 <= score) {
				grade += "+";
			} else if(93 >= score) {
				grade += "-";
			}
		} else if(80 <= score && 90 > score) {
			grade = "B";
			if(87 <= score) {
				grade += "+";
			} else if(83 >= score) {
				grade += "-";
			}
		} else if(70 <= score) {
			grade = "C";
			if(77 <= score) {
				grade += "+";
			} else if(73 >= score) {
				grade += "-";
			}
		} else if(60 <= score) {
			grade = "D";
			if(67 <= score) {
				grade += "+";
			} else if(63 >= score) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		
		System.out.println(score + "점에 해당하는 등급은 " + grade + " 입니다.");
		
		/*
		 *  switch 문
		 *  - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 *  - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열 허용) 허용한다.
		 *
		 *	swithch(조건식) {
		 *		case 값 : break;
		 *		case 값 : break;
		 *	}
		 */
		
		regNo = 2;
		gender = null;
		
		switch(regNo) {
		case 1 : case 3 :
			gender = "남자";
			break;
		case 2 : case 4 :
			gender = "여자";
			break;
		default : //if문의 else와 같은 역할을 한다.
			gender = "확인불가";
		}
		
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		score = 95;
		grade = null;
		
		switch(score / 10) {
		case 10 : case 9 :
			grade = "A";
			break;
		case 8 :
			grade = "B";
			break;
		case 7 :
			grade = "C";
			break;
		case 6 :
			grade = "D";
			break;
		default :
			grade = "F";
		}
		
		System.out.println(score + "점에 해당하는 등급은 " + grade + " 입니다.");
		
		// 숫자를 입력 받아 그 숫자가 0인지 0이 아닌지 출력해주세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요>");
		int number = sc.nextInt();
		
		if(number != 0) {
			System.out.println("입력 받은 숫자 " + number + "는(은) 0이 아닙니다.");
		} else {
			System.out.println("입력 받은 숫자 " + number + "는(은) 0입니다.");
		}
		
		// 숫자를 입력 받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		System.out.print("숫자를 입력해주세요>");
		int isNumber = sc.nextInt();
		
		if(isNumber % 2 == 0) {
			System.out.println("입력 받은 숫자 " + number + "는(은) 짝수입니다.");
		} else {
			System.out.println("입력 받은 숫자 " + number + "는(은) 홀수입니다.");
		}
		
		// 정수 3개 입력 받아 총점, 평균, 등급을 출력해주세요.
		int sum = 0;
		double avg;
		grade = null;
		
		System.out.println("국어 점수를 입력해주세요>");
		int kor = sc.nextInt();
		System.out.println("영어 점수를 입력해주세요>");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요>");
		int math = sc.nextInt();
		
		sum = kor + eng + math;
		avg = sum / 3.0;

		if(90 <= avg) {
			grade = "A";
			if(97 <= avg) {
				grade += "+";
			} else if(93 >= avg) {
				grade += "-";
			}
		} else if(80 <= avg && 90 > avg) {
			grade = "B";
			if(87 <= avg) {
				grade += "+";
			} else if(83 >= avg) {
				grade += "-";
			}
		} else if(70 <= avg) {
			grade = "C";
			if(77 <= avg) {
				grade += "+";
			} else if(73 >= avg) {
				grade += "-";
			}
		} else if(60 <= avg) {
			grade = "D";
			if(67 <= avg) {
				grade += "+";
			} else if(63 >= avg) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		
		System.out.println("총점 : " + sum + " " + "평균 : " + avg + " " + "등급 : " + grade);
		
		
	}
}
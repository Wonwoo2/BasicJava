package c_statement;

import java.util.Scanner;

public class SimLiTest0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String Q1 = "나는 금사빠다(금방 사랑에 빠진다)";
		String Q2 = "연애할 때 끌려다니는 타입이다";
		String Q3 = "데이트 코스는 미리 짜는게 편하다";
		String Q4 = "감정 기복이 크지 않다";
		String Q5 = "감정 표현에 솔직한 편이다";
		String Q6 = "활동적인 데이트가 좋다";
		String Q7 = "연락이 없어도 믿고 기다리는 편이다";
		String Q8 = "이성친구는 존재할 수 없다"; 
		String Q9 = "아무것도 아닌 일에 쉽게 섭섭함이 쌓인다";
		
		String A1 = "A";
		String A2 = "B";
		String A3 = "C";
		String A4 = "D";
		
		String questionYN = "";
		
		String input = "";
		
		boolean t, t1;
		
		questionYN = Q1;
		
		System.out.println("나의 연애 유형은 ?");
		
		
		while(true) {
			System.out.println(questionYN);
			if(questionYN == A1 || questionYN == A2 ||
					questionYN == A3 || questionYN == A4) {
					System.out.println("프로그램을 종료합니다.");
					break;
			}
			System.out.println("Yes Or No ? :");
			input = sc.nextLine();
			input.toUpperCase();
			
			t = input.equals("YES") || input.equals("yes");
			t1 = input.equals("NO") || input.equals("no");
			if(!t && !t1) {
				System.out.println("잘못입력했습니다. 다시 입력해주세요.");
			}
	
			if(questionYN == Q1) {
				if(t) {
					questionYN = Q2;
				} else if(t1) {
					questionYN = Q4;
				} else {
					continue;
				}
			} else if(questionYN == Q2) {
				if(t) {
					questionYN = Q5;
				} else if(t1) {
					questionYN = Q3;
				} else {
					continue;
				}
			} else if(questionYN == Q3) {
				if(t) {
					questionYN = Q6;
				} else if(t1) {
					questionYN = Q5;
				} else {
					continue;
				}	
			} else if(questionYN == Q4) {
				if(t) {
					questionYN = Q7;
				} else if(t1) {
					questionYN = Q5;
				} else {
					continue;
				}
			} else if(questionYN == Q5) {
				if(t) {
					questionYN = Q8;
				} else if(t1) {
					questionYN = Q6;
				} else {
					continue;
				}
			} else if(questionYN == Q6) {
				if(t) {
					questionYN = Q8;
				} else if(t1) {
					questionYN = Q9;
				} else {
					continue;
				}
			} else if(questionYN == Q7) {
				if(t) {
					questionYN = A1;
				} else if(t1) {
					questionYN = Q8;
				} else {
					continue;
				}
			} else if(questionYN == Q8) {
				if(t) {
					questionYN = Q9;
				} else if(t1) {
					questionYN = A2;
				} else {
					continue;
				}
			} else if(questionYN == Q9) {
				if(t) {
					questionYN = A4;
				} else if(t1) {
					questionYN = A3;
				} else {
					continue;
				}
			} else {
				continue;
			}
		}

	}

}

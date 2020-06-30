package c_statement;

import java.util.Scanner;


public class SimLiTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] question = {
				"나는 금사빠다(금방 사랑에 빠진다)", "연애할 때 끌려다니는 타입이다", "데이트 코스는 미리 짜는게 편하다", 
				"감정 기복이 크지 않다", "감정 표현에 솔직한 편이다", "활동적인 데이트가 좋다", "연락이 없어도 믿고 기다리는 편이다",
				"이성친구는 존재할 수 없다", "아무것도 아닌 일에 쉽게 섭섭함이 쌓인다"
		};
		
		String [] abcd = {"A", "B", "C", "D"};
		
		String questionYN = "";
		
		String input = "";
		
		boolean t, t1;
		
		questionYN = question[0];
		
		System.out.println("나의 연애 유형은 ?");
		
		
		while(true) {
			System.out.println(questionYN);
			if(questionYN == abcd[0] || questionYN == abcd[1] ||
					questionYN == abcd[2] || questionYN == abcd[3]) {
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
	
			if(questionYN == question[0]) {
				if(t) {
					questionYN = question[1];
				} else if(t1) {
					questionYN = question[3];
				} else {
					continue;
				}
			} else if(questionYN == question[1]) {
				if(t) {
					questionYN = question[4];
				} else if(t1) {
					questionYN = question[2];
				} else {
					continue;
				}
			} else if(questionYN == question[2]) {
				if(t) {
					questionYN = question[5];
				} else if(t1) {
					questionYN = question[4];
				} else {
					continue;
				}	
			} else if(questionYN == question[3]) {
				if(t) {
					questionYN = question[6];
				} else if(t1) {
					questionYN = question[4];
				} else {
					continue;
				}
			} else if(questionYN == question[4]) {
				if(t) {
					questionYN = question[7];
				} else if(t1) {
					questionYN = question[5];
				} else {
					continue;
				}
			} else if(questionYN == question[5]) {
				if(t) {
					questionYN = question[7];
				} else if(t1) {
					questionYN = question[8];
				} else {
					continue;
				}
			} else if(questionYN == question[6]) {
				if(t) {
					questionYN = abcd[0];
				} else if(t1) {
					questionYN = question[7];
				} else {
					continue;
				}
			} else if(questionYN == question[7]) {
				if(t) {
					questionYN = question[8];
				} else if(t1) {
					questionYN = abcd[1];
				} else {
					continue;
				}
			} else if(questionYN == question[8]) {
				if(t) {
					questionYN = abcd[3];
				} else if(t1) {
					questionYN = abcd[2];
				} else {
					continue;
				}
			} else {
				continue;
			}
			
		}
	}
}
package kr.or.ddit.basic;

import java.util.*;

public class T13_LottoTest {
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("==========================");
			System.out.println("\tLotto 프로그램");
			System.out.println("==========================");
			System.out.println("--------------------------");		
			System.out.println("\t1. Lotto 구입");
			System.out.println("\t2. 프로그램 종료");
			System.out.println("--------------------------");
			
			System.out.print("메뉴 선택 : ");
			int input = ScanUtil.nextInt();
			
			switch(input) {
			case 1 :
				lottoBuy();
				break;
			case 2 :
				System.out.println("감사합니다");
				System.exit(0);
				break;
			}		
		}	
	}
	
	public static void lottoBuy() {
		int lottoPrice = 1000;
		System.out.println("Lotto 구입 시작");
		System.out.println(lottoPrice + "원에 로또번호 하나입니다.");
		
		System.out.print("금액 입력 : ");
		int money = ScanUtil.nextInt();
		
		if(money < 0) {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		
		lottoCreate(money/lottoPrice);
		System.out.println();
		
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " 
		+ money%lottoPrice + "원입니다.");
		
		System.out.println();
		
	}
	
	public static void lottoCreate(int number) {
	
		for (int i = 0; i < number; i ++) {
			Set<Integer> random = new TreeSet<>();
			while(random.size() < 6) {
				int num = (int)(Math.random() * 45) + 1;
				random.add(num);
			}
			
			System.out.print("로또번호 " + (i+1) + " : ");
			for(Integer lotto : random) {
				System.out.print(lotto + " ");
			}
			System.out.println();
		}
	}
}
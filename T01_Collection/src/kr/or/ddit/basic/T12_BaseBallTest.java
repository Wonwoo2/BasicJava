package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class T12_BaseBallTest {
/*
 *  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 *  	컴퓨터의 숫자는 난수를 이용하여 구한다.
 *  	(스트라이크는 'S', 볼은 'B'로 출력한다.)
 *  
 *  컴퓨터의 난수가 9 5 7 일 때 실행 예시)
 *  숫자 입력 => 3 5 6
 *  3 5 6 => 1S 0B
 *  
 *  숫자 입력 => 7 8 9
 *  7 8 9 => 0S 2B
 * 	...
 * 	숫자 입력 => 9 5 7
 *	9 5 7 => 3S 0B
 *
 *	5번째 만에 맞췄군요.
 *  
 */
	public static void main(String[] args) {
		Set<Integer> random = new LinkedHashSet<Integer>();
		while(random.size() < 3) {
			int num = (int)(Math.random() * 9) + 1;
			random.add(num);
		}
		
		ArrayList<Integer> baseball = new ArrayList<>(random);
		System.out.println("===================");
		System.out.println("숫자 야구 게임을 시작합니다.");
		System.out.println("===================");

		int count = 0;

		while(true) {
			int strike = 0;
			int ball = 0;
			
			System.out.print("숫자 입력 (1~9, 공백을 포함하여 입력해주세요)> ");
			String input = ScanUtil.nextLine().trim();
			if(!input.contains(" ") || input.contains("0")) {
				System.out.println("0을 입력하거나 공백을 입력하지 않았습니다.");
				continue;
			}
	
			String[] numberArray = input.split(" ");
			
			if(numberArray[0].equals(numberArray[1]) || numberArray[1].equals(numberArray[2])
					|| numberArray[2].equals(numberArray[0])) {
				System.out.println("중복된 숫자를 입력할 수 없습니다.");
				continue;
			}
			
			for (int i = 0; i < numberArray.length; i ++) {
				System.out.print(numberArray[i] + " ");
			}
			
			for (int i = 0; i < numberArray.length; i ++) {
				for (int j = 0;  j < baseball.size(); j ++) {
					if(Integer.parseInt(numberArray[i]) == baseball.get(j) && i == j) {
						strike++;
					} else if(Integer.parseInt(numberArray[i]) == baseball.get(j) && i != j) {
						ball++;
					}
				}
			}
			count++;
			System.out.print(" => " + strike + "S " +  ball + "B");
			System.out.println();
			
			if(strike == 3) {
				System.out.println(count + "번째에 맞췄습니다.");
				System.out.println("===================");
				System.out.println("숫자 야구 게임을 종료 합니다.");
				System.out.println("===================");		
				break;
			}
		}
	}
}
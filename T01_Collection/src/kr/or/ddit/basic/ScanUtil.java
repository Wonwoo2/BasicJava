package kr.or.ddit.basic;

import java.util.Scanner;

// Scanner 클래스의 메서드를 사용하기 위해 정의
public class ScanUtil {

	private static Scanner s = new Scanner(System.in);
	
	public static String nextLine() {
		return s.nextLine();
	}
	
	public static int nextInt() {
		return Integer.parseInt(s.nextLine());
	}
}

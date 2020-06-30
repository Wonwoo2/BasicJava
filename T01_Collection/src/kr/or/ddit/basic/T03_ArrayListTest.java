package kr.or.ddit.basic;

import java.util.ArrayList;

public class T03_ArrayListTest {

	public static void main(String[] args) {
		// 문제  1. 5명의 사람 이름을 입력 받아 ArrayList에 저장하고 이 중에서
		//		  '김' 씨 성의 이름을 출력하시오.
		ArrayList<String> nameList = new ArrayList<>();
		
		for (int i = 0; i < 5; i ++) {
			System.out.print("이름 입력 > ");
			String name = ScanUtil.nextLine();
			nameList.add(name);
		}
		
		for (int i = 0; i < nameList.size(); i ++) {
			if(nameList.get(i).startsWith("김")) {
				System.out.println(nameList.get(i));
			}
		}
		
		// if(name.substring(0,1).equals("김"))
		// if(name.indexOf("김")==0)
		// if(name.charAt(0)=='김')
			
	}}

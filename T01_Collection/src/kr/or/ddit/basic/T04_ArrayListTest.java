package kr.or.ddit.basic;

import java.util.ArrayList;

public class T04_ArrayListTest {
	public static void main(String[] args) {

		// 문제 2. 5명의 별명을 입력하여 ArrayList에 저장하고 별명의 길이가
		// 별명의 길이가 제일 긴 별명을 출력하시오.
		// (단, 각 별명의 길이는 모두 다르게 입력한다)
		ArrayList<String> nickNameList = new ArrayList<>();

		String nickName = "";
		for (int i = 0; i < 5; i++) {
			System.out.print("별명 입력 > ");
			nickName = ScanUtil.nextLine();
			nickNameList.add(nickName);
		}

		// 길이가 가장 긴 닉네임을 가진 것을 구분하려면 length()를 저장하여
		// 해당 length()를 가진 별명을 출력하면 동일한 length()를 가진 별명을 출력
		// 할수 있음
		int max = nickNameList.get(0).length();
		for (int i = 0; i < nickNameList.size(); i++) {
			if (max < nickNameList.get(i).length()) {
				nickName = nickNameList.get(i);
			}
		}

		System.out.println("가장 긴 별명 : " + nickName);
		System.out.println("별명의 길이 : " + nickName.length());

	}
}

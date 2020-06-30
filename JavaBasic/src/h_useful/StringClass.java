package h_useful;

public class StringClass {

	public static void main(String[] args) {
		String s = new String("ABCD"); // 참조형 타입을 초기화하는 방법
		String str = "ABCD";
		System.out.println(s);
		
		/*
		 *  - equals()	: 문자열의 내용이 같은지 확인한다.
		 *  - length()	: 문자열의 길이를 반환한다.
		 *  - carAt()	: 문자열에서 해당 위치에 있는 문자를 반환한다.
		 *  - substring() : 문자열에서 해당 범위에 있는 문자열을 반환한다.
		 *  - indexOf()	: 문자열 내의 특정 문자열의 인덱스를 반환한다.
		 *  - replace() : 문자열 내의 특정 문자열을 원하는 문자열로 변경해 반환한다.
		 */
		
		for (int i = 0; i < str.length(); i ++) {
			System.out.println(str.charAt(i));
		}
		
		String revStr = ""; // str을 거꾸로 담을 변수
		for (int i = str.length() - 1; i >= 0; i --) {
			revStr += str.charAt(i);
		}
		System.out.println(revStr);
		
		str = "0123456789";
		String sub = str.substring(3); // 3번 인덱스부터 끝까지 잘라서 반환한다.
		
		System.out.println(sub);
		
		String sub1 = str.substring(5, 8); // 5번 인덱스부터 8번 인덱스 전까지 잘라서 반환한다.
		
		System.out.println(sub1);
		
		str = "치킨 피자 돈까스 떡볶이";
		int idx = str.indexOf("피자"); // 피자의 시작 인덱스르 반환한다.
		
		System.out.println(idx);
		
		String[] menus = {
				"치킨 18000원",
				"피자 9900원",
				"돈까스 8000원",
				"떡볶이 500원"
		};
		
		for (String menu : menus) {
			String name = menu.substring(0, menu.indexOf(" "));
			System.out.println(name);
		}
		
		for (String menu : menus) {
			int price = Integer.parseInt(menu.substring(menu.indexOf(" ") + 1, menu.indexOf("원")));
			System.out.println(price);
		}
		
		str = "123456789";
		str = str.replace("3", "짝");
		System.out.println(str);
		
		str = str.replace("6", "짝");
		str = str.replace("9", "짝");
		System.out.println(str);
		
		String pn = "010-2363-3647";
		pn = pn.replace("-", "");
		
		System.out.println(pn);
	}
}
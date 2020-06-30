package h_useful;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

	public static void main(String[] args) {
		/*
		 *  정규표현식 : 문자열의 패턴을 검사하는 표현식
		 *  
		 *  ^ 		뒷 문자로 시작
		 *  $		앞 문자로 종료
		 *  .		임의의 문자(줄바꿈 제외)
		 *  *		앞 문자가 0개 이상
		 *  +		앞 문자가 1개 이상
		 *  ? 		앞 문자가 없거나 1개
		 *  []		문자의 집합이나 범위([a-z] : a부터 z까지, [^a-z] : a부터 z가 아닌 것)
		 *  {}		앞 문자의 개수 ({2} : 2개, {2, 4} : 2개 이상 4개 이하)
		 *  ()		그룹화(1개의 문자처럼 인식)
		 *  |		OR연산
		 *  \s		공백, 탭, 줄바꿈
		 *  \S		공백, 탭, 줄바꿈이 아닌 문자
		 *  \w		알파벳이나 숫자 1개
		 *  \d		숫자
		 *  \D		숫자가 아닌 문자
		 *  (?i)	뒷 문자의 대소문자 구분 안함
		 *  \		정규표현식에서 사용되는 특수문자 표현
		 */
		
		String str = "wonwoo0404";
		String str1 = "010-4374-2359";
		String str2 = "wonwoo0404@naver.com";
//		String regex = "[a-z]{3}[0-9]{1,3}";
//		==> a부터 z까지 3개, 0부터 9까지 1개 이상 3개 이하, 순서도 의미가 있다
//		==> ex) 문자열의 문자와 숫자가 섞여 있을경우 false가 나옴
//		String regex = "[a-z0-9]+";
//		==>a부터 z까지, 0부터 9까지 1개 이상
//		String regex = "\\w*";
//		String regex = ".*";
		
		// 아이디, 전화번호, 이메일주소의 유효성을 검사하는 정규표현식을 만들어주세요
		
		// 아이디
		String id = "[a-z0-9_-]{5,20}";
		
		// 전화번호
		String phoneNumber = "02|(010|011)-\\d{3,4}-\\d{4}";
		
		// 전화번호 : ^0\\d{1,3}-\\d{3,4}\\d{4}
		// 이메일주소
		String email = "[a-zA-z0-9]\\w{5,20}@[a-zA-z]+\\.[a-zA-z]{3}";
		
		// 이메일 : [a-z0-9_-}{5, 20}@[a-zA-Z]+\\.(?i)(com|net|org|[a-z]{2}\\.kr))$
		
		Pattern p = Pattern.compile(id);
		Pattern p1 = Pattern.compile(phoneNumber);
		Pattern p2 = Pattern.compile(email);
		
		Matcher m = p.matcher(str);
		Matcher m1 = p1.matcher(str1);
		Matcher m2 = p2.matcher(str2);
		
		System.out.println(m.matches());
		System.out.println(m1.matches());
		System.out.println(m2.matches());
		
	}
}
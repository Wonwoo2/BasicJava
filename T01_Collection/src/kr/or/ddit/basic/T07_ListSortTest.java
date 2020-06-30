package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T07_ListSortTest {

	public static void main(String[] args) {
		List<Member> memberList = new ArrayList<Member>();
		
		memberList.add(new Member(1, "홍길동", "010-1234-5678"));
		memberList.add(new Member(5, "변학도", "010-1123-1156"));
		memberList.add(new Member(9, "성춘향", "010-2341-3256"));
		memberList.add(new Member(3, "이순신", "010-5324-7214"));
		memberList.add(new Member(6, "강감찬", "010-2315-7678"));
		memberList.add(new Member(2, "일지매", "010-3233-1232"));
		
		System.out.println("정렬 전 : ");
		for (Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
		
		Collections.sort(memberList);	// 정렬하기
		
		System.out.println("이름의 오름차순으로 정렬 후 : ");
		for (Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
		
		Collections.shuffle(memberList); // 섞기
		System.out.println("섞은 후 : ");
		for (Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
		
		Collections.sort(memberList, new SortNumDesc()); // 회원번호의 내림차순으로 정렬
		System.out.println("회원번호의 내림차순으로 정렬 후 : ");
		for (Member member : memberList) {
			System.out.println(member);
		}
		System.out.println("---------------------------------");
	}
}

/*
 *  회원의 정보를 저장
 *  회원정보는 회원번호(int), 회원이름, 전화번호로 되어 있다.
 *  회원이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기
 */
class Member implements Comparable<Member> {
	private int num;		// 회원번호
	private String name;	// 회원이름
	private String tel;		// 전화번호

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	/**
	 * 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	 */
	@Override
	public int compareTo(Member member) {
		return getName().compareTo(member.getName());
	}
}

class SortNumDesc implements Comparator<Member> {
	@Override
	public int compare(Member first, Member second) {
		if(first.getNum() > second.getNum()) {
			return -1;	// 첫번째 객체 인자 값이 두번째 인자 값보다 클 경우 위치를 바꾸지 않는다.
		} else if(first.getNum() < second.getNum()) {
			return 1;	// 첫번째 객체 인자 값보다 두번째 인자 값이 클 경우 위치를 바꾼다.
		} else {
			return 0;	// 같을 경우 위치를 바꾸지 않는다.
		}
	}
	
	// Wrapper클래스에서 제공하는 메서드 이용하는 방법
	// 내림차순일 경우에는 -1을 곱해준다
	// return Integer.compare(first.getNum(), second.getNum()) * -1;
	// return new Integer(first.getNum()).compareTo(second.getNum()) * -1;
}
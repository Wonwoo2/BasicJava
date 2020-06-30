package kr.or.ddit.basic;

import java.util.*;

public class T17_HotelManagementTest {
	private Scanner scan;
	private Map<String, String> checkMap;
	
	public T17_HotelManagementTest() {
		scan = new Scanner(System.in);
		checkMap = new HashMap<>();
	}

	public static void main(String[] args) {
		new T17_HotelManagementTest().Open();
	}
	
	public void Open() {
		System.out.println("호텔 문을 열었습니다.");
		
		while(true) {
			showMenu();
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				checkStatus();
				break;
			case 4:
				close();
				break;
			}
		}
	}

	public void showMenu() {		
		System.out.println("=================================");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인");
		System.out.println("2. 체크아웃");
		System.out.println("3. 객실상태");
		System.out.println("4. 업무종료");		
		System.out.println("=================================");
		System.out.print("메뉴 선택 > ");
	}
	
	public void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNo = scan.next().trim();
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scan.next().trim();
		
		if(checkMap.get(roomNo) == null) {
			checkMap.put(roomNo, name);
		} else {
			System.out.println(roomNo + "방에는 이미 사람이 있습니다.");
		}
	}

	public void checkOut() {
		System.out.println("어느방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		String roomNo = scan.next().trim();
		
		if(checkMap.get(roomNo) == null) {
			System.out.println(roomNo + "방에는 체크인한 사람이 없습니다.");
			return;
		} else {
			checkMap.remove(roomNo);
			System.out.println("체크아웃 되었습니다.");
		}
	}
	
	public void checkStatus() {
		Set<String> checkIt = checkMap.keySet();
		
		if(checkIt.size() == 0) {
			System.out.println("체크인한 객실이 없습니다.");
			return;
		}
		
		Iterator<String> keySet = checkIt.iterator();
		
		while(keySet.hasNext()) {
			String key = keySet.next();
			System.out.println("방번호 : " + key + ", 투숙객 : " + checkMap.get(key));
		}
	}
	
	public void close() {
		System.out.println("=================================");
		System.out.println("\t호텔 문을 닫았습니다.");
		System.out.println("=================================");
		System.exit(0);
	}
}
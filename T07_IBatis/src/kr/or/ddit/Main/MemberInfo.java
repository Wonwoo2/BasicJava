package kr.or.ddit.Main;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/
public class MemberInfo {

	private IMemberService service;
	private Scanner scan;

	public MemberInfo() {
		service = MemberServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 자료 검색
				searchMember();
				break;
			case 5: // 전체 자료 출력
				showAllMember();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 자료 검색");
		System.out.println("  5. 전체 자료 출력");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 *  회원을 추가하는 메서드
	 */
	public void insertMember() {
		boolean chk = false;
		String memId;

		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 아이디 >> ");
			memId = scan.next();

			chk = service.isMember(memId);

			if (chk) {
				System.out.println("회원 ID가 " + memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력 하세요");
			}
		} while (chk);

		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 버퍼 비우기

		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();

		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);

		Object obj = service.insertMember(mv);
		
		if (obj == null) {
			System.out.println(memId + "회원 추가 성공");
		} else {
			System.out.println(memId + "회원 추가 실패");
		}
	}
	
	/**
	 *  회원을 삭제하는 메서드
	 */
	public void deleteMember() {
		String memId;

		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원 아이디 >> ");
		memId = scan.next();

		int cnt = service.deleteMember(memId);

		if (cnt > 0) {
			System.out.println("회원 삭제 성공");
		} else {
			System.out.println("회원 삭제 실패");
		}
	}

	/**
	 *  회원을 수정하는 메서드
	 */
	public void updateMember() {
		System.out.println();
		String memId = "";

		boolean chk = false;

		do {
			System.out.print("수정할 회원ID를 입력하세요. >> ");
			memId = scan.next();

			chk = service.isMember(memId);
			if (chk == false) {
				System.out.println(memId + "회원은 없는 회원입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력하세요.");
			}

		} while (chk == false);

		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원 이름 >> ");
		String memName = scan.next();

		System.out.print("새로운 회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine();
		System.out.print("새로운 회원 주소 >> ");
		String memAddr = scan.nextLine();

		MemberVO mv = service.getMember(memId);
		
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);

		int cnt = service.updateMember(mv);

		if (cnt > 0) {
			System.out.println(memId + "회원의 정보를 수정했습니다.");
		} else {
			System.out.println(memId + "회원의 정보 수정 실패!!!");
		}
	}
	
	/**
	 *  회원정보를 검색하는 메서드
	 */
	public void searchMember() {
		
		scan.nextLine();		// 입력버퍼 비우기
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("회원 ID >> ");
		String memId = scan.nextLine().trim();
		
		System.out.print("회원 이름 >> ");
		String memName = scan.nextLine().trim();
		
		System.out.print("회원 연락처 >> ");
		String memTel = scan.nextLine().trim();
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine().trim();
		
		MemberVO mv = new MemberVO();
		
		if(memId != null && !memId.equals("")) {
			mv.setMem_id(memId);
		}
		if(memName != null && !memName.equals("")) {
			mv.setMem_name(memName);
		}
		if(memTel != null && !memTel.equals("")) {
			mv.setMem_tel(memTel);
		}
		if(memAddr != null && !memAddr.equals("")) {
			mv.setMem_addr(memAddr);
		}
		
		List<MemberVO> memberList = service.getSearchMember(mv);
		
		System.out.println("==================== 회원 목록 ====================");
		System.out.println("회원아이디\t회원 이름\t\t회원 연락처\t\t회원 주소");
		System.out.println("===============================================");
		
		if(memberList == null || memberList.size() == 0) {
			System.out.println("검색한 자료가 없습니다.");
		} else {
			for(MemberVO member : memberList) {
				System.out.println(member.getMem_id() + "\t"
								+ member.getMem_name() + "\t\t"
								+ member.getMem_tel() + "\t\t"
								+ member.getMem_addr());
			}
			System.out.println("===============================================");
		}
	}

	/**
	 * 전체 회원 목록을 보여주는 메서드
	 */
	public void showAllMember() {

		List<MemberVO> memberList = service.getAllMemberList();

		System.out.println("================== 전체 회원 목록 ==================");
		System.out.println("회원아이디\t회원 이름\t\t회원 연락처\t\t회원 주소");

		System.out.println("===============================================");

		for (MemberVO mv : memberList) {
			System.out.println(
					mv.getMem_id() + "\t" + mv.getMem_name() + "\t\t" + mv.getMem_tel() + "\t\t" + mv.getMem_addr());
		}

		System.out.println("===============================================");
	}
	
	public static void main(String[] args) {
		MemberInfo memObj = new MemberInfo();
		memObj.start();
	}
}
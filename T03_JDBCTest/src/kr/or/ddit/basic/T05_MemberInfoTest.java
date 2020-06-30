package kr.or.ddit.basic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;

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
public class T05_MemberInfoTest {
	// Log4j를 이용한 로그를 남기기 위해 로거 생성
	private static final Logger sqlLogger = 
			Logger.getLogger("log4jexam.sql.Query");
	private static final Logger paramLogger =
			Logger.getLogger("log4jexam.sql.Parameter");
	private static final Logger resultLogger =
			Logger.getLogger(T05_MemberInfoTest.class);
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	String[] col = {"mem_name", "mem_tel", "mem_addr" };
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertMember();
					break;
				case 2 :  // 자료 삭제
					deleteMember();
					break;
				case 3 :  // 자료 수정
					updateMember();
					break;
				case 4 :  // 전체 자료 출력
					showAllMember();
					break;
				case 5 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}
	
	public void showAllMember() {
		try {
			conn = DBUtil2.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM mymember";
			rs = stmt.executeQuery(sql);
			
			System.out.println("=== 전체 회원 목록 ===");
			System.out.println("회원아이디\t회원 이름\t\t회원 연락처\t\t회원 주소");
			while(rs.next()) {
				System.out.println(rs.getString("mem_id") + "\t" + rs.getString("mem_name") 
								+ "\t\t" + rs.getString("mem_tel") + "\t" + rs.getString("mem_addr"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void updateMember() {
		boolean chk = false;
		String memId;

		while(true) {
			
			System.out.println();
			System.out.println("수정할 회원 정보를 입력하세요.");
			System.out.print("회원 아이디 : (뒤로가기 : 0)");
			memId = scan.next();
			
			if(memId.equals("0")) {
				break;
			}

			chk = getMember(memId);
			if(chk) {
				System.out.println("수정할 데이터를 입력하세요");
				System.out.println("1. 이름 2. 연락처 3. 주소");
				int choice = scan.nextInt();
				switch(choice) {
				case 1 :
					scan.nextLine();
					System.out.print("이름 입력 >> ");
					String memName = scan.next();
					setMember(memId, memName, col[choice - 1]);
					break;
				case 2 :
					scan.nextLine();
					System.out.print("연락처 입력 >> ");
					String memTel = scan.next();
					setMember(memId, memTel, col[choice - 1]);
					break;
				case 3 :
					scan.nextLine();
					System.out.print("연락처 입력 >> ");
					String memAddr = scan.nextLine();
					setMember(memId, memAddr, col[choice - 1]);
					break;
				default :
					System.out.println("잘못입력하셨습니다.");
				}
			} else {
				System.out.println(memId + "인 회원 아이디가 존재 하지 않습니다.");
			}
		}
	}

	public void setMember(String memId, String data, String col) {
		
		String sql = "";
		
		try {
			conn = DBUtil.getConnection();
			sql = "UPDATE mymember SET " + col + " = ? " + "WHERE mem_id = " + memId;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data);

			int cnt = pstmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("회원 정보 수정 완료");
			} else {
				System.out.println("회원 정보 수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	public void deleteMember() {
		boolean chk = false;
		String memId;
		

		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("회원 아이디 : ");
		memId = scan.next();
		
		if(memId.equals("0")) {
			return;
		}
			
		chk = getMember(memId);
		
		if(chk) {
			try {
				conn = DBUtil.getConnection();
				
				String sql = "DELETE FROM mymember "
						+ "WHERE mem_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0) {
					System.out.println(memId + " 회원 삭제 성공");
				} else {
					System.out.println(memId + " 회원 삭제 실패");
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		} else {
			System.out.println("회원 ID가 " + memId + "인 회원은 존재하지 않습니다.");
		}
	}

	public void insertMember() {
		boolean chk = false;
		String memId;
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 아이디 : ");
			memId = scan.next();
			
			chk = getMember(memId);
			
			if(chk) {
				System.out.println("회원 ID가 " + memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력 하세요");
			}
		}while(chk == true);
		
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();	// 버퍼 비우기
		
		System.out.print("회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "INSERT INTO mymember(mem_id, mem_name, mem_tel, mem_addr) "
					+ "VALUES (?, ?, ?, ?)";
			
			sqlLogger.debug("쿼리 : " + sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			paramLogger.debug("파라미터 : (" 
							+ memId + ", "
							+ memName + ", "
							+ memTel + ", "
							+ memAddr + ")");
			
			int cnt = pstmt.executeUpdate();
			
			resultLogger.info("결과 : " + cnt);
			
			if(cnt > 0) {
				System.out.println(memId + "회원 추가 성공");
			} else {
				System.out.println(memId + "회원 추가 실패");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
	}

	/**
	 * 회원ID를 이용하여 회원이 있는지 알려주는 메서드
	 * @param memId
	 * @return
	 */
	public boolean getMember(String memId) {
		boolean check = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT COUNT(*) AS cnt FROM mymember"
					+ " WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					check = true;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();	// 자원 반납
		}
		return check;
	}

	public void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}	
	}

	public static void main(String[] args) {
		T05_MemberInfoTest memObj = new T05_MemberInfoTest();
		memObj.start();
	}
}
package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import kr.or.ddit.util.DBUtil;


/* 호텔운영 프로그램 테이블 생성 스크립트 */
/*
create table hotel_mng (
    room_num number not null,  -- 방번호
    guest_name varchar2(10) not null -- 투숙객 이름
);
*/

public class T09_HotelManagementTest {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql = "";
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		new T09_HotelManagementTest().Open();
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
	
	public boolean checkRoom(int roomNo) {
		boolean check = false;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT COUNT(*) FROM hotel_mng WHERE room_num = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("COUNT(*)") > 0) {
					check = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 자원 반납
		}
		return check;
	}
	
	public void checkIn() {
		boolean check = false;
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNo = scan.nextInt();
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = scan.next();
		
		check = checkRoom(roomNo);
		if(check) {
			System.out.println(roomNo + "방에는 이미 사람이 있습니다.");
		} else {
			try {
				conn = DBUtil.getConnection();
				sql = "INSERT INTO hotel_mng VALUES(?, ?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNo);
				pstmt.setString(2, name);
				
				int cnt = pstmt.executeUpdate();
				if(cnt > 0) {
					System.out.println("체크인 되었습니다");
				} else {
					System.out.println("체크인할 수 없습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect(); // 자원 반납
			}
		}
	}

	public void checkOut() {
		boolean check = false;
		System.out.println("어느방에 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		int roomNo = scan.nextInt();
		check = checkRoom(roomNo);
		if (check) {
			try {
				conn = DBUtil.getConnection();
				sql = "DELETE FROM hotel_mng WHERE room_num = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, roomNo);
				
				int cnt = pstmt.executeUpdate();
				if(cnt > 0) {
					System.out.println("체크아웃 되었습니다.");
				} else {
					System.out.println("체크아웃 할 수 없습니다.");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect(); // 자원 반납
			}
		} else {
			System.out.println(roomNo + "방에는 체크인한 사람이 없습니다.");
		}
	}
	
	public void checkStatus() {
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM hotel_mng ORDER BY room_num";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs == null) {
				System.out.println("체크인한 객실이 없습니다.");
			} else {
				System.out.println("==================");
				System.out.println("방번호\t게스트이름");
				System.out.println("==================");
				while(rs.next()) {
					System.out.println(rs.getInt("room_num") + "\t" + rs.getString("guest_name"));
				}
				System.out.println("==================");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 자원 반납
		}
	}
	
	public void close() {
		System.out.println("=================================");
		System.out.println("\t호텔 문을 닫았습니다.");
		System.out.println("=================================");
		System.exit(0);
	}
	
	public void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}	
	}
}
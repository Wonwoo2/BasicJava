package kr.or.ddit.basic;

import java.sql.*;
import java.util.Scanner;

public class T04_JdbcTest {
	/*
	 *  lprod 테이블에 새로운 데이터 추가하기
	 *  
	 *  lprod_gu와 lprod_nm은 직접 입력받아 처리하고,
	 *  lprod_id는 현재의 lprid_id들 중 제일 큰값보다 1증가된 값으로 한다.
	 *  (기타사항 : lprod_gu도 중복되는지 검사한다)
	 */

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userID = "PC01";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userID, password);
			
			stmt = conn.createStatement();
			
			String sql = "SELECT lprod_id FROM lprod";
			
			rs = stmt.executeQuery(sql);
			int max = 0;
			while(rs.next()) {
				max = Math.max(max, rs.getInt("lprod_id"));
			}
			
			int lprod_id = max + 1;
			String lprod_gu = "";
			String lprod_nm = "";
			
			while(true) {
				sql = "SELECT lprod_gu FROM lprod";
				rs = stmt.executeQuery(sql);
				
				boolean flag = true;
				System.out.print("lprod_gu 입력 > ");
				lprod_gu = scan.next();
				
				while(rs.next()) {						
					if(lprod_gu.equals(rs.getString("lprod_gu"))) {
						System.out.println("중복된 lprod_gu입니다.");
						flag = false;
						break;
					}
				}
				
				if(flag) {
					break;
				}
			}
			
			System.out.print("lprod_nm 입력 > ");
			lprod_nm = scan.next();
			
			sql = "INSERT INTO lprod "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "VALUES('" + lprod_id +  "', '" + lprod_gu + "', '" + lprod_nm + "')";
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫 번째 반환 값 : " + cnt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 자원 반납
			if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		

	}
}
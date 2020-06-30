package kr.or.ddit.basic;

import java.sql.*;

/**
 *  insert 예제
 */
public class T03_JdbcTest {
	/*
	 *  lprod_id : 101		102		103
	 *  lprod_gu : N101		N102	N103
	 *  lprod_nm : 농산물		수산물	축산물
	 *  
	 *  위 3개의 자료를 추가하기
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userID = "PC01";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userID, password);
			
			
			/*stmt = conn.createStatement();
			
			// SQL문이 SELECT문이 아닐 경우에는 executeUpdate() 메서드를 사용한다.
			// executeUpdate() 메서드는 실행에 성공한 레코드 수를 반환한다.
			String sql = "INSERT INTO lprod "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "VALUES(101, 'N101', '농산물')";
			
			int cnt = stmt.executeUpdate(sql);
			System.out.println("첫 번째 반환 값 : " + cnt);
			
			sql = "INSERT INTO lprod "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "VALUES(102, 'N102', '수산물')";
			
			cnt = stmt.executeUpdate(sql);
			System.out.println("두 번째 반환 값 : " + cnt);
			
			sql = "INSERT INTO lprod "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "VALUES(103, 'N103', '축산물')";
			
			cnt = stmt.executeUpdate(sql);
			System.out.println("세 번째 반환 값 : " + cnt);*/
			
			// PreparedStatement 객체 생성 => Connection객체를 이용한다.
			String sql = "INSERT INTO lprod "
					+ "(lprod_id, lprod_gu, lprod_nm) "
					+ "VALUES(?, ?, ?)";
			// PreparedStatement 객체를 생성할 때 SQL문을 넣어서 생성한다.
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문의 물음표(?) 자리에 들어가 데이터를 셋팅한다.
			// 형식) pstmt.set자료형(물음표순번, 데이터)
			//		물음표 순번은 1번부터 시작한다.
			pstmt.setInt(1, 101);
			pstmt.setString(2, "N101");
			pstmt.setString(3, "농산물");
			
			// 데이터를 세팅한 후 쿼리문을 실행한다.
			int cnt = pstmt.executeUpdate();
			System.out.println("첫 번째 반환 값 : " + cnt);
			
			pstmt.setInt(1, 102);
			pstmt.setString(2, "N102");
			pstmt.setString(3, "수산물");
			
			cnt = pstmt.executeUpdate();
			System.out.println("두 번째 반환 값 : " + cnt);
			
			pstmt.setInt(1, 13);
			pstmt.setString(2, "N103");
			pstmt.setString(3, "축산물");
			
			cnt = pstmt.executeUpdate();
			System.out.println("첫 번째 반환 값 : " + cnt);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} finally {
			if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
	}
}
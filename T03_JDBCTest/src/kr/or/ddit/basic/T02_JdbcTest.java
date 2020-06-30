package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * SELECT 예제
 * @author PC-01
 */
public class T02_JdbcTest {
	/*
	 *  문제1) 사용자로부터 lprod_id값을 입력 받아 입력한 값보다 lprod_id가 큰 자료들을 출력하시오.
	 *  
	 *  문제2) lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰값 사이의 자료를 출력하시오.
	 */

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String userID = "PC01";
			String password = "java";
			
			conn = DriverManager.getConnection(url, userID, password);
			
			stmt = conn.createStatement();
			System.out.print("입력 > ");
			int input = scan.nextInt();
			
			String sql = "SELECT * FROM lprod WHERE lprod_id > " + input;
			rs = stmt.executeQuery(sql);
			
			
			System.out.println("=== " + input + "보다 큰 lprod_id 데이터 ===");
			System.out.println("lprod_id\tlprod_gu\tlprod_nm");
			while(rs.next()) {
				System.out.println(rs.getInt("lprod_id") + "\t\t" + rs.getString("lprod_gu") + "\t\t" + rs.getString("lprod_nm"));
			}
			System.out.println("===========================");
			
			System.out.print("두 개의 값 입력 > ");
			int input1 = scan.nextInt();
			int input2 = scan.nextInt();
			
			int max = Math.max(input1, input2);
			int min = Math.min(input1, input2);
			
			sql = "SELECT * FROM lprod WHERE lprod_id >= " + min
					+ "AND lprod_id <= " + max;
			
			rs = stmt.executeQuery(sql);
			System.out.println("=== " + min + "부터 " + max + "사이의 lprod_id 데이터 ===");
			System.out.println("lprod_id\tlprod_gu\tlprod_nm");
			while(rs.next()) {
				System.out.println(rs.getInt("lprod_id") + "\t\t" + rs.getString("lprod_gu") + "\t\t" + rs.getString("lprod_nm"));
			}
			System.out.println("===========================");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
			if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		

	}
}
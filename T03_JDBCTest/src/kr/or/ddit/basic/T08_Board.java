package kr.or.ddit.basic;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class T08_Board {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql = "";
	private Scanner scan = new Scanner(System.in); 
	
	public static void main(String[] args) {
		new T08_Board().board();
	}

	public void board() {
		int choice;
		do {
			showMenu();
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				boardList();
				break;
			case 2:
				boardWrite();
				break;
			case 3:
				boardUpdate();
				break;
			case 4:
				boardDelete();
				break;
			case 5:
				boardSearch();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while(choice != 6);
	}

	public void showMenu() {
		System.out.println();
		System.out.println("========= 게시판 =========");
		System.out.println("-----------------------");
		System.out.println("  1. 게시판 목록");
		System.out.println("  2. 게시판 작성");
		System.out.println("  3. 게시판 수정");
		System.out.println("  4. 게시판 삭제");
		System.out.println("  5. 게시판 검색");
		System.out.println("  6. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴를 고르세요 >> ");
	}
	
	public void boardList() {
		int choice;
		boolean check = false;
		
		do {
			showList();
			
			System.out.print("확인할 게시글 번호 입력 (뒤로가기 : 0) >> ");
			choice = scan.nextInt();
			
			check = getBoardNo(choice);
			
			if(check) {
				boardRead(choice);	
			} else {
				System.out.println("존재하지 않는 게시글 입니다.");
				System.out.println("다시 입력해주세요.");
			}
			
			
			
		} while(choice != 0);
		
	}
	
	public void boardRead(int choice) {
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT board_no, board_title, board_writer,  TO_CHAR(board_date,'yy/MM/dd HH24:mm:ss') AS board_date, board_content FROM jdbc_board "
					+ "WHERE board_no IN(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, choice);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("=========================================================");
				System.out.println("게시글 번호\t\t제목\t\t작성자\t작성일");
				System.out.println("=========================================================");
				System.out.println(rs.getInt("board_no") + "\t\t" + rs.getString("board_title")
				+ "\t\t" + rs.getString("board_writer") + "\t" + rs.getString("board_date"));
				System.out.println("=========================================================");
				System.out.println("내용 : ");
				System.out.println(rs.getString("board_content"));
				System.out.println("=========================================================");
			}
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 자원 반납
		}
		
	}

	public void showList() {
		try {

			conn = DBUtil.getConnection();

			sql = "SELECT board_no, board_title, board_writer,  TO_CHAR(board_date,'yy/MM/dd HH24:mm:ss') AS board_date FROM jdbc_board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			
			System.out.println("====================== 게시판 목록 =======================");

			System.out.println("게시글번호\t제목\t\t작성자\t작성일");
			while(rs.next()) {
				System.out.println("======================================================");
				System.out.println(rs.getInt("board_no") + "\t" + rs.getString("board_title")
				+ "\t\t" + rs.getString("board_writer") + "\t" + rs.getString("board_date"));
			}
			System.out.println("========================================================");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 자원 반납
		}
	}
	

	public boolean getBoardNo(int boardNo) {
		boolean check = false;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT COUNT(*) FROM jdbc_board WHERE board_no IN(?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("COUNT(*)") > 0) {
					check = true;
				}
			}
			return check;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect(); // 자원 반납
		}
		return false;
	}
	
	public void boardWrite() {
		
		System.out.println("======================");
		System.out.print("제목 : ");
		String boardTitle = scan.next();
		System.out.println("======================");
		scan.nextLine();
		System.out.print("내용 : ");
		String boardContent = scan.nextLine();
		System.out.println("======================");
		System.out.print("작성자 : ");
		String boardWriter = scan.next();
		System.out.println("======================");

		
		try {
			
			conn = DBUtil.getConnection();
			
			sql = "INSERT INTO jdbc_board VALUES(board_seq.nextVal, ?, ?, SYSDATE, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardWriter);
			pstmt.setString(3, boardContent);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt > 0) {
				System.out.println("게시판 등록 성공");
			} else {
				System.out.println("게시판 등록 실패");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();	// 자원 반납
		}
	}

	public void boardUpdate() {
		int choice;
		boolean check = false;
		String boardTitle = "";
		String boardContent = "";
		do {
			showList();
			System.out.print("수정할 게시글 번호를 입력 >> (뒤로가기 : 0)");
			choice = scan.nextInt();
			
			check = getBoardNo(choice);
			if (check) {
				System.out.print("수정할 제목 입력 >> ");
				boardTitle = scan.next();

				scan.nextLine();
				System.out.print("수정할 내용 입력 >> ");
				boardContent = scan.nextLine();
				
				try {
					conn = DBUtil.getConnection();
					
					sql = "UPDATE jdbc_board SET board_title = ?, board_content = ? "
							+ "WHERE board_no = " + choice;
					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, boardTitle);
					pstmt.setString(2, boardContent);
					
					int cnt = pstmt.executeUpdate();
					
					if(cnt > 0) {
						System.out.println("게시판 수정 성공");
					} else {
						System.out.println("게시판 수정 실패");
					}
				} catch(SQLException e) {
					e.printStackTrace();
				} finally {
					disConnect();	// 자원 반납
				}
			}
		} while(choice != 0);
	}
	
	public void boardDelete() {
		int boardNo;
		do {
			showList();
			
			System.out.print("삭제할 게시글 번호 입력 >> (뒤로가기 : 0)");
			boardNo = scan.nextInt();
			
			try {
				
				conn = DBUtil.getConnection();
				
				sql = "DELETE FROM jdbc_board WHERE board_no IN(?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNo);
				
				int cnt = pstmt.executeUpdate();
				
				if(cnt > 0) {
					System.out.println("게시판 삭제 성공");
				} else {
					System.out.println("게시판 삭제 실패");
				}
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();	// 자원 반납
			}
			
			System.out.println();
		} while(boardNo != 0);
		
		
	}
	
	public void boardSearch() {
		int choice;

		do {
			showBoardSearchMenu();
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				writerSearchList();
				break;
			case 2:
				titleAndContentSearchList();
				break;
			case 3:
				System.out.println("뒤로 돌아갑니다.");
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while(choice != 3);
	}
	
	
	

	public void showBoardSearchMenu() {
		System.out.println("무엇으로 검색하시겠습니까?");
		System.out.println("1. 작성자");
		System.out.println("2. 제목 혹은 내용");
		System.out.println("3. 뒤로가기");
		System.out.print("선택 >>");
	}
	
	public void titleAndContentSearchList() {
		String search = "";
		while(true) {
			scan.nextLine();
			System.out.print("검색 >> (뒤로 가려면 '그만'을 입력하세요)");
			search = scan.nextLine();
			if(search.equals("그만")) {
				break;
			}
			try {
				conn = DBUtil.getConnection();
				sql = "SELECT board_no, board_title, board_writer, TO_CHAR(board_date,'yy/MM/dd HH24:mm:ss') AS board_date, board_content FROM jdbc_board";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				System.out.println("====================== 게시판 목록 =======================");
				System.out.println("게시글번호\t제목\t\t작성자\t작성일");
				while (rs.next()) {
					if (rs.getString("board_title").contains(search)
							|| rs.getString("board_content").contains(search)) {
						System.out.println("======================================================");
						System.out.println(rs.getInt("board_no") + "\t" + rs.getString("board_title") + "\t\t"
								+ rs.getString("board_writer") + "\t" + rs.getString("board_date"));
					}
				}
				System.out.println("========================================================");
				System.out.print("확인할 게시글 번호 입력 >> ");
				int choice = scan.nextInt();
				boardRead(choice);
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();	// 자원 반납
			}
		} 
	}
	
	public void writerSearchList() {
		String search = "";
		while(true) {
			scan.nextLine();
			System.out.print("검색 >> (뒤로 가려면 '그만'을 입력하세요)");
			search = scan.nextLine();
			if(search.equals("그만")) {
				break;
			}
			try {
				conn = DBUtil.getConnection();
				sql = "SELECT board_no, board_title, board_writer, TO_CHAR(board_date,'yy/MM/dd HH24:mm:ss') AS board_date, board_content FROM jdbc_board";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				System.out.println("====================== 게시판 목록 =======================");
				System.out.println("게시글번호\t제목\t\t작성자\t작성일");
				while (rs.next()) {
					if (rs.getString("board_writer").contains(search)) {
						System.out.println("======================================================");
						System.out.println(rs.getInt("board_no") + "\t" + rs.getString("board_title") + "\t\t"
								+ rs.getString("board_writer") + "\t" + rs.getString("board_date"));
					}
				}
				System.out.println("========================================================");
				System.out.print("확인할 게시글 번호 입력 >> ");
				int choice = scan.nextInt();
				boardRead(choice);
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();	// 자원 반납
			}
		} 
	}

	public void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}	
	}
}
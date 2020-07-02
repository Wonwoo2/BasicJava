package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertBoard(BoardVO bd) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "INSERT INTO jdbc_board VALUES(board_seq.nextVal, ?, ?, SYSDATE, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bd.getBoard_title());
			pstmt.setString(2, bd.getBoard_writer());
			pstmt.setString(3, bd.getBoard_content());
			
			cnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	@Override
	public boolean getBoard(int boardNo) {
		boolean check = false;
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELECT COUNT(*) AS cnt FROM jdbc_board "
					+ "WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
			if(cnt > 0) {
				check = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return check;
	}
	
	@Override
	public Date getBoardDate(ResultSet rs, String column) throws SQLException {
		Timestamp time = rs.getTimestamp(column);
		return new Date(time.getTime());
	}
	
	@Override
	public BoardVO readBoard(int boardNo) {
		BoardVO bd = new BoardVO();
		try {

			conn = DBUtil.getConnection();

			String sql = "SELECT * FROM jdbc_board "
					+ "WHERE board_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_writer = rs.getString("board_writer");
				Date board_date = getBoardDate(rs, "board_date");
				String board_content = rs.getString("board_content");

				bd.setBoard_no(board_no);
				bd.setBoard_title(board_title);
				bd.setBoard_writer(board_writer);
				bd.setBoard_date(board_date);
				bd.setBoard_content(board_content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return bd;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "SELECT * FROM jdbc_board ORDER BY board_date DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_writer = rs.getString("board_writer");
				Date board_date = getBoardDate(rs, "board_date");
				String board_content = rs.getString("board_content");
				
				BoardVO bd = new BoardVO();
				
				bd.setBoard_no(board_no);
				bd.setBoard_title(board_title);
				bd.setBoard_writer(board_writer);
				bd.setBoard_date(board_date);
				bd.setBoard_content(board_content);
				
				boardList.add(bd);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return boardList;
	}
	@Override
	public int updateBoard(BoardVO bd) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "UPDATE jdbc_board SET board_title = ?, "
					+ "board_content = ? "
					+ "WHERE board_no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bd.getBoard_title());
			pstmt.setString(2, bd.getBoard_content());
			pstmt.setInt(3, bd.getBoard_no());
			
			cnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	@Override
	public int deleteBoard(int boardNo) {
		boolean check = false;
		int cnt = 0;
		
		check = getBoard(boardNo);
		
		if(check) {
			try {
				
				conn = DBUtil.getConnection();
				
				String sql = "DELETE FROM jdbc_board "
						+ "WHERE board_no = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				cnt = pstmt.executeUpdate();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				disConnect();
			}
		}
		return cnt;
	}
	
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELECT * FROM jdbc_board WHERE 1=1";
			
			if(bd.getBoard_no() != 0) {
				sql += " AND board_no = ?";
			}
			if(bd.getBoard_title() != null && !bd.getBoard_title().equals("")) {
				sql += " AND board_title LIKE '%' || ? || '%'";
			}
			if(bd.getBoard_writer() != null && !bd.getBoard_writer().equals("")) {
				sql += " AND board_write LIKE '%' || ? || '%'";
			}
			if(bd.getBoard_content() != null && !bd.getBoard_content().equals("")) {
				sql += " AND board_write LIKE '%' || ? || '%'";
			}
			
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if(bd.getBoard_no() != 0) {
				pstmt.setInt(index++, bd.getBoard_no());
			}
			if(bd.getBoard_title() != null && !bd.getBoard_title().equals("")) {
				pstmt.setString(index++, bd.getBoard_title());
			}
			if(bd.getBoard_writer() != null && !bd.getBoard_writer().equals("")) {
				pstmt.setString(index++, bd.getBoard_writer());
			}
			if(bd.getBoard_content() != null && !bd.getBoard_content().equals("")) {
				pstmt.setString(index++, bd.getBoard_content());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int board_no = rs.getInt("board_no");
				String board_title = rs.getString("board_title");
				String board_writer = rs.getString("board_writer");
				Date board_date = getBoardDate(rs, "board_date");
				String board_content = rs.getString("board_content");
				
				BoardVO board = new BoardVO();
				
				board.setBoard_no(board_no);
				board.setBoard_title(board_title);
				board.setBoard_writer(board_writer);
				board.setBoard_date(board_date);
				board.setBoard_content(board_content);
				
				boardList.add(board);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return boardList;
	}
	
	/**
	 *  자원 반납하는 메서드
	 */
	public void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}	
	}
}
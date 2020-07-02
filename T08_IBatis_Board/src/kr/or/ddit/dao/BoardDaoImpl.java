package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
	
	private static IBoardDao dao;
	private SqlMapClient smc;
	
	private BoardDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
	}
	
	public static IBoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	@Override
	public Object insertBoard(BoardVO bd) {
		Object obj = null;
		try {	
			obj = smc.insert("ibatis_board.insertBoard", bd);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public boolean isBoard(int boardNo) {
		boolean check = false;
		int cnt = 0;

		try {	
			cnt = (int) smc.queryForObject("ibatis_board.isBoard", boardNo);
			
			if(cnt > 0) {
				check = true;
			}			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO bd = new BoardVO();
		
		try {
			bd = (BoardVO)smc.queryForObject("ibatis_board.getBoard", boardNo);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return bd;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = smc.queryForList("ibatis_board.getBoardList");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
	@Override
	public int updateBoard(BoardVO bd) {
		Object obj = 0;
		
		try {
			obj = smc.update("ibatis_board.updateBoard", bd);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return (int)obj;
	}
	
	@Override
	public int deleteBoard(int boardNo) {
		int cnt = 0;		
		
		try {	
			cnt = smc.delete("ibatis_board.deleteBoard", boardNo);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<BoardVO> getSearchBoard(BoardVO bd) {
		List<BoardVO> boardList = new ArrayList<>();

		try {
			boardList = smc.queryForList("ibatis_board.searchBoard", bd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}
}
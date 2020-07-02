package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public int insertBoard(BoardVO bd) {
		return boardDao.insertBoard(bd);
	}

	@Override
	public boolean getBoard(int boardNo) {
		return boardDao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return boardDao.getAllBoardList();
	}

	@Override
	public int updateBoard(BoardVO bd) {
		return boardDao.updateBoard(bd);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return boardDao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> getSearchBoard(BoardVO bd) {
		return boardDao.getSearchBoard(bd);
	}

	@Override
	public BoardVO readBoard(int boardNo) {
		return boardDao.readBoard(boardNo);
	}
}
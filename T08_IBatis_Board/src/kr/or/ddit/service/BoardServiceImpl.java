package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	
	private IBoardDao boardDao;
	private static IBoardService service;
	
	private BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public Object insertBoard(BoardVO bd) {
		return boardDao.insertBoard(bd);
	}

	@Override
	public boolean isBoard(int boardNo) {
		return boardDao.isBoard(boardNo);
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
	public BoardVO getBoard(int boardNo) {
		return boardDao.getBoard(boardNo);
	}
}
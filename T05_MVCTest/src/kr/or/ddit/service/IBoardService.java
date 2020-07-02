package kr.or.ddit.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import kr.or.ddit.vo.BoardVO;

/**
 * DAO객체를 이용하여 CRUD작업을 수행하는 Service의 interface
 * @author PC-01
 */
public interface IBoardService {
	/**
	 * BoardVO에 담겨진 자료 DB에 insert 하는 메서드
	 * @param bd DB에 insert할 자료가 저장된 BoardVO 객체
	 * @return
	 */
	public int insertBoard(BoardVO bd);
	
	/**
	 * 주어진 게시판이 존재하는지 여부를 알아내는 메서드
	 * @param boardNo
	 * @return 해당 게시판 번호가 있으면 true, 없으면 false
	 */
	public boolean getBoard(int boardNo);
	
	/**
	 * 하나의 BoardVO 객체를 반환하는 메서드
	 * @param boardNo
	 * @return
	 */
	public BoardVO readBoard(int boardNo);
	
	/**
	 * DB의 jdbc_board 테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메서드 
	 * @return BoardVO 객체를 담고 있는 List객체
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 하나의 BoardVO자료를 이용하여 DB를 update하는 메서드
	 * @param bd update할 게시판 정보가 들어 있는 BoardVO 객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateBoard(BoardVO bd);
	
	/**
	 * 게시판 번호를 매개변수로 받아서 게시판을 삭제하는 메서드
	 * @param boardNo 삭제할 게시판 번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * BoardVO 객체를 매개변수로 받아서 해당하는
	 * 게시판을 List에 담아서 반환하는 메서드
	 * @param bd 검색한  내용에 해당하는 객체
	 * @return BoardVO 객체를 담고 있는 List객체
	 */
	public List<BoardVO> getSearchBoard(BoardVO bd);
}

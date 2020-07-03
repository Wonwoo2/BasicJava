package kr.or.ddit.exam2.dao;

import java.util.List;

import kr.or.ddit.exam2.vo.MemberVO;

public interface IMemberDao {
	/**
	 * MemberVO 객체를 파라미터로 받아 DB에 저장하기 위한 메서드
	 * @param mv
	 * @return 성공시 null 값 반환
	 */
	public MemberVO insertMember(MemberVO mv);
	
	/**
	 * 수정한 MemberVO 객체를 넘겨 받아 DB 데이터를 수정하는 메서드
	 * @param mv
	 * @return 성공한 레코드 수만큼 정수값 반환
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 삭제할 객체의 id를 파라미터로 받아 DB 데이터를 삭제하는 메서드
	 * @param mem_id
	 * @return 성공한 레코드 수만큼 정수값 반환
	 */
	public int deleteMember(String mem_id);
	
	/**
	 * 전체 MemberVO 리스트 반환하는 메서드
	 * @return List<MemberVO>
	 */
	public List<MemberVO> getMemberList();
	
	/**
	 * 하나의 MemberVO 정보를 반환하는 메서드
	 * @param mem_id
	 * @return MemberVO 객체 반환
	 */
	public MemberVO getMember(String mem_id);
	
	/**
	 * 회원아이디를 매개변수로 받아 DB에 중복되는 아이디가 있는지 검사하는 메서드
	 * @param mem_id
	 * @return 중복된 데이터가 있으면 0이상의 정수 값이 반환되고 없으면 0이 반환
	 */
	public int isMember(String mem_id);
}
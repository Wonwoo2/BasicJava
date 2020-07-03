package kr.or.ddit.exam2.service;

import java.util.List;

import kr.or.ddit.exam2.vo.MemberVO;

public interface IMemberService {
	/**
	 * MemberVO 객체를 파라미터로 받아 dao로 전달하는 메서드
	 * @param mv
	 * @return 성공시 null 값 반환
	 */
	public MemberVO insertMember(MemberVO mv);
	
	/**
	 * 수정할 MemberVO 객체를 넘겨 받아 dao로 전달하는 메서드
	 * @param mv
	 * @return 성공한 레코드 수만큼 정수값 반환
	 */
	public int updateMember(MemberVO mv);
	
	/**
	 * 삭제할 객체의 id를 파라미터로 받아 dao로 전달하는 메서드
	 * @param mem_id
	 * @return 성공한 레코드 수만큼 정수값 반환
	 */
	public int deleteMember(String mem_id);
	
	/**
	 * 전체 MemberVO 리스트를 얻어오기 위해 dao로 요청하는 메서드
	 * @return List<MemberVO> 반환
	 */
	public List<MemberVO> getMemberList();
	
	/**
	 * 하나의 MemberVO를 반환하는 메서드
	 * @param mem_id
	 * @return MemberVO 객체 반환
	 */
	public MemberVO getMember(String mem_id);
	
	/**
	 *  회원아이디 중복검사를 dao로 요청하는 메서드
	 * @param mem_id
	 * @return 중복 데이터가 있을시 0이상, 없을시 0이 반환
	 */
	public int isMember(String mem_id);
}
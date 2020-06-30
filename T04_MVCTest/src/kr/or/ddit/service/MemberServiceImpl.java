package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	// 사용할 DAO의 객체 변수를 선언한다.
	private IMemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public int insertMember(MemberVO mv) {
		return memberDao.insertMember(mv);
	}

	@Override
	public boolean getMember(String memId) {
		return memberDao.getMember(memId);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memberDao.getAllMemberList();
	}

	@Override
	public int updateMember(MemberVO mv) {
		return memberDao.updateMember(mv);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		return memberDao.getSearchMember(mv);
	}
}
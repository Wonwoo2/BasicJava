package kr.or.ddit.exam2.service;

import java.util.List;

import kr.or.ddit.exam2.dao.IMemberDao;
import kr.or.ddit.exam2.dao.MemberDaoImpl;
import kr.or.ddit.exam2.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static IMemberService service;
	
	public MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		if(service == null) {
			service = new MemberServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO insertMember(MemberVO mv) {
		return dao.insertMember(mv);
	}

	@Override
	public int updateMember(MemberVO mv) {
		return dao.updateMember(mv);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public MemberVO getMember(String mem_id) {
		return dao.getMember(mem_id);
	}

	@Override
	public int isMember(String mem_id) {
		return dao.isMember(mem_id);
	}
}
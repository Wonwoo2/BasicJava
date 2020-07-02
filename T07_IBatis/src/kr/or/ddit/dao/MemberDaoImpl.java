package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao dao;
	
	private SqlMapClient smc;
	
	private MemberDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	@Override
	public Object insertMember(MemberVO mv) {
		Object obj = 0;
		try {
			obj = smc.insert("memberInfo.insertMember", mv);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public boolean isMember(String memId) {
		boolean check = false;
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("memberInfo.isMember", memId);
			if(cnt > 0) {
				check = true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return check;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		MemberVO mv = new MemberVO();
		try {
			mv = (MemberVO) smc.queryForObject("memberInfo.getMember", memId);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return mv;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memberList = new ArrayList<>();
		try {
			memberList = smc.queryForList("memberInfo.getMemberList");

		} catch(SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("memberInfo.updateMember", mv);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("memberInfo.deleteMember", memId);		
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			memberList = smc.queryForList("memberInfo.getSearchMember", mv);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
}
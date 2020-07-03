package kr.or.ddit.exam2.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam2.util.DBUtil;
import kr.or.ddit.exam2.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static IMemberDao dao;
	private SqlMapClient smc;
	
	public MemberDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
	}
	
	public static IMemberDao getInstance() {
		if(dao == null) {
			dao = new MemberDaoImpl();
		}
		return dao;
	}
	
	@Override
	public MemberVO insertMember(MemberVO mv) {
		MemberVO memVo = null;
		try {
			memVo = (MemberVO) smc.insert("member.insertMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVo;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			cnt = smc.update("member.updateMember", mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;
		try {
			cnt = smc.delete("member.deleteMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	} 
	
	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = smc.queryForList("member.getMemberList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public MemberVO getMember(String mem_id) {
		MemberVO memVo = new MemberVO();
		
		try {
			memVo = (MemberVO) smc.queryForObject("member.getMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memVo;
	}

	@Override
	public int isMember(String mem_id) {
		int cnt = 0;
		try {
			cnt = (int) smc.queryForObject("member.isMember", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
}
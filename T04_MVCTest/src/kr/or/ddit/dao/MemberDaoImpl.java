package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "INSERT INTO mymember(mem_id, mem_name, mem_tel, mem_addr) "
					+ "VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_id());
			pstmt.setString(2, mv.getMem_name());
			pstmt.setString(3, mv.getMem_tel());
			pstmt.setString(4, mv.getMem_tel());
			
			cnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public boolean getMember(String memId) {
		boolean check = false;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT COUNT(*) AS cnt FROM mymember"
					+ " WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			int cnt = 0;
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
				if(cnt > 0) {
					check = true;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();	// 자원 반납
		}
		return check;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memberList = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT * FROM mymember";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memberID = rs.getString("mem_id");
				String memberName = rs.getString("mem_name");
				String memberTel = rs.getString("mem_tel");
				String memberAddr = rs.getString("mem_addr");
				
				MemberVO mv = new MemberVO();
				mv.setMem_id(memberID);
				mv.setMem_name(memberName);
				mv.setMem_tel(memberTel);
				mv.setMem_addr(memberAddr);
				
				memberList.add(mv);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return memberList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "UPDATE mymember SET mem_name = ?, "
						+ "mem_tel = ?, "
						+ "mem_addr = ? "
						+ "WHERE mem_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMem_name());
			pstmt.setString(2, mv.getMem_tel());
			pstmt.setString(3, mv.getMem_addr());
			pstmt.setString(4, mv.getMem_id());
			
			cnt = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "DELETE FROM mymember "
					+ "WHERE mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	
	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		List<MemberVO> memberList = new ArrayList<>();
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "SELECT * FROM mymember where 1=1";
			
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				sql += " AND mem_id = ? ";
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				sql += " AND mem_name = ? ";
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				sql += " AND mem_tel = ? ";
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				sql += " AND mem_addr LIKE '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			int index = 1;
			if(mv.getMem_id() != null && !mv.getMem_id().equals("")) {
				pstmt.setString(index++, mv.getMem_id());
			}
			if(mv.getMem_name() != null && !mv.getMem_name().equals("")) {
				pstmt.setString(index++, mv.getMem_name());
			}
			if(mv.getMem_tel() != null && !mv.getMem_tel().equals("")) {
				pstmt.setString(index++, mv.getMem_tel());
			}
			if(mv.getMem_addr() != null && !mv.getMem_addr().equals("")) {
				pstmt.setString(index++, mv.getMem_addr());
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				MemberVO memberVo = new MemberVO();
				memberVo.setMem_id(memId);
				memberVo.setMem_name(memName);
				memberVo.setMem_tel(memTel);
				memberVo.setMem_addr(memAddr);
				
				memberList.add(memberVo);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return memberList;
	}
	
	// 자원반납하는 메서드
	public void disConnect() {
		if(rs != null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();} catch(SQLException e) {e.printStackTrace();}
		if(conn != null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}	
	}
}
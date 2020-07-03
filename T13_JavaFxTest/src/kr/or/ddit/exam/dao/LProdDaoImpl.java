package kr.or.ddit.exam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam.util.DBUtil;
import kr.or.ddit.exam.vo.LProdVO;

public class LProdDaoImpl implements ILProdDao{

	private static ILProdDao dao;
	private SqlMapClient smc;
	
	private LProdDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
	}
	
	public static ILProdDao getInstance() {
		if(dao == null) {
			dao = new LProdDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<LProdVO> getLProdList() {
		List<LProdVO> lProdList = new ArrayList<>();
		
		try {
			lProdList = smc.queryForList("ibatis_lproduct.getLProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lProdList;
	}
}
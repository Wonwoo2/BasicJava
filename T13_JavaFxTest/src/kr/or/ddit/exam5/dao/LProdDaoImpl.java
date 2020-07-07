package kr.or.ddit.exam5.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam5.util.DBUtil;
import kr.or.ddit.exam5.vo.LProd;

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
	public List<LProd> getLProdList() {
		List<LProd> lProdList = new ArrayList<>();
		
		try {
			lProdList = smc.queryForList("lprod.getLProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lProdList;
	}
}
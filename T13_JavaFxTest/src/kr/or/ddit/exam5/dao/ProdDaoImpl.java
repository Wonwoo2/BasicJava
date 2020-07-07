package kr.or.ddit.exam5.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam5.util.DBUtil;
import kr.or.ddit.exam5.vo.Prod;

public class ProdDaoImpl implements IProdDao {
	private static IProdDao dao;
	private SqlMapClient smc;
	List<Prod> prodList;
	
	private ProdDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
	}
	
	public static IProdDao getInstance() {
		if(dao == null) {
			dao = new ProdDaoImpl();
		}
		return dao;
	}

	@Override
	public List<Prod> getIsProductList(String lprod_lgu) {
		
		try {
			prodList = smc.queryForList("prod.getIsProdList", lprod_lgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}

	@Override
	public List<Prod> getProdList() {
		
		try {
			prodList = smc.queryForList("prod.getProdList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}

	@Override
	public List<Prod> getCurrentPageList(Map<String, Integer> param) {
		try {
			prodList = smc.queryForList("prod.getCurrentPageList", param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}
}
package kr.or.ddit.exam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam.util.DBUtil;
import kr.or.ddit.exam.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	private static IProdDao dao;
	private SqlMapClient smc;
	
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
	public List<ProdVO> getIsProductList(String lprod_lgu) {
		List<ProdVO> prodList = new ArrayList<>();
		
		try {
			prodList = smc.queryForList("ibatis_product.getIsProdList", lprod_lgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}
}
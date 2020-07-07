package kr.or.ddit.exam3.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.exam3.util.DBUtil;
import kr.or.ddit.exam3.vo.ZipVO;

public class ZipDaoImpl implements IZipDao{
	private static IZipDao dao;
	private SqlMapClient smc;
	private List<ZipVO> zipList;
	
	public ZipDaoImpl() {
		smc = DBUtil.readXML("sqlMapConfig.xml");
		zipList = new ArrayList<>();
	}
	
	public static IZipDao getInstance() {
		if(dao == null) {
			dao = new ZipDaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<ZipVO> getDongZipList(String dong) {
		try {
			zipList = smc.queryForList("zip.getDongZipList", dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipList;
	}

	@Override
	public List<ZipVO> getZipCodeList(String zipCode) {
		try {
			zipList = smc.queryForList("zip.getZipCodeList", zipCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zipList;
	}

}
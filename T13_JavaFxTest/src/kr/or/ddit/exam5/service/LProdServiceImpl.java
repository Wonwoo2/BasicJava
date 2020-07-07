package kr.or.ddit.exam5.service;

import java.util.List;

import kr.or.ddit.exam5.dao.ILProdDao;
import kr.or.ddit.exam5.dao.LProdDaoImpl;
import kr.or.ddit.exam5.vo.LProd;

public class LProdServiceImpl implements ILProdService {
	private ILProdDao dao;
	private static ILProdService service;
	
	private LProdServiceImpl() {
		dao = LProdDaoImpl.getInstance();
	}
	
	public static ILProdService getInstance() {
		if(service == null) {
			service = new LProdServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<LProd> getLProdList() {
		return dao.getLProdList();
	}
}

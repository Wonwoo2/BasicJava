package kr.or.ddit.exam.service;

import java.util.List;

import kr.or.ddit.exam.dao.ILProdDao;
import kr.or.ddit.exam.dao.LProdDaoImpl;
import kr.or.ddit.exam.vo.LProdVO;

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
	public List<LProdVO> getLProdList() {
		return dao.getLProdList();
	}
}

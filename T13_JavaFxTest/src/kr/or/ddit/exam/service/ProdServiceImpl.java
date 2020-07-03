package kr.or.ddit.exam.service;

import java.util.List;

import kr.or.ddit.exam.dao.IProdDao;
import kr.or.ddit.exam.dao.ProdDaoImpl;
import kr.or.ddit.exam.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	private IProdDao dao;
	private static IProdService service;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) {
			service = new ProdServiceImpl();
		}
		return service;
	}

	@Override
	public List<ProdVO> getIsProductList(String lgrod_lgu) {
		return dao.getIsProductList(lgrod_lgu);
	}
}
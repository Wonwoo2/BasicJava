package kr.or.ddit.exam5.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.exam5.dao.IProdDao;
import kr.or.ddit.exam5.dao.ProdDaoImpl;
import kr.or.ddit.exam5.vo.Prod;

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
	public List<Prod> getIsProductList(String lgrod_lgu) {
		return dao.getIsProductList(lgrod_lgu);
	}

	@Override
	public List<Prod> getProdList() {
		return dao.getProdList();
	}

	@Override
	public List<Prod> getCurrentPageList(Map<String, String> param) {
		return dao.getCurrentPageList(param);
	}
}
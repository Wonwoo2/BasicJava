package kr.or.ddit.exam3.service;

import java.util.List;

import kr.or.ddit.exam3.dao.IZipDao;
import kr.or.ddit.exam3.dao.ZipDaoImpl;
import kr.or.ddit.exam3.vo.ZipVO;

public class ZipServiceImpl implements IZipService {
	
	private IZipDao dao;
	private static IZipService service;
	
	public ZipServiceImpl() {
		dao = ZipDaoImpl.getInstance();
	}
	
	public static IZipService getInstance() {
		if(service == null) {
			service = new ZipServiceImpl();
		}
		return service;
	}

	@Override
	public List<ZipVO> getDongZipList(String dong) {
		return dao.getDongZipList(dong);
	}

	@Override
	public List<ZipVO> getZipCodeList(String zipCode) {
		return dao.getZipCodeList(zipCode);
	}
}
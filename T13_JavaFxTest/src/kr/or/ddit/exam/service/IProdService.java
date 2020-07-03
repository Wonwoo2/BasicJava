package kr.or.ddit.exam.service;

import java.util.List;

import kr.or.ddit.exam.vo.ProdVO;

public interface IProdService {
	
	/**
	 * 해당하는 Product 리스트 반환
	 * @return List<ProdVo>
	 */
	public List<ProdVO> getIsProductList(String lgrod_lgu);
	
}

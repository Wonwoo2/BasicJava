package kr.or.ddit.exam.dao;

import java.util.List;

import kr.or.ddit.exam.vo.ProdVO;

public interface IProdDao {
	
	/**
	 * 해당 Product 리스트 반환
	 * @return List<ProdVo>
	 */
	public List<ProdVO> getIsProductList(String lprod_lgu);

}
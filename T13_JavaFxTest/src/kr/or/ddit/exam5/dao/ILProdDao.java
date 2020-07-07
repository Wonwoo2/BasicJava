package kr.or.ddit.exam5.dao;

import java.util.List;

import kr.or.ddit.exam5.vo.LProd;

public interface ILProdDao {
	/**
	 * 전체 LProduct 리스트 반환
	 * @return List<LProd>
	 */
	public List<LProd> getLProdList();
}

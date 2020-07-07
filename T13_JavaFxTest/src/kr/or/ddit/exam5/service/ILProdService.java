package kr.or.ddit.exam5.service;

import java.util.List;

import kr.or.ddit.exam5.vo.LProd;

public interface ILProdService {
	/**
	 * 전체 LProduct 리스트 반환
	 * @return List<LProd>
	 */
	public List<LProd> getLProdList();
	
}
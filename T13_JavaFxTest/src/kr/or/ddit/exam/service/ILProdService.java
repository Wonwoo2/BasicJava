package kr.or.ddit.exam.service;

import java.util.List;

import kr.or.ddit.exam.vo.LProdVO;

public interface ILProdService {
	/**
	 * 전체 LProduct 리스트 반환
	 * @return List<LProdVo>
	 */
	public List<LProdVO> getLProdList();
	
}
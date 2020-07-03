package kr.or.ddit.exam.dao;

import java.util.List;

import kr.or.ddit.exam.vo.LProdVO;

public interface ILProdDao {
	/**
	 * 전체 LProduct 리스트 반환
	 * @return List<LProdVo>
	 */
	public List<LProdVO> getLProdList();
}

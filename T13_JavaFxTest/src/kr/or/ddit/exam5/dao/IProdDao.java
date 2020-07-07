package kr.or.ddit.exam5.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.exam5.vo.Prod;

public interface IProdDao {
	
	/**
	 * 해당 Product 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getIsProductList(String lprod_lgu);
	
	
	/**
	 * 전체 Product 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getProdList();
	
	/**
	 * 해당 페이지의 Prod 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getCurrentPageList(Map<String, Integer> param);

}
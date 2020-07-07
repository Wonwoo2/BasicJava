package kr.or.ddit.exam5.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.exam5.vo.Prod;

public interface IProdService {
	
	/**
	 * 해당하는 Product 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getIsProductList(String lgrod_lgu);
	
	/**
	 * 전체 Product 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getProdList();
	
	/**
	 * 해당 페이지의 Prod 리스트 반환
	 * @return List<Prod>
	 */
	public List<Prod> getCurrentPageList(Map<String, String> param);
}

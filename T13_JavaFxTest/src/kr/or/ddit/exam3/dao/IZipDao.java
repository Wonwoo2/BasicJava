package kr.or.ddit.exam3.dao;

import java.util.List;

import kr.or.ddit.exam3.vo.ZipVO;

public interface IZipDao {
	
	/**
	 * dong을 매개변수로 받아 DB에 저장되어 있는 dong에 해당하는 ZIPTB 데이터
	 * 리스트를 반환하는 메서드
	 * @param dong
	 * @return dong에 해당하는 List<ZipVo> 객체 반환
	 */
	public List<ZipVO> getDongZipList(String dong);
	
	
	/**
	 * zipCode를 매개변수로 받아 DB에 저장되어 있는 zipCode에 해당하는 ZIPTB 데이터
	 * 리스트를 반환하는 메서드
	 * @param zipCode
	 * @return zipCode에 해당하는 List<ZipVO> 객체 반환
	 */
	public List<ZipVO> getZipCodeList(String zipCode);
}
package kr.or.ddit.exam3.service;

import java.util.List;

import kr.or.ddit.exam3.vo.ZipVO;

public interface IZipService {
	
	/**
	 * 컨트롤러로부터 받은 dong 매개변수를 dao로 전달하는 메서드
	 * @param dong
	 * @return dao로부터 전달 받은 List<ZipVO> 객체 반환
	 */
	public List<ZipVO> getDongZipList(String dong);
	
	/**
	 * 컨트롤러로부터 받은 zipCode 매개변수를 dao로 전달하는 메서드
	 * @param zipCode
	 * @return dao로부터 전달 받은 List<ZipVO> 객체 반환
	 */
	public List<ZipVO> getZipCodeList(String zipCode);
}
package kr.or.ddit.rmi.vo;

import java.io.Serializable;

/**
 * 파일 전송용 VO 클래스 
 */
public class FileInfoVO implements Serializable {
	private String fileNmae;		// 파일명
	private byte[] fileData;		// 파일내용
	
	public String getFileNmae() {
		return fileNmae;
	}

	public void setFileNmae(String fileNmae) {
		this.fileNmae = fileNmae;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
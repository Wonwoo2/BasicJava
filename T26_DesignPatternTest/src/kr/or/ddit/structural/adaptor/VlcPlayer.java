package kr.or.ddit.structural.adaptor;

public class VlcPlayer implements advancedMediaPlayer{

	@Override
	public void playMp4(String fileName) {
	}
	
	@Override
	public void playVlc(String fileName) {
		System.out.println("VLC파일 실행 중... 파일명 : " + fileName);
	}
	
}

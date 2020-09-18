package kr.or.ddit.structural.adaptor;

public class Mp4Player implements advancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("MP4파일 실행 중... 파일명 : " + fileName);
	}
}

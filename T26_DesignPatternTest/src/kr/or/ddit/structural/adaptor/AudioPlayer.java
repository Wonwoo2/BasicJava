package kr.or.ddit.structural.adaptor;

public class AudioPlayer implements MediaPlayer{

	MediaAdaptor mediaAdaptor;
	
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("mp3파일 실행중... 파일명 : " + fileName);
		}else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			mediaAdaptor = new MediaAdaptor(audioType);
			mediaAdaptor.play(audioType, fileName);
		}else {
			System.out.println("지원하지 않는 타입의 미디어 파일입니다 : " + audioType);
		}
	}
}

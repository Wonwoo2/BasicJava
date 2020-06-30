package e_oop;

import useful.ScanUtil;

// 과제 : 어떤 대상을 가지고 TV클래스와 같이 구현하기
public class TV {
	boolean power = false;
	int channel = 1;
	int volume = 0;

	void powerOn() {
		power = true;
		System.out.println("TV가 켜졌습니다");
	}

	void poowerOff() {
		power = false;
		System.out.println("TV가 꺼졌습니다");
	}

	void channelChange(int channel) {
		this.channel = channel;
		if (this.channel > 0 && this.channel < 301) {
			System.out.println("체널 " + this.channel + "번으로 이동합니다");
		}
	}

	void channelUp() {
		channel += 1;
		if (channel == 301) {
			channel = 1;
		}
		System.out.println("현재 체널은 " + channel + "번 입니다");
	}

	void channelDown() {
		channel -= 1;
		if (channel == 0) {
			channel = 300;
		}
		System.out.println("현재 체널은 " + channel + "번 입니다");
	}

	void volumeUp() {
		boolean volumePlusLimit = false;
		if (volume == 40) {
			volumePlusLimit = true;
		}
		if (volumePlusLimit == false) {
			volume += 1;
			System.out.println("볼륨이 1증가했습니다.");
			System.out.println("현재 볼륨은 " + volume + "입니다.");
		}
	}

	void volumeDown() {
		boolean volumeMinusLimit = false;
		if (volume == 0) {
			volumeMinusLimit = true;
		}
		if (volumeMinusLimit == false) {
			volume -= 1;
			System.out.println("볼륨이 1감소했습니다.");
			System.out.println("현재 볼륨은 " + volume + "입니다.");
		}
	}

	public static void main(String[] args) {
		TV tv = new TV();

		int cmd = 1;

		while (cmd != 0) {
			System.out.print("명령 입력 > 1.TV켜기 2.TV끄기 3.채널변경 "
					+ "4.채널Up 5.채널Down 6.볼륨Up 7.볼륨Down 8.시스템종료(0)");
			cmd = ScanUtil.nextInt();

			switch (cmd) {
			case 0 :
				System.out.println("프로그램을을 종료합니다.");
				break;
			case 1 :
				if (tv.power == false) {
					tv.powerOn();
				}
				break;
			case 2 :
				if (tv.power == true) {
					tv.poowerOff();
				}
				break;
			case 3 :
				System.out.print("변경할 채널을 입력하세요>");
				int channelChange = ScanUtil.nextInt();
				tv.channelChange(channelChange);
				break;
			case 4 : 
				tv.channelUp();
				break;
			case 5 :
				tv.channelDown();
				break;
			case 6 :
				tv.volumeUp();
				break;
			case 7 :
				tv.volumeDown();
				break;
			}
			System.out.println();
		}

	}
}
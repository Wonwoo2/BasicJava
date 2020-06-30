package e_oop;

import useful.ScanUtil;

public class Fan {
	boolean fanPower;
	boolean fanRotate;
	boolean fanTimer;
	String windStrength;
	
	int angle;
	int angleTimeLimit;
	int timer;
	
	Fan() {
		fanPower = false;
		fanRotate = false;
		fanTimer = false;
		windStrength = "미풍";
		angle = 90;
		angleTimeLimit = 60;
		timer = 1;
	}

	void fanPowerOn() {
		fanPower = true;
		System.out.println("선풍기가 켜졌습니다.");
		System.out.println("현재 " + windStrength + "입니다.");
	}
	
	void fanPowerOff() {
		fanPower = false;
		System.out.println("선풍기가 꺼졌습니다.");
	}
	
	void selectWindStrength(String windStrength) {
		if (fanPower) {
			this.windStrength = windStrength;
			System.out.println("현재 " + this.windStrength + "입니다.");
		} else {
			System.out.println("선풍기가 꺼져있습니다.");
		}
		
	}
	
	void fanRotate() throws InterruptedException {
		fanRotate = true;
		if(fanPower) {
			System.out.println("선풍기가 회전을 시작합니다.");
			fanAngle();
		} else {
			System.out.println("선풍기가 꺼져있습니다.");
		}
		
	}
	
	void startTimer(int timer) throws InterruptedException {
		fanTimer = true;
		this.timer = 60 * timer;
		if(fanPower){
			for (int i = this.timer; i >= 0; i--) {
				this.timer -= 1;
				if (i % 100 == 0) {
					showRemainTimer(this.timer);
				}
				Thread.sleep(100);
			}
			if(this.timer == 0) {
				fanPowerOff();
			}
		} else {
			System.out.println("선풍기가 꺼져있습니다.");
		}
	}
	
	void fanAngle() throws InterruptedException {
		angleTimeLimit *= 60;
		if(fanPower) {
			while (fanRotate) {
				for (int i = angle; i < 180; i++) {
					if (angle % 10 == 0) {
						showAngle(angle);
					}
					angle++;
					angleTimeLimit--;
					Thread.sleep(100);
				}
				for (int i = angle; i > 0; i--) {
					if (angle % 10 == 0) {
						showAngle(angle);
					}
					angle--;
					angleTimeLimit--;
					Thread.sleep(100);
				}
				if(angleTimeLimit == 0) {
					System.out.print("계속 회전시키겠습니까?(Y/N)");
					String yesOrNo = ScanUtil.nextLine().toUpperCase();
					if (yesOrNo.equals("Y")) {
						angleTimeLimit *= 60;
						continue;
					} else if (yesOrNo.equals("N")) {
						fanRotate = false;
						break;
					}
				}
			}
		} else {
			System.out.println("선풍기가 꺼져있습니다.");
		}
		
	}
	
	void fanAngleAndTimer(int timer) throws InterruptedException {
		fanTimer = true;
		fanRotate = true;
		this.timer = 60 * timer;
		
		if(fanPower){
			while (fanRotate && fanTimer) {
				
				for (int i = angle; i < 180; i++) {
					if (angle % 10 == 0) {
						showAngle(angle);
					}
					if (this.timer % 100 == 0) {
						showRemainTimer(this.timer);
					}
					angle++;
					this.timer--;
					Thread.sleep(100);
					if (this.timer == 0) {
						fanTimer = false;
						fanRotate = false;
						fanPowerOff();
						break;
					}
				}
				for (int i = angle; i > 0; i--) {
					if (angle % 10 == 0) {
						showAngle(angle);
					}
					if (timer % 100 == 0) {
						showRemainTimer(timer);
					}
					angle--;
					this.timer--;
					Thread.sleep(100);
					if (this.timer == 0) {
						fanTimer = false;
						fanRotate = false;
						fanPowerOff();
						break;
					}
				}
			}
		} else {
			System.out.println("선풍기가 꺼져있습니다");
		}

		
	}
	
	
	void showRemainTimer(int timer) {
		this.timer = timer;
		System.out.println("현재 남은 시간 : " + this.timer + "초");
	}
	
	void showAngle(int angle) {
		this.angle = angle;
		System.out.println("현재 " + this.angle + "도 입니다." );
	}
	
	public static void main(String[] args) throws InterruptedException {
		Fan f = new Fan();
		
		int cmd = 1;
		
		while(true) {
			System.out.print("선풍기 명령 입력 > 0.시스템종료 1.켜기 2.끄기 3.강풍 "
					+ "4.약풍 5.미풍 6.회전  7.타이머 8.회전 + 타이머 ");
			cmd = ScanUtil.nextInt();
			
			if(cmd == 0) {
				System.out.println("시스템을 종료합니다.");
				break;
			}
			
			if(cmd == 1) {
				f.fanPowerOn();
				continue;
			} else if(cmd == 2) {
				f.fanPowerOff();
				continue;
			} else if(cmd == 3) {
				f.selectWindStrength("강풍");
				continue;
			} else if(cmd == 4) {
				f.selectWindStrength("약풍");
				continue;
			} else if(cmd == 5) {
				f.selectWindStrength("미풍");
				continue;
			} else if(cmd == 6) {
				f.fanRotate();
			} else if(cmd == 7) {
				System.out.print("타이머 시간을 입력하세요 > (30분, 60분, 90분, 120분, 150분, 180분)");
				int timer = ScanUtil.nextInt();
				f.startTimer(timer);
			} else if(cmd == 8) {
				f.fanAngleAndTimer(cmd);
			}
		}
	}
}

	/*void fanPowerOn() {
		fanPower = true;
		System.out.println("선풍기가 켜졌습니다.");
		System.out.println("현재 " + windStrength[0] + "입니다.");
	}

	void fanPowerOff() {
		fanPower = false;
		System.out.println("선풍기가 꺼졌습니다.");
	}

	void fanRotateOn() throws InterruptedException {
		fanRotate = true;
		System.out.println("선풍기를 회전을 시작합니다.");
		fanAngle();
	}

	void fanRotateOff() {
		fanRotate = false;
		System.out.println("선풍기 회전을 종료합니다.");
	}

	void fanAngle() throws InterruptedException {
		while (fanRotate && fanPower) {
			for (int i = angle; i < 180; i++) {
				if (angle % 10 == 0) {
					System.out.println("선풍기 각도 : " + angle);
				}
				angle++;
				Thread.sleep(100);
			}
			for (int i = angle; i > 0; i--) {
				if (angle % 10 == 0) {
					System.out.println("선풍기 각도 : " + angle);
				}
				angle--;
				Thread.sleep(100);
			}
			System.out.print("계속 회전시키겠습니까?(Y/N)");
			String yesOrNo = ScanUtil.nextLine().toUpperCase();
			if (yesOrNo.equals("Y")) {
				continue;
			} else if (yesOrNo.equals("N")) {
				break;
			}
		}
	}

	void fanTimer(int timer) throws InterruptedException {

		int second = timer * 60;

		if (fanPower) {
			for (int i = second; i >= 0; i--) {
				second -= i;
				if (i % 100 == 0) {
					System.out.println("현재 남은 시간은 " + second + "초입니다.");
				}
				if (i == 0) {
					fanPower = false;
				}
				Thread.sleep(100);
			}
		}
	}

	void fanAngleAndTimer(int timer) throws InterruptedException {
		int second = timer * 60;

		while (fanRotate && fanPower) {
			if (second == 0) {
				fanPower = false;
			}
			for (int i = angle; i < 180; i++) {
				if (angle % 10 == 0) {
					System.out.println("선풍기 각도 : " + angle);
				}
				if (second % 100 == 0) {
					System.out.println("현재 남은 시간은 : " + second + "초 입니다.");
				}
				angle++;
				second--;
				Thread.sleep(100);
			}
			for (int i = angle; i > 0; i--) {
				if (angle % 10 == 0) {
					System.out.println("선풍기 각도 : " + angle);
				}
				if (second % 100 == 0) {
					System.out.println("현재 남은 시간은 : " + second + "초 입니다.");
				}
				angle--;
				second--;
				Thread.sleep(100);
			}
		}
	}

	void windStrength(String strength) {
		if (fanPower) {
			for (int i = 0; i < windStrength.length; i++) {
				if (windStrength.equals(strength)) {
					System.out.println("선풍기를 " + strength + " 입니다.");
				}
			}
		}

	}*/
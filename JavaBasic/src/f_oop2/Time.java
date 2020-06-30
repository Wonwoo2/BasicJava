package f_oop2;

public class Time {
	private int hour;
	private int minute;
	private int second;
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if(hour >= 0 && hour < 23) {
			this.hour = hour;
		} else {
			return;
		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if(minute >= 0 && minute <= 59) {
			this.minute = minute;
		} else {
			return;
		}
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		if(second >= 0 && second <= 59) {
			this.second = second;
		} else {
			return;
		}
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	
	
}

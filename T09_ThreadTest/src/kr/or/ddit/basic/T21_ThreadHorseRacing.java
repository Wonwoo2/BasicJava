package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

경기가 끝나면 등수 순으로 출력한다.*/
public class T21_ThreadHorseRacing {
	public static int cnt = 1;
	
	public static void main(String[] args) {
		List<Horse> hList = new ArrayList<>();

		for (int i = 0; i < 10; i ++) {
			Horse horse = new Horse(i + "번말", 1);
			hList.add(horse);
		}
		
		for (Horse h : hList) {
			h.start();
		}
		
		Racing r = new Racing(hList);
		r.start();

	}
}

class Racing extends Thread {
	private List<Horse> hList;
	
	public Racing(List<Horse> hList) {
		this.hList = hList;
	}
	
	@Override
	public void run() {
		String[] ground = new String[50];
		
		
		main :
		while(true) {
			
			for (Horse h : hList) {
				if(T21_ThreadHorseRacing.cnt == 11) {
					break main;
				}
				for (int i = 0; i < ground.length; i ++) {
					ground[i] = "-";
					if(h.getLocation() == i) {
						ground[i] = ">";
					}
				}
				
				System.out.print(h.getHorseName() + " : ");
				for (int i = 0; i < ground.length; i ++) {
					if(T21_ThreadHorseRacing.cnt != 11) {
						System.out.print(ground[i]);
					}
				}
				System.out.println();
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for (int i = 0; i < 10; i ++) {
				System.out.println("");
			}
			
			
		}
		
		Collections.sort(hList);
		
		System.out.println("==== 순위 ====");
		for (Horse h : hList) {
			System.out.println(h.getRank() + "등 : " + h.getHorseName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int rank;
	private int location;
	
	public Horse(String horseName, int rank) {
		this.horseName = horseName;
		this.rank = rank;
	}
	
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 50; i ++) {
			try {
				location = i;
				Thread.sleep((int)(Math.random() * 301 + 200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setRank(T21_ThreadHorseRacing.cnt++);
	}

	@Override
	public int compareTo(Horse o) {
		if(getRank() > o.getRank()) {
			return 1;
		} else if(getRank() < o.getRank()) {
			return -1;
		} else {
			return 0;
		}
	}
}
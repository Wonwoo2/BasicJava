package f_oop2.ex_abstract.ex_interface;

public class Starcraft {

	public static void main(String[] args) {
		Marine marine = new Marine();
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		SCV scv = new SCV();
		
		scv.repair(tank);
		scv.repair(dropship);
		scv.repair(scv);
		// scv.repair(marine);	Marine 클래스는 interface Repairable를 상속 받고 있지 않기 때문에 컴파일 에러가 난다
	}
}

class Unit {
	int hp;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
		this.hp = MAX_HP;
	}
}

class Marine extends Unit {
	Marine() {
		super(40);
	}
}

class Tank extends Unit implements Repairable {
	Tank() {
		super(150);
	}
}

class Dropship extends Unit implements Repairable {
	Dropship() {
		super(125);
	}
}

class SCV extends Unit implements Repairable {
	SCV() {
		super(60);
	}

	void repair(Repairable repair) {
		if(repair instanceof Unit) { // Unit타입으로 형변환이 가능한지 확인(instance of ==> 형변환이가능하면 true, 불가능하면 false를 반환
			Unit unit = (Unit)repair;
			
			while(unit.hp < unit.MAX_HP) {
				unit.hp ++;
			}
		}
	}
}
// 리페어 가능한 유닛들을 상속 받기위한 인터페이스
interface Repairable {
	
}

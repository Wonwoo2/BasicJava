package f_oop2.ex_abstract;


// move메서드처럼 좌표의 이동은 동일하지만 이동할 때의 방법이 다를 때 추상클래스를 상속받아 사용한다
public class Marine {
	int x, y;
	
	void move(int x, int y) {
		
	}
	
	void stop() {
		
	}
	
	void stimPack() {
		
	}
}
class Dropship {
	int x, y;
	
	void move(int x, int y) {
		
	}
	
	void stop() {
		
	}
	
	void load() {
		
	}
	
	void unload() {

	}
}
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		
	}
	
	// 시즈모드를 변환한다
	void changeMode() {
		
	}
	
}
// 공통된 변수와 메서드를 부모클래스로 만든다
abstract class Unit {
	int x, y;
	
	// 자식마다 내용이 다를 수 있는 메서드는 추상메서드로 만들면 자식클래스가 내용을 구현한다
	abstract void move(int x, int y);
	
	void stop() {
		
	}
}
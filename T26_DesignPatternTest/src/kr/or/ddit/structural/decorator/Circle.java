package kr.or.ddit.structural.decorator;

public class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("원형 그리기 작업 중...");
	}
}

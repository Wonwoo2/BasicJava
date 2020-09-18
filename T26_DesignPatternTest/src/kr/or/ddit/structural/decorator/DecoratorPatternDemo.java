package kr.or.ddit.structural.decorator;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		
		Shape circle = new Circle();
		
		Shape redCircle = new RedShapeDecorator(new Circle());
		
		Shape redRectangle = new RedShapeDecorator(new Rectangle());
		
		//일반 원 그리기
		circle.draw();
		System.out.println("--------------------------------------");
		
		//빨간색 경계선 가진 원 그리기
		redCircle.draw();
		System.out.println("--------------------------------------");
		
		//빨간 경계선 가진 직사각형 그리기
		redRectangle.draw();
		System.out.println("--------------------------------------");
		
	}
	
}

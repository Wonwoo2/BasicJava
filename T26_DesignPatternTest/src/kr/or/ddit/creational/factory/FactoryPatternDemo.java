package kr.or.ddit.creational.factory;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		
		//원 객체를 만들고 draw()메서드 호출하기
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		//직사각형 객체를 만들고 draw()메서드 호출하기
		Shape shape2 = shapeFactory.getShape("RECTANGLE");
		shape2.draw();
		
		//사각형 객체를 만들고 draw()메서드 호출하기
		Shape shape3 = shapeFactory.getShape("SQUARE");
		shape3.draw();
		
		//다이아몬드 객체를 만들고 draw()메서드 호출하기
		Shape shape4 = shapeFactory.getShape("DIAMOND");
		shape4.draw();
	
	}
}

package h_useful;

import java.util.Vector;

public class WrapperClass {

	public static void main(String[] args) {
		/*
		 *  boolean		: boolean
		 *  char		: Character
		 *  byte		: Byte
		 *  short		: Short
		 *  int			: Integer
		 *  float		: Float
		 *  double		: Double
		 */
		
		
		// 기본형 타입과 참조형 타입은 연산이 불가능하지만
		// 기본형 타입과 Wrapper 클래스는 연산이 가능하다
		int i = 10;
		Integer iw = new Integer(20);
		
		System.out.println(i + iw);
		
		System.out.println(Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		
		System.out.println(i + Integer.parseInt("20"));
		
		System.out.println(i + String.valueOf(20));
		
		System.out.println(i + Integer.valueOf("20"));
		
		Vector<Integer> v = new Vector<>();
		
		v.add(new Integer(10));
		v.add(10);		// 오토박싱 : 기본형타입이 wrapper 클래스로 자동 변환
		
		Integer integer = v.get(0);
		int i2 = v.get(0);		// 언박싱 : wrapper 클래스가 기본형타입으로 자동 변환
	}
}
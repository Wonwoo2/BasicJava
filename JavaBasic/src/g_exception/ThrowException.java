package g_exception;

import java.io.IOException;

public class ThrowException {

	public static void main(String[] args) {
		/*
		 *  예외 발생시키기
		 *  - throw new Exception();
		 *  - throw 키워드와 예외 클래스의 객체로 예외를 고의로 발생시킬 수 있다.
		 */
		
		IOException ioe = new IOException();
		try {
			throw ioe;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// RuntimeException 의 자식들은 예외처리가 강제되지 않는다.
		throw new NullPointerException();
		// 위에서 예외가 발생하여 프로그램을 종료하기 때문에 아래 문장을 실행하지 않는다.
		
		// System.out.println("여기는 수행되지 않는다.");
	}
}
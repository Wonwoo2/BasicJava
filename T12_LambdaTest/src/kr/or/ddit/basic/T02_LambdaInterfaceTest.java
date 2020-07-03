package kr.or.ddit.basic;

@FunctionalInterface
public interface T02_LambdaInterfaceTest {
	// 반환값이 없고 매개변수도 없는 추상 메서드 선언
	public void test();
}

@FunctionalInterface
interface T02_LambdaInterfaceTest1 {
	// 반환값이 없고 매개변수가 있는 추상 메서드 선언
	public void test(int a);
}

@FunctionalInterface
interface T02_LambdaInterfaceTest2 {
	// 반환값, 매개변수가 있는 추상 메서드 선언
	public int test(int a, int b);
}

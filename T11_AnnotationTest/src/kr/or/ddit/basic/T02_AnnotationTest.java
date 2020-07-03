package kr.or.ddit.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 *  Java Reflection
 *  
 *  1. 리플렉션은 클래스 또는 멤버변수, 메서드, 생성자에 대한 정보를 가져오거나 수정할 수 있다
 *  2. Reflection API는 java.lang.reflection 패키지와 java.lang.class를 통해 제공된다.
 *  3. java.lang.Class의 주요 메서드
 *  	- getName(), getSuperClass(), getInterface(), getModifiers()
 *  4. java.lang.reflect 패키지의 주요 클래스
 *  	- Field, Methd, Constructor, Modifier 등
 *  5. Reflection API를 이용하면 클래스의 private 메서드나 변수에 접근 가능하다.(보안 위협)
 *  6. Reflection API의 기능은 뛰어나지만 약간의 오버헤드가 발생한다. (느린 수행속도, 보안취약성, 권한문제 등)
 *  	그러므로, 가급적 마지막 수단으로 사용하도록 고려되어야 함.
 */

// Annotation 정보만 사용하는 클래스에서 유용하게 사용할 수 있기 때문에
// 애너테이션을 사용한다.
public class T02_AnnotationTest {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println(PrintAnnotation.id);		// 애너테이션
		
		// reflection 기능을 이용한 메서드 실행하기
		// 선언된 메서드 목록 가져오기
		
		Method[] declareMethods = T01_Service.class.getDeclaredMethods();
		
		for (Method m : declareMethods) {
			System.out.println(m.getName());		// 메서드명 출력
			for (int i = 0;
					i < m.getDeclaredAnnotation(PrintAnnotation.class).count();		// PrintAnnotation의 count값 만큼 반복
					i ++) {
				System.out.print(m.getDeclaredAnnotation(PrintAnnotation.class).value());		// value값 출력 : %, #
			}
			System.out.println();
			
			Class<T01_Service> clazz = T01_Service.class;
			try {
				// 리플렉션을 이용한 객체 생성하기
				T01_Service service = (T01_Service) clazz.newInstance();
				m.invoke(service);
			} catch(InstantiationException e) {
				e.printStackTrace();
			}
		}
	}
}
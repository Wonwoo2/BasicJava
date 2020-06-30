package kr.or.ddit.basic;

class Util {
	/*
	 *  제네릭 메소드 <T, R> R method(T t)
	 *  
	 *  => 파라미터 타입과 리턴타입으로 타입 파라미터를 가지는 메서드
	 *  
	 *  선언 방법 : 리턴타입 앞에 <> 기호를 추가하고 타입 파라미터를 기술 후 사용함.
	 */
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/*
 *  멀티 타입<K, V>을 가지는 제네릭 클래스
 */
class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	// 키값을 모두 출력
	public static <K, V> void displayAll(K key, V val) {
		System.out.println(key.toString() + " : " + val.toString());
	}
}

public class T04_GenericMethod {
	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		// 구체적 타입을 명시적으로 지정(생략가능)
		boolean result = Util.<Integer, String>compare(p1, p2);
		
		if(result) {
			System.out.println("논리(의미)적으로 동일한 객체");
		} else {
			System.out.println("논리(의미)적으로 동일하지 않은 객체");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체");
		} else {
			System.out.println("논리(의미)적으로 동일하지 않은 객체");
		}
		Pair.displayAll("001", "홍길동");
	}
}
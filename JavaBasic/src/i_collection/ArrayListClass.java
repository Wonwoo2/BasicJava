package i_collection;

import java.util.ArrayList;

public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 *  add()		: 마지막 위치에 객체를 추가
		 *  get()		: 지정된 위치의 객체를 반환
		 *  set()		: 지정된 위치에 주어진 객체를 저장(수정)
		 *  remove()	: 지정된 위치의 객체를 제거
		 *  size()		: 저장된 객체의 수 반환
		 */
		// <> 제네릭 어떤타입의 값이 올지 지정해주는 것
		ArrayList<Object> list = new ArrayList<Object>();
		
		list.add(10);
		list.add("abc");
		list.add(true);
		list.add(new ArrayListClass());
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("abc"); //인덱스 0번부터 순서대로 저장한다
//		list2.add(123); // 다른타입을 저장하게 되면 컴파일 에러가 발생
		list2.add("123");
		list2.add("가나다");
		list2.set(1, "456"); // 몇번째 인덱스에 데이터를 수정하는 메서드
		
		for(int i = 0; i < list2.size(); i ++) {
			System.out.println(list2.get(i));
		}
		
		list2.remove(0);
		// 리스트에 저장된 값을 삭제하면 그 뒤의 모든 값의 인덱스가 당겨진다.
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		
		ArrayList<ArrayList<Integer>> list3 = new ArrayList<>(); // 2차원 배열
		
		ArrayList<Integer> list4 = new ArrayList<>();
		list4.add(10);
		list4.add(20);
		list4.add(30);
		
		list3.add(list4);
		
		list4 = new ArrayList<>();
		list4.add(40);
		list4.add(50);
		list4.add(60);
		
		list3.add(list4);
		
		ArrayList<Integer> list5 = list3.get(0);
		System.out.println(list5.get(0));
		for (int i = 0; i < list3.size(); i ++) {
			ArrayList<Integer> list6 = list3.get(i);
			for (int j = 0; j < list6.size(); j ++) {
				System.out.print(list6.get(j) + " ");
			}
		}
		
		System.out.println();
		for (int i = 0; i < list3.size(); i ++) {
//			ArrayList<Integer> list6 = list3.get(i);
			for (int j = 0; j < list3.get(i).size(); j ++) {
				System.out.print(list3.get(i).get(j) + " ");
			}
		}
		
		System.out.println();
		// 정수를 저장할 수 있는 ArrayList를 생성해 1 ~ 100 사이의 랜덤한 값을 5번 저장해주세요
		
		ArrayList<Integer> random = new ArrayList<>();
		
		for (int i = 0; i < 5; i ++) {
			int number = (int) (Math.random() * 100) + 1;
			random.add(number);
		}
		
		System.out.println(random);
		
		// 위에서 만든 ArrayList에 담긴 값들의 합계와 평균을 출력해주세요.
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < random.size(); i ++) {
			sum += random.get(i);
		}
		avg = sum / (double)random.size();
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);

		// 위에서 만든 ArrayList에 담긴 값들 중 최소값과 최대값을 출력해주세요.
		int min = random.get(0);
		int max = random.get(0);
		
		for (int i = 0; i < random.size(); i ++) {
			if(min > random.get(i)) {
				min = random.get(i);
			} else if(max < random.get(i)) {
				max = random.get(i);
			}
		}
		
		System.out.println("min : " + min);
		System.out.println("max : " + max);
	}
}
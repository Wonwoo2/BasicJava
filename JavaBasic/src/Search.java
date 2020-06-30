
public class Search {
	public static void main(String[] args) {
		
		// 주어진 조건
		// array배열에 정수가 담겨 있고, 값이 오름차순으로 이미 정렬 되어있다
		// array 배열에는 중복된 값이 없다
		/*int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };*/
		/*int[] array = { 1, 3, 5, 7, 9, 11, 15, 17, 19, 21 };*/
		
		
		// 1. array 배열에서 13이라는 값이 있는지 확인하는 로직
		// 13이 발견되면 sysout으로 find라는 문자열을 출력
		// 발견되지 않으면 not found라는 문자열을 출력
		/*boolean find = false;
		
		for (int i = 0; i < array.length; i ++) {
			if(array[i] == 13) {
				find = true;
				break;
			}
		}
		if(find) {
			System.out.println("find");
		} else {
			System.out.println("not found");
		}*/
		
		// 두 번째 문제
		// array 배열에는 정수가 담겨있고 오름차순으로 정렬 되어 있으며
		// 값이 중복될 수 있다
		// 배열내에 13값이 몇번 등장하는지 출력하는 로직을 작성
		/*int[] array = { 1, 3, 5, 7, 9, 11, 13, 13, 13, 15, 17, 19, 21 };
		
		int count = 0;
		boolean find = false;
		for (int i = 0; i < array.length; i ++) {
			if(array[i] == 13) {
				count ++;
			}
			else if(array[i] > 13) {
				break;
			}
		}
		System.out.println(count);*/
		
		
	}
}
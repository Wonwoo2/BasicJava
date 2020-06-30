package DataStructure;

public class BinarySearch {

	public static void main(String[] args) {
		// 이진 탐색 (binary search)
		// 전체조건 : 데이터가 정렬되어 있음을 가정
		
		// 전체 데이터에서 중간 부분을 확인
		// 다음 배열에서 19를 찾을 때
		
		// 배열에 64개의 값이 있을 경우 ==> 32 ==> 16 ==> 8 ==> 4 ==> 2 ==>1
		// for ==> 64번의 if
		// binary ==> 6
		
		int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21 };
		int number = array[array.length/2];
		boolean find = false;
		
		if(number < 19) {
			for(int i = array.length/2; i < array.length; i ++) {
				if(array[i] == 19) {
					find = true;
					System.out.println("find");
					break;
				}
			}
		} else if(number > 19) {
			for(int i = array.length/2; i >= 0 ; i --) {
				if(array[i] == 19) {
					find = true;
					System.out.println("find");
					break;
				}
			}
		}
		if(find == false) {
			System.out.println("not found");
		}


	}

}

package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 *  배열
		 *  - int[] number = new int[5]
		 *  - int[] number = new int[]{ 10, 30, 40, 50 };
		 *  - int[] number = { 10, 20, 30, 40, 50 };
		 *  - 배열은 참조형 타입이다.
		 */
		
		int[] array; // 배열의 주소를 저장할 공간이 만들어진다
		array = new int[5]; // 배열이 생성되고 그 주소가 변수에 저장된다
		// new : 새로운 저장공강 생성 및 주소 반환
		// int[5] : int를 저장할 수는 5개의 공간
		// 배열 초기화시 기본값이 저장된다
		
		System.out.println(array); // array 배열안에 저장된 주소를 출력
		System.out.println(array[0]); //실제 값에 접근하기 위해서는 index를 지정해줘야 한다
		// index에는 int만 사용할 수 있다
		// 배열의 최대 크기는 int의 최대값(약 20억)이다
		
		String arrayStr = Arrays.toString(array); // Arrays.toString() => 배열의 모든 인덱스에 저장된 값을 문자열로 반환한다
		System.out.println(arrayStr);
		
		int[] iArray1 = new int[] { 1, 2, 3 }; // 값의 개수로 배열의 길이가 정해진다
		int[] iA1rray2 = { 1, 2, 3 }; // 선언과 초기화를 동시에 해야한다
		int[] iArray3;
	//	iArray3 = { 1, 2, 3 }; // 컴파일에러 발생
		
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;
		
		// 정수를 저장할 수 있는 길이가 10인 배열을 생성 및 초기화 해주세요
		int[] iArray4 = new int[10];
		
		// 모든 인덱스에 있는 값을 변경해주세요
		iArray4[0] = 10;
		iArray4[1] = 10;
		iArray4[2] = 10;
		iArray4[3] = 10;
		iArray4[4] = 10;
		iArray4[5] = 10;
		iArray4[6] = 10;
		iArray4[7] = 10;
		iArray4[8] = 10;
		iArray4[9] = 10;
		
		
		System.out.println(Arrays.toString(iArray4));
		
		// 모든 인덱스에 있는 값을 더해주세요
		int sum = 0;
		sum += iArray4[0];
		sum += iArray4[1];
		sum += iArray4[2];
		sum += iArray4[3];
		sum += iArray4[4];
		sum += iArray4[5];
		sum += iArray4[6];
		sum += iArray4[7];
		sum += iArray4[8];
		sum += iArray4[9];
		
		System.out.println(sum);
		
		for(int i = 0; i < array.length; i ++) {
			System.out.println(array[i]);
		}
		
		for(int i = 0; i < array.length; i ++) {
			array[i] = i + 1;
		}
		
		System.out.println(Arrays.toString(array));
		
		// 배열의 합계와 평균을 구해보자
		int[] numbers = new int[10];
		
		for(int i = 0; i < numbers.length; i ++) {
			numbers[i] = (int)(Math.random() * 100) + 1;
		}
		
		System.out.println(Arrays.toString(numbers));
		
		sum = 0;
		double avg = 0;
		
		for(int i = 0; i < numbers.length; i ++) {
			sum += numbers[i];
		}
		
		avg = (double)sum / numbers.length;
		
		System.out.println("배열의 합계 : " + sum + ", 평균 : " + avg);
		
		// 향상된 for문
		for(int number : numbers) { // 배열에 있는 값을 차례대로 변수에 저장후 실행한다.
			System.out.println(number);
		}
		
		// 배열에 저장된 숫자들 중 최소값과 최대값을 출력해주세요
		int max = 0;
		int min = numbers[0];
		
		for(int i = 0; i < numbers.length; i ++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		
		System.out.println("numbers 최대값 : " + max + ", numbers 최소값 : " + min);
		
		int[] shuffle = new int[20];
		
		for(int i = 0; i < shuffle.length; i ++){
			shuffle[i] = i + 1;
		}
		
		System.out.println(Arrays.toString(shuffle));
		
		// 배열의 값을 섞어주세요
		for(int i = 0; i < shuffle.length * 10; i ++) {
			int num = (int)(Math.random() * shuffle.length);
			
			int tmp = shuffle[0];
			shuffle[0] = shuffle[num];
			shuffle[num] = tmp;
		}
		
		System.out.println(Arrays.toString(shuffle));
		
		// 1 ~ 10 사이의 난수를 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요
		int[] number = new int[500];
		int[] counter = new int[10];

		int randum = 0;
				
		for(int i = 0; i < number.length; i ++) {
			number[i] = (int)(Math.random() * 10 + 1);
		}
				
		for(int i = 0; i < counter.length; i ++) {
			for(int j = 0; j < number.length; j ++) {
				if(i + 1 == number[j]) {
					counter[i] += 1;
				}
			}
		}
		
		System.out.println("=======각 숫자가 생성된 횟수=======");
		
		for(int i = 0; i < counter.length; i ++) {
			System.out.print(counter[i] + " ");
		}
		
	}
}
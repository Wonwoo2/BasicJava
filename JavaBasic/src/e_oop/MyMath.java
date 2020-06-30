package e_oop;

public class MyMath {
	/*
	 *  과제. MyMath 클래스와 아래의 메서드들을 만들어주세요
	 *  - 가장 큰 값
	 *  - 가장 작은 값
	 *  - 원하는 자릿수에서 반올림 (자릿수도 파라미터로 받아야함)
	 *  - int배열 정렬(오름차순, 내림차순 둘다 가능하게)
	 *  - SampleClass의 변수 값을 출력(파라미터 1개만 사용)
	 */
	static int a;

	int max(int[] numbers) {
		int max = 0; // 배열의 첫번째 인덱스의 값을 넣고 비교해도 된다
		
		for(int i = 0; i < numbers.length; i ++) {
				if(max < numbers[i]) {
					max = numbers[i];
				}
		}
		return max;
	}
	
	int min(int[] numbers) {
		int min = 9999; // 배열의 첫번째 인덱스의 값을 넣고 비교해도 된다
		
		for(int i = 0; i < numbers.length; i ++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}
	
	double roundNumber(double roundNumber, int index) {
		double number = 1;
		
		
		for(int i = 1; i < index; i ++) {
			number *= 10.0;
		}
		return (int) ((double) roundNumber * number + 0.5) / number;
	}
	
	int[] sort(int numSort[], String sort) {
		
		int[] rtnArr = new int[numSort.length];
		
		for(int i = 0; i < numSort.length; i ++) {
			rtnArr[i] = numSort[i];
		}
		
		for(int i = 0; i < rtnArr.length; i ++) {
			for(int j = i; j < rtnArr.length; j ++)
				if(sort.trim().equals("오름차순")) {
					if(rtnArr[i] > rtnArr[j]) {
						int tmp = numSort[i];
						rtnArr[i] = rtnArr[j];
						rtnArr[j] = tmp;

					}
				} else if(sort.trim().equals("내림차순")) {
					if(rtnArr[i] < rtnArr[j]) {
						int tmp = rtnArr[i];
						rtnArr[i] = rtnArr[j];
						rtnArr[j] = tmp;
					}
				}
			}
		return rtnArr;
	}
	
	void printSample(SampleClass sc) {
		System.out.println("bool : " + sc.bool);
		System.out.println("field : " + sc.field);
		System.out.println("str : " + sc.str);
	}
}
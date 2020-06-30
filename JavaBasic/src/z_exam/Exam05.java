package z_exam;

import java.util.Scanner;

public class Exam05 {

	public static void main(String[] args) {
		
		
		/*  
		    [5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.			
				a. int[] arr[];
				b. int[] arr = { 1, 2, 3, };
				c. int[] arr = new int[5];
				d. int[] arr = new int[5]{ 1, 2, 3, 4, 5 };
				e. int arr[5];
				f. int[] arr[] = new int[3][];
				
				=> 	e. 선언하는 부분에 배열이 길이를 저장할 수 없다
					d. int[] arr = new int[5]{ 1, 2, 3, 4, 5 }; 배열의 길이를 정해주거나, 초기화를 통해 길이를
					정하거나 둘 중 한가지만 해야한다.
				
		 */
		
		/*
		 	[5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가?
					int[][] arr = {
					{ 5, 5, 5, 5, 5 },
					{ 10, 10, 10 },
					{ 20, 20, 20, 20 },
					{ 30, 30 }
					};
					
					=> 2
					
		*/
		/*
		  	[5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
				int []arr = { 10, 20, 30, 40, 50 };
				int sum = 0;
				
				for(int i = 0; i < 5; i ++) {
					sum += arr[i];
				}
				
				System.out.println("sum = " + sum);
				
		*/
		/*	
		 	[5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.
				int[][] arr = {
					{ 5, 5, 5, 5, 5 },
					{ 10, 10, 10, 10, 10 },
					{ 20, 20, 20, 20, 20 },
					{ 30, 30, 30, 30, 30 }
				};
			
				int total = 0;
				float average = 0;
				
				for(int i = 0; i < 4; i ++) {
					for(int j = 0; j < 5; j ++) {
						total = arr[i][j];
					}
				}
				
				average = total / (float)(arr[0].length * arr.length);
				
				System.out.println("total = " + total);
				System.out.println("average = " + average);
				
		*/
		/*	
 			[5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
			 (1) ~ (2)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
			 [참고] Math.random()을 사용했기 때문에 실행결과와 다를 수 있다.
					
		  		int [] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
				int [] ball3 = new int[3];
				
				for(int i = 0; i < ballArr.length; i ++) {
					int j = (int)(Math.random() * ballArr.length);
					int tmp = 0;
					
					tmp = ballArr[i];
					ballArr[i] = ballArr[j];
					ballArr[j] = tmp;
				}
				
				for(int i = 0; i < ball3.length; i ++) {
					ball3[i] = ballArr[i];
				}
				
				for(int i = 0; i < ball3.length ; i ++) {
					System.out.print(ball3[i]);
				}
		*/
		/*	
		  	[5-6] 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다. 변수 money의 금액
		 	 을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라. 단, 가능한 한 적은 수의 동전
		 	 으로 거슬러 주어야한다. (1)에 알맞은 코드를 넣어서 프로그램을 완성하시오.
		 	 [Hint] 나눗셈 연산자와 나머지 연산자를 사용해야 한다.
		 		int [] coinUnit = { 500, 100, 50, 10 };
		
				int money = 2680;
				System.out.println("money = " + money);
			
				for(int i = 0; i < coinUnit.length; i ++) {
					System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i] + "개");
					money = money % coinUnit[i];
				}
		*/
		/*
		 	[5-7] 문제 5-6에 동전의 개수를 추가한 프로그램이다. 커맨드라인으로부터 거슬러 줄 금액을 입력 받아 계산
			 한다. 보유한 동전의 개수로 거스름돈을 지불할 수 없으면, '거스름돈 돈이 부족합니다.'라고 출력하고 종료한다.
			 지불할 돈이 충분히 있으면, 거스름돈을 지불한 만큼 가진 돈에서 빼고 남은 동전의 개수를 화면에 출력한다. (1)
			 에 알맞은 코드를 넣어서 프로그램을 완성하시오.
			 	if(args.length != 1) {
			 			System.out.println("USAGE: java Exercise5_7 3120");
			 			System.exit(0);
				}
				
				int money = Integer.parseInt(args[0]);
				
				System.out.println("money = " + money);
				
				int [] coinUnit = { 500, 100, 50, 10 };
				int [] coin = { 5, 5, 5, 5 };
				
				
				for(int i = 0; i < coinUnit.length; i ++) {
					int coinNum = 0;
					
					coinNum = money / coinUnit[i];
					if (coinNum > coin[i]) {
						coinNum = coin[i];
						coin[i] = 0;
					} else {
						coin[i] = coint[i] - coinNum;
					}
					money = money - coinUnit[i] * coinNum;
					
					System.out.println(coinUnit[i] + "원 : " + coinNum);
				}
				
				if(money > 0) {
					System.out.println("거스름돈이 부족합니다.");
					System.exit(0);
				}
				
				System.out.println("= 남은 동전의 개수 =");
				
				for(int i = 0; i < coinUnit.length; i ++) {
					System.out.println(coinUnit[i] + "원 :" + coin[i]);
				}
		*/
		/*
		  	[5-8] 다음은 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*'을 찍어서
			 그래프를 그리는 프로그램이다. (1) ~ (2)에 알맞은 코드를 넣어서 완성하시오.
			 
			 	int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
				int[] counter = new int[4];
				
				for(int i = 0; i < answer.length; i ++) {
					if(answer[i] == 1) {
						counter[0]  += 1;
					} else if(answer[i] == 2) {
						counter[1] += 1;
					} else if(answer[i] == 3) {
						counter[2] += 1;
					} else {
						counter[3] += 1;
					}
					
					// counter[answer[i] - 1] ++;
				}
				
				for(int i = 0; i < counter.length; i ++) {
					System.out.print(counter[i]);
					for(int j = 0; j < counter[i]; j ++) {
						System.out.print("*");
					}
					System.out.println();
				}
		*/
		/*
		 	[5-9] 주어진 배열을 시계방향으로 90도 회전시켜서 출력하는 프로그램을 완성하시오.
				char[][] star = {
					{ '*', '*', ' ', ' ', ' ' },
					{ '*', '*', ' ', ' ', ' ' },
					{ '*', '*', '*', '*', '*' },
					{ '*', '*', '*', '*', '*' }
				};
		
				char[][] result = new char[star[0].length - 1][star.length ];
		
				for(int i = 0; i < star.length; i ++) {
					for(int j = 0; j < star[i].length; j ++) {
						System.out.print(star[i][j]);
					}
					System.out.println();
				}	
		
				System.out.println();
		
				for(int i = 0; i < star.length; i ++) {
					for(int j = 0; j < star[i].length - 1; j ++) {
						if(j >= 2 && i < 2) {
							result[i][j] = '*';
						} else if(j >= 2 && i >= 2) {
							result[i][j] = ' ';
						} else {
							result[i][j] = '*';
						}
						
						// result[j][i] = start[star.length - 1 - i][j];
					}
				}
				
				0, 0 -> 0, 3
				0, 1 -> 1, 3
				0, 2 -> 2, 3
				0, 3 -> 3, 3
				1, 0 -> 0, 2
				1, 1 -> 1, 2
				1, 2 -> 2, 2
				1, 3 -> 3, 2
		
				for(int i = 0; i < result.length; i ++) {
					for(int j = 0; j < result.length; j ++) {
						System.out.print(result[i][j]);
					}
					System.out.println();
				}
		*/
		/*
		  	[5-10] 다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
			 (1)에 알맞은 코드를 넣어서 완성하시오.
				char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*',
					'(', ')', '-', '_', '+', '=', '|', '[', ']', '{', '}', ';',
					':', ',', '.', '/' };

				char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };

				String src = "abc123";
				String result = "";

				for (int i = 0; i < src.length(); i++) {
					char ch = src.charAt(i);
					char a = 'a';
					for(int j = 0; j < abcCode.length; j ++) {
						if(ch == a) {
							result += abcCode[j];
						}
						a++;
					}
					a = '0';
					for(int k = 0; k < numCode.length; k ++) {
						if(ch == a) {
							result += numCode[k];
						}
						a++;
					}
				}

				System.out.println("src : " + src);
				System.out.println("result : " + result);
		*/
		/*
		  	 [5-11] 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서 
			 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다.
			 (1)에 알맞은 코드를 넣어서 완성하시오.
			 	int[][] score = {
						{ 100, 100, 100 }
						, { 20, 20, 20 }
						, { 30, 30, 30 }
						, { 40, 40, 40 }
						, { 50, 50, 50 }
				};
				
				int[][] result = new int[score.length + 1][score[0].length + 1];
				
				for(int i = 0; i < score.length; i ++) {
					for(int j = 0; j < score[i].length; j ++) {
						result[i][j] = score[i][j];
						result[i][score[0].length] += score[i][j];
			
				
				for(int i = 0; i < result.length; i ++) {
					for(int j = 0; j < result[i].length; j ++) {
						System.out.printf("%4d", result[i][j]);
					}
					System.out.println();
				}
		*/
		/*
		  	[5-12] 예제 5-23을 변경하여, 아래와 같은 결과가 나오도록 하시오.
				String[][] words = {
					{ "chair", "의자" },
					{ "computer", "컴퓨터" },
					{ "integer", "정수" }
				};
			
				Scanner sc = new Scanner(System.in);
				int count = 0;
		
				for(int i = 0; i < words.length; i ++) {
					System.out.printf("Q%d. %s의 뜻은? ", i + 1, words[i][0]);
			
					String tmp = sc.nextLine();
				
					if(tmp.equals(words[i][1])) {
						System.out.printf("정답입니다.%n%n");
						count++;
					} else {
						System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
					}
				}
				System.out.println("전체 " + words.length + "문제 중 " + count + "문제 맞추셨습니다.");
			
				실행결과
				=> 	Q1. chair의 뜻은? dmlwk
			      	틀렸습니다. 정답은 의자입니다.
			   		Q2. computer의 뜻은? 컴퓨터
			      	정답입니다.
			   		Q3. integer의 뜻은? 정수
			      	정답입니다.
			   
			      	전체 3문제 중 2문제 맞추셨습니다.
		*/
		/*	 [5-13] 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다. 
			  실행결과와 같이 동작하도록 예졔의 빈 곳을 채우시오.
			 	String[] words = { "television", "computer", "mouse", "phone" } ;
		
				Scanner sc = new Scanner(System.in);
		
				for(int i = 0; i < words.length; i ++) {
					char[] question = words[i].toCharArray();
			
					int random = (int)(Math.random() * words.length);
			
					char tmp = question[i];
					question[i] = question[random];
					question[random] = tmp;
			
					System.out.printf("Q%d. %s의 정답을 입력하세요>", i + 1, new String(question));
			
					String answer = sc.nextLine();
			
					if(words[i].equals(answer.trim())) {
						System.out.printf("맞았습니다. %n%n");
					} else {
						System.out.printf("틀렸습니다. %n%n");
					}
				}
				[5-14] 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다 
				 실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오
				 
				 import java.util.Scanner;
				 
				 class Exercise5_13 {
				 	public static void main(String args[]) {
							String[] words = { "television", "computer", "mouse", "phone" };
		
							Scanner sc = new Scanner(System.in);
		
							for(int i = 0; i < words.length; i ++) {
								char[] question = words[i].toCharArray(); // String을 char[]로 변환
								
								for(int j = 0; j < question.length; j ++) {
									int index = (int)(Math.random() * question.length);
									char tmp = question[i];
									question[i] = question[index];
									question[index] = tmp;
								}
			
							System.out.printf("Q%d, %s의 정답을 입력하세요 >",
												i + 1, new String(question));
							String answer = sc.nextLine();
							// trim()으로 answer의 좌우 공백을 제거한 후, equals로 word[i]와 비교
							if (words[i].equals(answer)) {
								System.out.printf("맞았습니다. %n%n");
							} else {
								System.out.printf("틀렸습니다. %n%N");
							}
						}
					}
				 }
		*/
	}
}
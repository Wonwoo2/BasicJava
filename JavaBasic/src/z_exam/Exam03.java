package z_exam;

public class Exam03 {

	public static void main(String[] args) {
				
		/*
		 [3-1] 다음 연산의 결과를 적으시오.
			int x = 2;
			int y = 5;00000110
			char c = 'A'; //'A'의 문자코드는 65
			System.out.println(1 + x << 33); => 6
			System.out.println(y >= 5 || x < 0 && x > 2); => true 
			System.out.println(y += 10 - x++); => 13
			System.out.println(x+=2); 4
			System.out.println( !('A' <= c && c <='Z') ); => false
			System.out.println('C'-c); => 0
			System.out.println('5'-'0'); => 5
			System.out.println(c+1); => 66
			System.out.println(++c); => B
			System.out.println(c++); => B
			System.out.println(c); => C
		
		 [3-2] 아래의 코드는 사과를 담는데 필요한 바구니(버켓)의 수를 구하는 코드이다. 만일 사과의 수가 123개이고
		   하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다. (1)에 알맞은 코드를 넣으시오.
			int numOfApples = 123; 사과의 개수 
			int sizeOfBucket = 10; 바구니의 크기 바구니에 담을 수 있는 사과의 개수
			int numOfBucket = ((1)); 모든 사과를 담는데 필요한 바구니의 수
			System.out.println(" :"+numOfBucket);
			(1) => numOfApples / sizeOfBucket + (numOfApples % sizeOfBucket > 0 ? 1 : 0);
			
			실행결과 => 13
		
		 [3-3] 아래는 변수 의 값에 따라 num 양수 음수 을 ‘ ’, ‘ ’, ‘0’ 출력하는 코드이다. 삼항연산자를 이용해서
		  (1)에 알맞은 코드를 넣으시오.
		 	int num = 10;
		 	System.out.println(num > 0 ? "양수" : (num < 0 ? "음수" : "0"));
		 	
		 	실행결과 => 양수
		  
		 [3-4] 아래는 변수 의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 ‘456’이라면 ‘400’이 되고, 
		  ‘111’이라면 ‘100’이 된다. (1)에 알맞은 코드를 넣으시오.
		  	int num = 456;
		  	System.out.println(num%100 > 0 ? (num - num%100) : num);
		  	System.out.print(num / 100 * 100);
		  	System.out.print(num - num%100);
		  	
		  	실행결과 => 400
		  	
		 [3-5] 아래는 변수 num의 값 중에서 일의 자리를 1로 바꾸는 코드이다. 만일 변수 num의 값이 333이라면 331이 되고,
		  777이라면 771이 된다. (1)에 알맞은 코드를 넣으시오.
		  	int num = 333;
		  	System.out.println(num%10 > 0 ? num - (num%10) + 1 : num);
		  	
		  	실행결과 => 331
		  	
		 [3-6] 아래는 변수 의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 코드이다. 예를 들어,
		  24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우 20이고, 81의 경우 90이 된다. 30에서 24를 뺀 나머지는 6이기 때문에
		    변수 num의 값이 24라면 6을 결과로 얻어야 한다. (1)에 알맞은 코드를 넣으시오.
		    int num = 24;
		    System.out.println((num/10 + 1)*10 - num);
		    System.out.println(10 - num % 10);
		    
			실행결과 => 6
		    
		 [3-7] 아래는 화씨(Fahrenheit)를 섭씨(Celoius)로 변환하는 코드이다. 변환공식이 'C = 5/9 * (F -32)'라고 할 때,
		  (1)에 알맞은 코드를 넣으시오. 단, 변환 결과값은 소수점 셋째자리에서 반올림해야한다. (Math.round()를 사용하지 않고 처리할 것)
		  	int fahrenheity = 100;
		  	float celcius = (5/9f * (fahrenheity - 32));
		  	
		  	System.out.println("Fahrenheity : " + fahrenheity );
		  	System.out.println("Celcius : " + (int)(celcius * 100 + 0.5) / 100.0f);
		  	
		  	실행결과 => Fahrenheit : 100, Celcius : 37.78
		  	
		 [3-8] 아래 코드의 문제점을 수정해서 실행결과와 같은 결과를 얻도록 하시오.
		 	byte a = 10;
		 	byte b = 20;
		 	byte c = (byte)(a + b);
		 	
		 	char ch = 'A';
		 	ch = (char)(ch + 2);
		 	
		 	float f = 3 / 2f;
		 	long l = 3000 * 3000 * 3000l;
		 	
		 	float f2 = 0.1f;
		 	double d = 0.1;
		 	
		 	boolean result = (float)d==f2;
		 	
		 	System.out.println("c = " + c); => c = 30
		 	System.out.println("ch = " + ch); => ch = C
		 	System.out.println("f = " + f); => f = 1.5
		 	System.out.println("l = " + l); l => 27000000000
		 	System.out.println("result = + result); => result = true
		 	
		 [3-9] 다음은 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드이다.
		  (1)에 알맞은 코드를 넣으시오.
		  	char ch = 'z';
		  	boolean b = (ch >= 'a' && ch <= 'z || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9');
		  	
		  	System.out.println(b);
		  	
		  	실행결과 => true
		  	
		 [3-10] 다음은 대문자를 소문자로 변경하는  코드인데 문자 에 저장된 문자가 대문자인 경우에만 소문자로 변경한다. 문자코드는
		 소문자가 대문자보다 만큼 더 크다. 예를들어 'A'의 코드는 65이고 'a'의 코드는 97이다. (1)~(2)에 알맞은 코드를 넣으시오.
			char ch = 'A';
			
			char lowerCase = (ch >= 'A' && ch <= 'Z') ? ((char)(ch +32)) : ch;
			
			System.out.println("ch : " + ch);
			System.out.println("ch to lowerCase : " + lowerCase);
			
			실행결과 => ch : A , ch to lowerCase : a
		   
		  	

		*/
	}
}
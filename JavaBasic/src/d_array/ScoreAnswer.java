package d_array;

import java.util.Scanner;

public class ScoreAnswer {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 Java, Oracle, HTML, CSS, JQuery, JSP 점수를 50 ~ 100까지 랜덤으로 생성시키고
		 * 석차순으로 석차, 이름, 과목별 점수, 총점, 평균을 출력해주세요.
		 * 
		 * 석차	이름		Java	Oralce	HTML	CSS		JQeury	JSP		총점		평균
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 * 1	홍길동	100		100		100		100		100		100		600		100.0
		 */
		
		String[] students = new String[3];
		String[] subjects = new String[3];
		double[][] scores = new double[students.length][subjects.length + 3]; 
		// i = 학생수 만큼, j = 과목 수 + 석차 + 총점 + 평균이기때문에 => 과목수 + 3
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < students.length; i ++) {
			System.out.print("학생 이름 > ");
			students[i] = sc.nextLine();
		}
		
		for(int i = 0; i < students.length; i ++) {
			System.out.print("과목 > ");
			subjects[i] = sc.nextLine();
		}
		
		for(int i = 0; i < scores.length; i++){ // i < 학생수
			scores[i][0] = 1;
			for(int j = 0; j < subjects.length; j++) { // j < 과목수
				System.out.print(students[i] + "의 " + subjects[i] + "점수 > ");
				scores[i][j + 1] = Integer.parseInt(sc.nextLine());
				// scores[i][j + 1] = (int)(Math.random() * 51) + 50; // 50부터 100까지 점수를 랜덤 저장
			}
		}
		// scores[i][0] ==> 석차를 저장하기 위한 주소값
		// scores[i][j + 1] ==> 과목의 점수를 저장하기 위한 주소값, j = 석차를 저장하기 때문에 j + 1부터 점수를 저장함
		
		for(int i = 0; i < scores.length; i++) { // i < 학생수
			for(int j = 0; j < subjects.length; j++) { // j < 과목수
				scores[i][scores[i].length - 2] += scores[i][j + 1]; // 총점을 저장하기 위한 코드, scores[i].length - 2 인덱스 지정
			}
			scores[i][scores[i].length - 1] = // scores[i].length - 1 인덱스 지정
					(int)((double)scores[i][scores[i].length - 2] // scores[i].length - 2 인덱스 지정
							/ subjects.length * 100 + 0.5) / 100.0; // 평균을 저장하기 위한 코드, 반올림 저장
		}
				
		for(int i = 0; i < scores.length; i++){ // i < 학생수
			for(int j = 0; j < scores.length; j++){ // j < 학생수
				if(scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]){ // scores[i].length ==> 과목수 + 3
					scores[i][0]++; // 총점에 따라 석차를 정해주는 코드
				} // scores[i][scores[i].length - 1 첫번째 학생의 석차 , scores[j][scores[j].length - 1] 첫번째 학생부터 마지막 학생까지의 석차
			}
		}
		
		for(int i = 0; i < scores.length - 1; i++) { // i < 학생수
			for(int j = i + 1; j < scores.length; j++) { // j < 학생수
				if(scores[i][0] > scores[j][0]){ // 석차 비교
					double[] temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp; // 석차를 비교하여 점수의 위치를 변경하는 코드
					
					String tempName = students[i]; // 석차를 비교하여 학생 이름의 위치를 변경하는 코드
					students[i] = students[j];
					students[j] = tempName;
				}
			}
		}

		System.out.print("석차\t이름");
		for(int i = 0; i < subjects.length; i++) { // i < 과목수
			System.out.print("\t" + subjects[i]); // 과목을 출력하는 코드, \t는 탭을 출력함
		}
		System.out.println("\t총점\t평균");
		
		for(int i = 0; i < scores.length; i++) { // i < 학생수
			System.out.print((int)scores[i][0] + "\t" + students[i]);
			// (int)scores[i][0] ==> 석차를 인트형으로 형변환 하여 출력
			// students[i] ==> 학생의 이름 출력
			for(int j = 1; j < scores[i].length; j++) { // j = 0은 석차,  j = 1부터 j < 과목수 + 3
				
				if(j == scores[i].length - 1) { // j 와 평균의 인덱스를 비교 scores[i].length - 1 = 8, , 첫번째 과목부터 인덱스 비교
					System.out.print("\t" + scores[i][j]); // j와 평균의 인덱스가 같을시에 평균을 출력
				} else {
					System.out.print("\t" + (int)scores[i][j]); // 그외 인트형으로 형변환 하여 출력
				}
			}
			System.out.println();
		}
	}

}

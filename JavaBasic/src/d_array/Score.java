package d_array;

import java.util.Arrays;

public class Score {
	public static void main(String[] args) {
		/*
		 *  우리반 모두의 Java, Oracle, HTML, CSS, JQuery, JSP 점수를 50 ~ 100까지 랜덤으로 생성시키고
		 *  석차순으로 석차, 이름, 과목별 점수, 총점, 평균을 출력해주세요
		 *  
		 *  석차		이름		Java	Oracle	HTML	CSS		JQuery	JSP		총점		평균
		 *  1		홍길동	100		100		100		100		100		100		600		100.0
		 *  1		홍길동	100		100		100		100		100		100		600		100.0
		 *  1		홍길동	100		100		100		100		100		100		600		100.0
		 *  1		홍길동	100		100		100		100		100		100		600		100.0
		 *  1		홍길동	100		100		100		100		100		100		600		100.0
		 */
		
		// 과제 : 성적입력프로그램 만들기 
		// 한줄삭제 : Ctrl + d
		// 한줄복사 : Ctrl + Alt + 방향키(위/아래)
		// 한줄이동 : Alt + 방향키(위/아
		
		String[] name = new String[] { "김동훈", "김아현", "김지수", "김찬희", "박경범", "박성하", "박하은", 
						"박해선", "안승원", "오송현", "원종찬", "유효상", "이원우", "이재민", "이지윤", "이헌이",
						"이희욱", "정성훈", "정재은", "정지수", "정혁도", "채홍규" };
		String[] item = new String[] { "석차", "이름", "Java", "Oracle", "HTML", "CSS", "JQuery", "JSP", "총점", "평균" };
		int[][] score = new int[name.length][6];
		int[] rank = new int[name.length];
		int[] sum = new int[name.length];
		double[] avg = new double[name.length];
		int[] sTemp = new int[name.length];
		
		int tmp = 0;
		double tmp1 = 0;
		int index = 0;
		String nTmp = "";
		
		for(int i = 0; i < score.length; i ++) {
			for(int j = 0; j < score[i].length; j ++) {
				score[i][j] = (int)(Math.round(Math.random() * 51) + 50);
				sum[i] += score[i][j];
			}
			avg[i] = sum[i] / (double)score[i].length;
		}
		for(int i = 0; i < rank.length; i++) {
			rank[i] = 1;
		}

		for(int i = 0; i < avg.length; i ++) {
			for(int j = 0; j < avg.length; j ++) {
				if(avg[i] < avg[j]) {
					rank[i] += 1;
				}
			}
		}
		
		for(int i = 0; i < item.length; i ++) {
			System.out.print(item[i] + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < rank.length; i ++) {
			int min = 9999;
			for(int j = i; j < rank.length; j ++) {
				if(min > rank[j]) {					
					min = rank[j];
					index = j;
				}
			}
			
			tmp = rank[i];
			rank[i] = rank[index];
			rank[index] = tmp;
			nTmp = name[i];
			name[i] = name[index];
			name[index] = nTmp;
			sTemp = score[i];
			score[i] = score[index];
			score[index] = sTemp;
			tmp = sum[i];
			sum[i] = sum[index];
			sum[index] = tmp;
			tmp1 = avg[i];
			avg[i] = avg[index];
			avg[index] = tmp1;
		}
		
		
		for(int i = 0; i < score.length; i ++) {
			System.out.print(rank[i] + "\t" + name[i]);
			for(int j = 0; j < score[0].length; j ++) {
				System.out.print("\t" + score[i][j]);
			}
			System.out.print("\t" + sum[i] + "\t" + avg[i]);
			
			System.out.println();
		}
		
	}
}
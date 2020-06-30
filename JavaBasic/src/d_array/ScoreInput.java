package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreInput {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String searchStd = "";
		String sTemp = "";
		int temp = 0;
		double avgTemp = 0.0;
		System.out.print("성적을 입력할 학생의 수를 입력하세요> ");
		int stdNumber = sc.nextInt();
		System.out.print("과목의 수를 입력하세요> ");
		int subNumber = sc.nextInt();
		sc.nextLine();

		String[] students = new String[stdNumber];
		String[] subject = new String[subNumber];
		int[][] scores = new int[students.length][subject.length];
		int[] scoreTmp = new int[students.length];
		int[] rank = new int[students.length];
		int[] sum = new int[students.length];
		double[] avg = new double[students.length];
		
		for(int i = 0; i < subject.length; i ++) {
			System.out.print("과목명을 입력하세요> ");
			subject[i] = sc.nextLine();
		}
		
		for(int i = 0; i < students.length; i ++) {
			System.out.print("성적을 입력할 학생의 이름을 입력하세요> ");
			students[i] = sc.nextLine();
		}
		
		for(int i = 0; i < scores.length; i ++) {
			for(int j = 0; j < subject.length; j  ++) {
				System.out.print(students[i] + "의 성적을 입력하세요> ");
				scores[i][j] = sc.nextInt();
				sum[i] += scores[i][j];
			}
			avg[i] = (double)sum[i] / scores[i].length;
		}
		
		for(int i = 0; i < rank.length; i ++) {
			rank[i] = 1;
		}
		
		for(int i = 0; i < avg.length; i ++) {
			int index = 0;
			for(int j = 0; j < avg.length; j ++) {
				if(avg[i] < avg[j]) {
					rank[i] += 1;
				}
			}
		}
		
		int index = 0;
		
		for(int i = 0; i < rank.length; i ++) {
			int min = 9999;
			for(int j = i; j < rank.length; j ++) {
				if(min > rank[j]) {					
					min = rank[j];
					index = j;
				}
			}
			sTemp = students[i];			
			students[i] = students[index];
			students[index] = sTemp;
			
			temp = rank[i];
			rank[i] = rank[index];
			rank[index] = temp;
			
			scoreTmp = scores[i];
			scores[i] = scores[index];
			scores[index] = scoreTmp;
			
			temp = sum[i];
			sum[i] = sum[index];
			sum[index] = temp;
			
			avgTemp = avg[i];
			avg[i] = avg[index];
			avg[index] = avgTemp;
			
		}
		sc.nextLine();
		while(true){
			System.out.print("조회하고 싶은 학생의 이름을 입력하세요> ");
			searchStd = sc.nextLine();
			
			if(searchStd.equals("그만")){
				break;
			} else if(searchStd.equals("전체")) {
				for(int i = 0; i < scores.length; i ++) {
					System.out.print(rank[i] + "\t" + students[i]);
					for(int j = 0; j < scores[0].length; j ++) {
						System.out.print("\t" + scores[i][j]);
					}
					System.out.print("\t" + sum[i] + "\t" + avg[i]);
					
					System.out.println();
				}
			}
			index = 0;
			for(int i = 0; i < students.length; i ++) {
				if(students[i].equals(searchStd)) {
					index = i;
					break;
				}
			}
			if(students[index].equals(searchStd)) {
				System.out.print(rank[index] + "\t" + students[index]);
				for(int j = 0; j < scores[0].length; j ++) {
					System.out.print("\t" + scores[index][j]);
				}
				System.out.print("\t" + sum[index] + "\t" + avg[index]);
				System.out.println();
			}
			
			
		}

		
	}
}
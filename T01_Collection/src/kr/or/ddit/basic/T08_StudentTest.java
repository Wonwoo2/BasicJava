package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *  문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버변수로 갖는
 *  	 Student 클래스를 만든다.
 *  	 
 *  	  이 Student 객체들은 List에 저장하여 관리한다.
 *  	 List에 저장된 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과 총점의
 *  	  역순으로 정렬하는 부분을 프로그램 하시오.
 *  	 (총점이 같으면 학번의 내림차순으로 정렬되도록 하시오)
 *  	 (학번 정렬기준은 Student클래스 자체에서 제공하도록 하고,
 *  	  총점 정렬기준은 외부클래스에서 제공하도록 한다.)
 *  
 */
public class T08_StudentTest {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student(20200602, "홍길동", 43, 90, 83));
		studentList.add(new Student(20200712, "일지매", 75, 65, 85));
		studentList.add(new Student(20201222, "강감찬", 75, 65, 85));
		studentList.add(new Student(20200112, "이원우", 56, 71, 85));
		studentList.add(new Student(20200201, "김원우", 42, 35, 45));
		
		
		
		for (int i = 0; i < studentList.size(); i ++) {
			Student std = studentList.get(i);
			std.setSum(std.getKor() + std.getEng() + std.getMath());
			std.setRank(1);
			studentList.set(i, std);
		}

		for (int i = 0; i < studentList.size(); i ++) {
			Student std = studentList.get(i);
			for (int j = 0; j < studentList.size(); j ++) {
				Student std1 = studentList.get(j);
				if(std.getSum() < std1.getSum()) {
					std.setRank(std.getRank() + 1);
				}
			}
			studentList.set(i, std);
		}
		System.out.println("=================================== 정렬하기 전 ===================================");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("===============================================================================");
		
		Collections.sort(studentList);
		System.out.println();		
		
		System.out.println();
		System.out.println("================================= 학번으로 정렬 후 ===================================");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("===============================================================================");
		Collections.sort(studentList, new sumDesc());
		System.out.println();
		
		System.out.println();
		System.out.println("================================= 총점으로 정렬 후 ===================================");
		for (Student std : studentList) {
			System.out.println(std);
		}
		System.out.println("===============================================================================");
	}
}

class Student implements Comparable<Student> {
	private int stdNo;
	private String stdName;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;

	public Student(int stdNo, String stdName, int kor, int eng, int math) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getStdNo() {
		return stdNo;
	}

	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "학번 : " + stdNo + ", 이름 : " + stdName + ", 국어점수 : " + kor + ", 영어점수 : " + eng + ", 수학점수 : " + math
				+ ", 총점 : " + sum + ", 등수 : " + rank;
	}

	@Override
	public int compareTo(Student std) {
		if(getStdNo() > std.getStdNo()) {
			return 1;
		} else if(getStdNo() < std.getStdNo()) {
			return -1;
		} else {
			return 0;
		}
	}
}

class sumDesc implements Comparator<Student> {

	@Override
	public int compare(Student first, Student second) {
		if(first.getSum() > second.getSum()) {
			return -1;
		} else if(first.getSum() < second.getSum()) {
			return 1;
		} else {
			return Integer.compare(first.getStdNo(), second.getStdNo()) * -1;
		}
	}
}
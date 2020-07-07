package kr.or.ddit.exam4.vo;

import java.util.List;

public class ScoreVO {
	private String name;
	private int kor;
	private int math;
	private int eng;
	
	private List<ScoreVO> scoreList;
	
	public ScoreVO(String name, int kor, int math, int eng) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public List<ScoreVO> getScoreList() {
		return scoreList;
	}
}
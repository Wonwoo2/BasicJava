package d_array;

import java.util.Scanner;

public class InputScore {
	public static Scanner sc = new Scanner(System.in);
	private static int stdNumber;
	private static int subNumber;
	private static int index;
	private static int subIndex;

	public static int getSubIndex() {
		return subIndex;
	}

	public static void setSubIndex(int subIndex) {
		InputScore.subIndex = subIndex;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		InputScore.index = index;
	}

	private static String[] students;
	private static String[] subjects;

	public static String[] getStudents() {
		return students;
	}

	public static void setStudents(String[] students) {
		InputScore.students = students;
	}

	public static String[] getSubjects() {
		return subjects;
	}

	public static void setSubjects(String[] subjects) {
		InputScore.subjects = subjects;
	}

	public int getSubNumber() {
		return subNumber;
	}

	public int getStdNumber() {
		return stdNumber;
	}

	public void setStdNumber(int stdNumber) {
		this.stdNumber = stdNumber;
	}

	public void setSubNumber(int subNumber) {
		this.subNumber = subNumber;
	}

	public static void main(String[] args) {
		String search = "";
		int index = 0;

		System.out.print("학생의 수를 입력하세요 > ");
		InputScore.stdNumber = sc.nextInt();

		students = new String[stdNumber];
		sc.nextLine();

		System.out.print("과목의 수를 입력하세요 > ");
		InputScore.subNumber = sc.nextInt();

		InputScore.subjects = new String[subNumber];
		sc.nextLine();

		double[][] scores = new double[students.length][subjects.length + 3];

		while (true) {
			System.out.print("실행할 명령을 입력해주세요(조회, 입력, 수정, 삭제) > ");
			String cmd = sc.nextLine();

			if (cmd.equals("그만")) {
				System.out.println("성적관리 프로그램을 종료합니다.");
				break;
			} else if (cmd.equals("조회")) {
				System.out.print("성적을 조회할 학생의 이름을 입력하세요 > (전체조회 : 전체) ");
				search = sc.nextLine();

				if (search.equals("전체")) {
					System.out.print("석차\t이름");
					for (int i = 0; i < InputScore.subjects.length; i++) {
						System.out.print("\t" + InputScore.subjects[i]);
					}
					System.out.println("\t총점\t평균");
					for (int i = 0; i < scores.length; i++) {
						System.out.print((int) scores[i][0] + "\t"
								+ InputScore.students[i]);
						for (int j = 1; j < scores[i].length; j++) {
							if (j == scores[i].length - 1) {
								System.out.print("\t" + scores[i][j]);
							} else {
								System.out.print("\t" + (int) scores[i][j]);
							}
						}
						System.out.println();
					}
					
				} else if (isName(search)) {
					System.out.print("석차\t이름");
					for (int i = 0; i < InputScore.subjects.length; i++) {
						System.out.print("\t" + InputScore.subjects[i]);
					}
					System.out.println("\t총점\t평균");
					for (int i = 0; i < scores.length; i++) {
						System.out.print((int) scores[InputScore.index][0]
								+ "\t" + InputScore.students[InputScore.index]);
						for (int j = 1; j < scores[InputScore.index].length; j++) {
							if (j == scores[InputScore.index].length - 1) {
								System.out.print("\t"
										+ scores[InputScore.index][j]);
							} else {
								System.out.print("\t"
										+ (int) scores[InputScore.index][j]);
							}
						}
						System.out.println();
						break;
					}
				} else {
					System.out.println("성적을 조회할 수 없습니다. 성적 입력을 해주세요.");
				}
			} else if (cmd.equals("입력")) {
				scoreInput(scores);
			} else if (cmd.equals("수정")) {
				System.out.print("성적을 수정할 학생의 이름을 입력하세요 > ");
				search = sc.nextLine();
				if(isName(search)){		
					System.out.print("수정할 과목을 입력해주세요 > ");
					search = sc.nextLine();
					
					if(isSubject(search)) {
						scoreUpdate(scores);
					} else {
						System.out.print("입력하신 과목은 없는 과목입니다.");
						break;
					}
				}
			} else if (cmd.equals("삭제")) {
				System.out.print("성적을 삭제할 학생의 이름을 입력하세요 > ");
				search = sc.nextLine();
				if(isName(search)) {
					delete(scores);
				} else {
					System.out.print("잘못입력하셨습니다");
					break;
				}
			}
		}
	}
	
	public static double[][] scoreInput(double[][] scores) {

		String[] students = new String[stdNumber];
		String[] subjects = new String[subNumber];
		for (int i = 0; i < students.length; i++) {
			System.out.print("성적을 입력할 학생의 이름을 입력하세요 > ");
			InputScore.students[i] = sc.nextLine();
		}

		for (int i = 0; i < subjects.length; i++) {
			System.out.print("과목을 입력해주세요 > ");
			InputScore.subjects[i] = sc.nextLine();
		}

		for (int i = 0; i < InputScore.students.length; i++) {
			scores[i][0] = 1;
			for (int j = 0; j < InputScore.subjects.length; j++) {
				System.out.print(InputScore.students[i] + "의 "
						+ InputScore.subjects[j] + "점수 > ");
				scores[i][j + 1] = Integer.parseInt(sc.nextLine());
			}
		}

		for (int i = 0; i < InputScore.students.length; i++) {
			for (int j = 0; j < InputScore.subjects.length; j++) {
				scores[i][scores[i].length - 2] += scores[i][j + 1];
			}
			scores[i][scores[i].length - 1] = (int) ((double) scores[i][scores[i].length - 2]
					/ subjects.length * 100 + 0.5) / 100.0;
		}

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				if (scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]) {
					scores[i][0]++;
				}
			}
		}

		for (int i = 0; i < scores.length - 1; i++) {
			for (int j = i + 1; j < scores.length; j++) {
				if (scores[i][0] > scores[j][0]) {
					double[] temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;

					String tempName = InputScore.students[i];
					InputScore.students[i] = InputScore.students[j];
					InputScore.students[j] = tempName;
				}
			}
		}
		return scores;
	}
	
	public static double[][] scoreUpdate(double[][] scores) {

		String[] students = new String[stdNumber];
		String[] subjects = new String[subNumber];

		System.out.print(InputScore.students[InputScore.index] + "의 "
						+ InputScore.subjects[InputScore.subIndex] + "점수 > ");
		scores[InputScore.index][InputScore.subIndex + 1] = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < InputScore.students.length; i ++) {
			for (int j = 0; j < InputScore.subjects.length; j ++) {
				scores[i][scores[i].length - 2] = 0;
			}
		}

		for (int i = 0; i < InputScore.students.length; i++) {
			scores[i][0] = 1;
			for (int j = 0; j < InputScore.subjects.length; j++) {
				scores[i][scores[i].length - 2] += scores[i][j + 1];
			}
			scores[i][scores[i].length - 1] = (int) ((double) scores[i][scores[i].length - 2]
					/ subjects.length * 100 + 0.5) / 100.0;
		}

		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				if (scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]) {
					scores[i][0]++;
				}
			}
		}

		for (int i = 0; i < scores.length - 1; i++) {
			for (int j = i + 1; j < scores.length; j++) {
				if (scores[i][0] > scores[j][0]) {
					double[] temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;

					String tempName = InputScore.students[i];
					InputScore.students[i] = InputScore.students[j];
					InputScore.students[j] = tempName;
				}
			}
		}
		return scores;
	}
	
	public static double[][] delete(double[][] scores) {
		InputScore.students[InputScore.index] = null;
		for(int i = 0; i < InputScore.students.length; i ++) {
			for(int j = 0; j < scores[i].length; j ++) {
				scores[InputScore.index][j] = 0.0;
			}
			scores[i][0] = 1;
		}
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores.length; j++) {
				if (scores[i][scores[i].length - 1] < scores[j][scores[j].length - 1]) {
					scores[i][0]++;
				}
			}
		}
		String tempName = "";

		for (int i = 0; i < scores.length - 1; i++) {
			for (int j = i + 1; j < scores.length; j++) {
				if (scores[i][0] > scores[j][0]) {
					double[] temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;

					tempName = InputScore.students[i];
					InputScore.students[i] = InputScore.students[j];
					InputScore.students[j] = tempName;
				}
			}
		}
		return scores;
	}

	public static boolean isName(String search) {
		for (int i = 0; i < InputScore.students.length; i ++) {
			if (InputScore.students[i].equals(search)) {
				InputScore.index = i;
				return true;
			}
		}
		for (int i = 0; i < InputScore.subjects.length; i ++) {
			if (InputScore.subjects[i].equals(search)) {
				InputScore.index = i;
				return true;
			} 
		}
		return false;
	}
	
	public static boolean isSubject(String search) {
		for (int i = 0; i < InputScore.subjects.length; i ++) {
			if (InputScore.subjects[i].equals(search)) {
				InputScore.subIndex = i;
				return true;
			} 
		}
		return false;
	}

}
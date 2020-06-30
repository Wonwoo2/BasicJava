package i_collection;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import useful.ScanUtil;

public class Board {
	
	static ArrayList<HashMap<String, Object>> board;
	
	Board() {
		board = new ArrayList<>();
	}

	public static void main(String[] args) {
		// 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요
		// 번호, 제목, 내용, 작성자, 작성일
		
		// 처음엔 목록이 출력
		// 1. 조회	2. 등록	3. 프로그램 종료
		// 조회시 : 1. 수정	2. 삭제	3. 목록
		
		Board b = new Board();
		
		SimpleDateFormat form = new SimpleDateFormat ( "yyyy:MM:dd");
		
		HashMap<String, Object> hm = new HashMap<>();
		
		
		System.out.println("번호\t제목\t\t작성자\t작성일");
		while(true) {
			
			System.out.println("===========================================");
			for (int i = 0; i < board.size(); i ++) {
				hm = board.get(i);
				System.out.print(hm.get("번호") + "\t");
				System.out.print(hm.get("제목") + "\t");
				System.out.print("\t" + hm.get("작성자") + "\t");
				System.out.println(form.format(hm.get("작성일")));
			}
			
			System.out.println("===========================================");
			System.out.println("1. 조회\t2. 등록\t0. 종료");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1: // 조회
				System.out.println("1. 수정\t2. 삭제\t3. 목록\t0. 종료");
				input = ScanUtil.nextInt();
				switch (input) {
				case 1:
					// 수정
					b.Update(hm);
					break;
				case 2:
					// 삭제
					b.Delete(hm);
					break;
				case 3:
					// 목록
					b.read(hm);
					break;
				case 4:
					// 종료
					System.exit(0);
					break;
				}
				break;
			case 2: // 등록
				b.write();
				System.out.println("번호\t제목\t\t작성자\t작성일");
				break;
			case 0: // 종료
				System.exit(0);
				break;
			}
		}
	}
	
	void Delete(HashMap<String, Object> h) {
		System.out.print("작성자 > ");
		String name = ScanUtil.nextLine();
		
		System.out.print("게시판번호 > ");
		Object num = ScanUtil.nextInt();
		
		for (int i = 0; i < board.size(); i ++) {
			h = board.get(i);
			if(h.get("번호") == num && h.get("작성자").equals(name)) {
				board.remove(i);
				break;
			}
		}
		
		for (int i = 0; i < board.size(); i ++) {
			h = board.get(i);
			h.put("번호", i+1);
		}
	}
	
	void Update(HashMap<String, Object> h) {
		System.out.print("게시판번호 > ");
		Object num = ScanUtil.nextInt();
		
		for (int i = 0; i < board.size(); i ++) {
			h = board.get(i);
			if(h.get("번호") == num) {
				System.out.print("제목 입력 > ");
				String title = ScanUtil.nextLine();
				h.put("제목", title);
				System.out.print("내용 입력 > ");
				String content = ScanUtil.nextLine();
				h.put("내용", content);
				h.put("작성일", new Date());
				break;
			}
		}
	}
	
	void read(HashMap<String, Object> h) {
		System.out.print("제목 입력 > ");
		String title = ScanUtil.nextLine();
		
		for (int i = 0; i < board.size(); i ++) {
			h = board.get(i);
			if(h.get("제목").equals(title)) {
				System.out.println("=====================");
				System.out.println("제목 : " + h.get("제목"));
				System.out.println("=====================");
				System.out.println("내용 : " + h.get("내용"));
				
			}
		}
	}
	
	void write() {
		System.out.print("제목 : ");
		String bTitle = ScanUtil.nextLine();
		System.out.print("내용 : ");
		String bContent = ScanUtil.nextLine();
		System.out.print("작성자 :");
		String bUser = ScanUtil.nextLine();

		dataInsert(bTitle, bContent, bUser);
	}
	
	void dataInsert(String title, String content, String user) {
		HashMap<String, Object> data = new HashMap<>();
		data.put("번호", board.size() + 1);
		data.put("제목", title);
		data.put("내용", content);
		data.put("작성자", user);
		data.put("작성일", new Date());
		
		board.add(data);
	}
}
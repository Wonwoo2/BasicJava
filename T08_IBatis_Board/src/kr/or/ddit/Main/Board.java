package kr.or.ddit.Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

public class Board {
	
	private IBoardService service;
	private Scanner scan;
	
	public Board() {
		service = BoardServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}
	public void board() {
		int choice;
		do {
			showMenu();
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:		// 게시판 작성
				boardWrite();
				break;
			case 2:		// 게시판 수정
				boardUpdate();
				break;
			case 3:		// 게시판 삭제
				boardDelete();
				break;
			case 4:		// 게시판 검색
				boardSearch();
				break;
			case 5:		// 전체 게시판 목록 출력
				boardList();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못입력하셨습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while(choice != 6);
	}

	public void showMenu() {
		System.out.println();
		System.out.println("========= 게시판 =========");
		System.out.println("-----------------------");
		System.out.println("  1. 게시판 작성");
		System.out.println("  2. 게시판 수정");
		System.out.println("  3. 게시판 삭제");
		System.out.println("  4. 게시판 검색");
		System.out.println("  5. 게시판 출력");
		System.out.println("  6. 프로그램 종료");
		System.out.println("-----------------------");
		System.out.print("메뉴를 고르세요 >> ");
	}
	
	/**
	 *  게시판을 작성하는 메서드
	 */
	public void boardWrite() {
		
		System.out.println("======================");
		System.out.print("제목 : ");
		String boardTitle = scan.next().trim();
		System.out.println("======================");
		scan.nextLine();
		
		System.out.print("내용 : ");
		String boardContent = scan.nextLine().trim();
		
		System.out.println("======================");
		System.out.print("작성자 : ");
		String boardWriter = scan.next().trim();
		System.out.println("======================");
		
		BoardVO bd = new BoardVO();
		Date boardDate = new Date();
		
		bd.setBoard_title(boardTitle);
		bd.setBoard_writer(boardWriter);
		bd.setBoard_date(boardDate);
		bd.setBoard_content(boardContent);

		Object obj = service.insertBoard(bd);
		
		if(obj == null) {
			System.out.println("게시판 작성 완료");
		} else {
			System.out.println("게시판 작성 실패");
		}
	}
	
	/**
	 *  게시판을 수정하는 메서드
	 */
	public void boardUpdate() {
		int board_no = 0;
		boolean check = false;

		do {
			boardView();
			System.out.print("수정할 게시글 번호를 입력 >> ");
			board_no = scan.nextInt();
			
			check = service.isBoard(board_no);
			if (check == false) {
				System.out.println(board_no + "는 존재하지 않는 게시글 번호 입니다.");
				System.out.println("다시 입력하세요.");
			}
		} while(check == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 게시판 제목 >> ");
		String boardTitle = scan.next().trim();
		scan.nextLine();
		
		System.out.print("새로운 게시판 내용 >> ");
		String boardContent = scan.nextLine();
		
		BoardVO bd = new BoardVO();
		
		bd.setBoard_no(board_no);
		bd.setBoard_title(boardTitle);
		bd.setBoard_content(boardContent);
		
		int cnt = service.updateBoard(bd);
		
		if(cnt > 0) {
			System.out.println("게시판 수정 성공");
		} else {
			System.out.println("게시판 수정 실패");
		}
	}
	
	/**
	 *  게시판을 삭제하는 메서드
	 */
	public void boardDelete() {
		int boardNo;

		boardView();
			
		System.out.print("삭제할 게시글 번호 입력 >>");
		boardNo = scan.nextInt();
		
		int cnt = service.deleteBoard(boardNo);
		
		if(cnt > 0) {
			System.out.println("게시판 삭제 성공");
		} else {
			System.out.println("게시판 삭제 실패");
		}
	}
	
	/**
	 *  게시판을 검색하는 메서드
	 */
	public void boardSearch() {
		
		scan.nextLine();		// 입력버퍼 비우기
		System.out.println("검색할 정보를 입력하세요.");
		System.out.print("게시글 번호 >> ");
		String boardNo = scan.nextLine().trim();
		
		System.out.print("게시판 제목 >> ");
		String boardTitle = scan.nextLine().trim();
		
		System.out.print("게시판 내용 >> ");
		String boardContent = scan.nextLine().trim();
		
		System.out.print("게시판 작성자 >> ");
		String boardWriter = scan.nextLine().trim();

		BoardVO bd = new BoardVO();
		
		if(boardNo != null && !boardNo.equals("")) {
			bd.setBoard_no(Integer.parseInt(boardNo));
		}
		bd.setBoard_title(boardTitle);
		bd.setBoard_writer(boardWriter);
		bd.setBoard_content(boardContent);
		
		List<BoardVO> boardList = service.getSearchBoard(bd);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("======================= 게시판 목록 ========================");
		System.out.println("게시글번호\t제목\t\t작성자\t작성일");
		System.out.println("========================================================");
		for (BoardVO board : boardList) {
			System.out.println(board.getBoard_no() + "\t"
							+ board.getBoard_title() + "\t\t"
							+ board.getBoard_writer() + "\t"
							+ format.format(board.getBoard_date()));
			System.out.println("========================================================");
		}
		
		System.out.print("확인할 게시글 번호 입력 >> ");
		int board_No = scan.nextInt();
		readBoard(board_No);
		
	}
	
	/**
	 * 하나의 게시판을 출력하는 메서드
	 * @param boardNo
	 */
	public void readBoard(int boardNo) {
		
		BoardVO boardVo = service.getBoard(boardNo);
		
		if(boardVo == null) {
			System.out.println("잘못된 게시글 번호입니다.");
			return;
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("============================================================");
		System.out.println("게시글 번호\t\t제목\t\t작성자\t작성일");
		System.out.println("============================================================");
		System.out.println(boardVo.getBoard_no() + "\t\t" 
						+ boardVo.getBoard_title() + "\t\t" 
						+ boardVo.getBoard_writer() + "\t" 
						+ format.format(boardVo.getBoard_date()));
		System.out.println("============================================================");
		System.out.println("내용 : ");
		System.out.println(boardVo.getBoard_content());
		System.out.println("============================================================");
		
	}

	/**
	 *  전체 게시판 목록 출력하고 게시판 확인하는 메서드
	 */
	public void boardList() {
		boardView();
		System.out.print("확인할 게시글 번호 입력 >> ");
		int boardNo = scan.nextInt();
		readBoard(boardNo);
	}
	
	/**
	 *  전체 게시판 목록 보여주는 메소드
	 */
	public void boardView() {
		List<BoardVO> boardList = service.getAllBoardList();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println("========================== 게시판목록 ==========================");
		System.out.println("게시글번호\t제목\t\t작성자\t작성일");
		System.out.println("============================================================");
		
		for (BoardVO board : boardList) {
			System.out.println(board.getBoard_no() + "\t"
							+ board.getBoard_title() + "\t\t"
							+ board.getBoard_writer() + "\t"
							+ format.format(board.getBoard_date()));
			System.out.println("============================================================");
		}
	}

	public static void main(String[] args) {
		new Board().board();
	}
}
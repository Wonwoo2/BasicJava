package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.scene.control.TableColumn;
import javafx.scene.Node;
import javafx.scene.control.Pagination;

public class T19_PagingController implements Initializable {

	@FXML TableView<MemberVO> tbView;
	@FXML TableColumn<MemberVO, String> id;
	@FXML TableColumn<MemberVO, String> name;
	@FXML TableColumn<MemberVO, String> addr;
	@FXML Pagination pagiNation;

	private int from, to, countForPage;
	
	private ObservableList<MemberVO> allTableData, currentPageData;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<>("id"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		addr.setCellValueFactory(new PropertyValueFactory<>("addr"));
		
		// 테이블 데이터 설정
		allTableData = FXCollections.observableArrayList(
				new MemberVO("1", "홍길동1", "대전시 중구 대흥동1"), 
				new MemberVO("2", "홍길동2", "대전시 서구 대흥동2"), 
				new MemberVO("3", "홍길동3", "대전시 유성구 대흥동3"), 
				new MemberVO("4", "홍길동4", "대전시 동구 대흥동4"), 
				new MemberVO("5", "홍길동5", "대전시 동구 대동5"), 
				new MemberVO("6", "홍길동6", "대전시 동구 대흥동6"), 
				new MemberVO("7", "홍길동7", "대전시 중구 대흥동7"), 
				new MemberVO("8", "홍길동8", "대전시 중구 대흥동8"), 
				new MemberVO("9", "홍길동9", "대전시 중구 대흥동9"), 
				new MemberVO("10", "홍길동10", "대전시 중구 대흥동10"), 
				new MemberVO("11", "홍길동11", "대전시 중구 대흥동11"), 
				new MemberVO("12", "홍길동12", "대전시 중구 대흥동12"), 
				new MemberVO("13", "홍길동13", "대전시 중구 대흥동13"), 
				new MemberVO("14", "홍길동14", "대전시 중구 대흥동14"), 
				new MemberVO("15", "홍길동15", "대전시 중구 대흥동15"), 
				new MemberVO("16", "홍길동16", "대전시 중구 대흥동16")
		);
		
		tbView.setItems(allTableData);
		
		int totalCnt = allTableData.size();		// 전체 레코드 수
		countForPage = 5;
		
		int totalPageCnt = ((totalCnt - 1) / countForPage) + 1;		// 전체 페이지 수
		
		pagiNation.setPageCount(totalPageCnt);
		
		pagiNation.setPageFactory(new Callback<Integer, Node>( ) {
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * countForPage;
				to = from + countForPage - 1;
				
				tbView.setItems(getTableViewData(from, to));
				return tbView;
			}
		});
	}
	
	public ObservableList<MemberVO> getTableViewData(int from, int to) {
		currentPageData = FXCollections.observableArrayList();		// 초기화
		int totCnt = allTableData.size();		// 전체 테이블 데이터의 갯수
		
		for (int i = from; i <= to && i < totCnt; i ++) {		// 매개변수 from에서 to, totCnt까지 반복한다.
			currentPageData.add(allTableData.get(i));
		}
		return currentPageData;
	}
}
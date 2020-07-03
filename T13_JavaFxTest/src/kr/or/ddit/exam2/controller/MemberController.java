package kr.or.ddit.exam2.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.exam2.service.IMemberService;
import kr.or.ddit.exam2.service.MemberServiceImpl;
import kr.or.ddit.exam2.vo.MemberVO;
import javafx.event.ActionEvent;

public class MemberController implements Initializable{

	@FXML TableView<MemberVO> mem_tbView;
	@FXML TableColumn<MemberVO, String> id;
	@FXML TableColumn<MemberVO, String> name;
	@FXML TableColumn<MemberVO, String> tel;
	@FXML TableColumn<MemberVO, String> addr;
	@FXML TextField id_Txt;
	@FXML TextField name_Txt;
	@FXML TextField tel_Txt;
	@FXML TextField addr_Txt;
	@FXML Button add_Btn;
	@FXML Button edit_Btn;
	@FXML Button del_Btn;
	@FXML Button confirm_Btn;
	@FXML Button cancel_Btn;

	private List<MemberVO> memList;
	private IMemberService service;
	private ObservableList<MemberVO> obMemList;
	
	
	private boolean btnFlag = true;
	private boolean txtFlag = false;
	int choiceIndex;
	
	
	public MemberController() {
		service = MemberServiceImpl.getInstance();
		memList = new ArrayList<>();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memList = service.getMemberList();
		
		obMemList = FXCollections.observableArrayList(memList);
		
		id.setCellValueFactory(new PropertyValueFactory<>("mem_id"));
		name.setCellValueFactory(new PropertyValueFactory<>("mem_name"));
		tel.setCellValueFactory(new PropertyValueFactory<>("mem_tel"));
		addr.setCellValueFactory(new PropertyValueFactory<>("mem_addr"));
		
		mem_tbView.setItems(obMemList);
		
		id_Txt.setPromptText("회원ID");
		name_Txt.setPromptText("회원이름");
		tel_Txt.setPromptText("회원전화");
		addr_Txt.setPromptText("회원주소");
		
		setTextEditable();
		setBtnDisivle();

		mem_tbView.setOnMouseClicked(e -> {
			MemberVO memVo = mem_tbView.getSelectionModel().getSelectedItem();
			
			if(memVo == null) {
				return;
			}
			
			id_Txt.setText(memVo.getMem_id());
			name_Txt.setText(memVo.getMem_name());
			tel_Txt.setText(memVo.getMem_tel());
			addr_Txt.setText(memVo.getMem_addr());
		});
		
		
	}

	@FXML public void add(ActionEvent event) {
		btnFlag = false;		// 추가, 수정, 삭제 비활성화
		setBtnDisivle();
		textClear();
		
		txtFlag = true;
		setTextEditable();
		
		id_Txt.requestFocus();
		
		confirm_Btn.setOnAction(e -> {
			if(isText()) {
				errorMsg("입력 오류", "빈 항목이 있습니다.");
				return;
			}
			
			int cnt = service.isMember(id_Txt.getText());
			
			if(cnt > 0) {
				errorMsg("중복 오류", "중복된 아이디입니다.");
				return;
			}
			
			MemberVO mv = setMember();
			boolean result = obMemList.add(mv);
			mv = service.insertMember(mv);
			
			if(result && mv == null) {
				infoMsg("작업 성공", "회원 추가 성공하였습니다.");
				mem_tbView.setItems(obMemList);
				btnFlag = true;
				setBtnDisivle();
				setTextEditable();
				textClear();
			} else {
				infoMsg("작업 오류", "회원 추가 실패하였습니다.");
				btnFlag = true;
				setBtnDisivle();
				setTextEditable();
				textClear();
			}
		});
	}
	
	@FXML public void edit(ActionEvent event) {
		btnFlag = false;
		setBtnDisivle();
		
		txtFlag = true;
		setTextEditable();
		
		id_Txt.setEditable(false);
		
		confirm_Btn.setOnAction(e -> {
			if(isText()) {
				errorMsg("입력 오류", "빈 항목이 있습니다.");
				return;
			}
			choiceIndex = mem_tbView.getSelectionModel().getSelectedIndex();
			MemberVO mv = setMember();
			
			int cnt = service.updateMember(mv);
			mv = obMemList.set(choiceIndex, mv);
			
			if(cnt > 0 && mv != null) {
				infoMsg("작업 성공", "회원 수정 성공하였습니다.");
				mem_tbView.setItems(obMemList);
				btnFlag = true;
				setBtnDisivle();
				setTextEditable();
				textClear();
			} else {
				infoMsg("작업 오류", "회원 수정 실패하였습니다.");
				btnFlag = true;
				setBtnDisivle();
				setTextEditable();
				textClear();
			}
		});
	}
	

	@FXML public void del(ActionEvent event) {
		btnFlag = false;
		txtFlag = false;
		setTextEditable();
		setBtnDisivle();
		
		confirm_Btn.setOnAction(e -> {
			choiceIndex = mem_tbView.getSelectionModel().getSelectedIndex();
			
			int cnt = service.deleteMember(id_Txt.getText());
			
			if(choiceIndex > 0 && cnt > 0) {
				infoMsg("작업 성공", "회원 삭제 성공하였습니다.");
				obMemList.remove(choiceIndex);
				btnFlag = true;
				setBtnDisivle();
				textClear();
			} else {
				infoMsg("작업 실패", "회원 삭제 실패하였습니다.");
				btnFlag = true;
				setBtnDisivle();
				textClear();
			}
		});
	}

	// 취소 버튼을 눌렀을 때
	@FXML public void cancel(ActionEvent event) {
		btnFlag = true;
		txtFlag = false;
		
		setBtnDisivle();
		setTextEditable();
		textClear();
	}
	
	// 버튼 활성화 셋팅하는 메서드
	public void setBtnDisivle() {
		if(btnFlag) {	// 추가, 수정, 삭제 버튼이 클릭되었을 때
			add_Btn.setDisable(false);
			edit_Btn.setDisable(false);
			del_Btn.setDisable(false);
			confirm_Btn.setDisable(true);
			cancel_Btn.setDisable(true);
		} else {
			add_Btn.setDisable(true);
			edit_Btn.setDisable(true);
			del_Btn.setDisable(true);
			confirm_Btn.setDisable(false);
			cancel_Btn.setDisable(false);
		}
	}
	
	// MemberVO 객체 세팅하는 메서드
	public MemberVO setMember() {
		MemberVO mv = new MemberVO();
		
		mv.setMem_id(id_Txt.getText());
		mv.setMem_name(name_Txt.getText());
		mv.setMem_tel(tel_Txt.getText());
		mv.setMem_addr(addr_Txt.getText());
		
		return mv;
	}
	
	// 텍스트 클리어
	public void textClear() {
		id_Txt.clear();
		name_Txt.clear();
		tel_Txt.clear();
		addr_Txt.clear();
	}
	
	// 텍스트 수정 가능 여부
	public void setTextEditable() {	
		id_Txt.setEditable(txtFlag);
		name_Txt.setEditable(txtFlag);
		tel_Txt.setEditable(txtFlag);
		addr_Txt.setEditable(txtFlag);
	}
	
	// 각각의 텍스트가 비어있는지 판단하여 true, false반환하는 메서드
	public boolean isText() {
		if(id_Txt.getText().isEmpty()
				|| name_Txt.getText().isEmpty()
				|| tel_Txt.getText().isEmpty()
				|| addr_Txt.getText().isEmpty()) {
			return true;
		}
		return false;
	}
	
	// 에러메시지 alert 메서드
	public void errorMsg(String headerTxt, String msg) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("오류");
		errorAlert.setHeaderText(headerTxt);
		errorAlert.setContentText(msg);
		errorAlert.showAndWait();
	}

	// 정보메시지 alert 메서드
	public void infoMsg(String headerTxt, String msg) {
		Alert infoAlert = new Alert(AlertType.INFORMATION);
		infoAlert.setTitle("정보");
		infoAlert.setHeaderText(headerTxt);
		infoAlert.setContentText(msg);
		infoAlert.showAndWait();
	}
}
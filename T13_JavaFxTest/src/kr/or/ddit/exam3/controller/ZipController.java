package kr.or.ddit.exam3.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.exam3.service.IZipService;
import kr.or.ddit.exam3.service.ZipServiceImpl;
import kr.or.ddit.exam3.vo.ZipVO;

public class ZipController implements Initializable{

	@FXML ComboBox<String> zib_Combo;
	@FXML TextField search_Txt;
	@FXML Button search_Btn;
	@FXML TableView<ZipVO> zipTb;
	@FXML TableColumn<ZipVO, String> zipcode;
	@FXML TableColumn<ZipVO, String> sido;
	@FXML TableColumn<ZipVO, String> gugun;
	@FXML TableColumn<ZipVO, String> dong;
	
	
	private IZipService service;
	private ObservableList<String> obMenuList;
	private ObservableList<ZipVO> obZipList;
	private List<ZipVO> zipList;
	
	public ZipController() {
		service = ZipServiceImpl.getInstance();
		zipList = new ArrayList<>();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		obMenuList = FXCollections.observableArrayList(new String("우편번호"), new String("동이름"));
		
		zib_Combo.setItems(obMenuList);
		
		zib_Combo.setValue(obMenuList.get(0));
		
		search_Txt.requestFocus();
		
		zipcode.setCellValueFactory(new PropertyValueFactory<>("zipcode"));
		sido.setCellValueFactory(new PropertyValueFactory<>("sido"));
		gugun.setCellValueFactory(new PropertyValueFactory<>("gugun"));
		dong.setCellValueFactory(new PropertyValueFactory<>("dong"));
	}

	@FXML public void search(ActionEvent event) {
		
		if(search_Txt.getText().isEmpty()) {
			errorMsg("입력 오류", "빈 항목이 있습니다.");
			return;
		}
		
		if(zib_Combo.getValue().toString().equals("동이름")) {
			zipList = service.getDongZipList(search_Txt.getText());
		} else if(zib_Combo.getValue().toString().equals("우편번호")) {
			zipList = service.getZipCodeList(search_Txt.getText());
		}

		obZipList = FXCollections.observableArrayList(zipList);
		
		zipTb.setItems(obZipList);
	}
	
	// 에러메시지 alert 메서드
	public void errorMsg(String headerTxt, String msg) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("오류");
		errorAlert.setHeaderText(headerTxt);
		errorAlert.setContentText(msg);
		errorAlert.showAndWait();
	}
}
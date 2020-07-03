package kr.or.ddit.exam1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class Control_Controller implements Initializable {

	@FXML TextField name_txt;
	@FXML RadioButton male;
	@FXML RadioButton female;
	@FXML CheckBox travel;
	@FXML CheckBox hiking;
	@FXML CheckBox reading;
	@FXML CheckBox go;
	@FXML CheckBox janggi;
	@FXML CheckBox game;
	@FXML CheckBox tennis;
	@FXML CheckBox badminton;
	@FXML Button confirm_Btn;
	@FXML TextArea display_txt;

	String hobby = "";
	String gender = "";
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ToggleGroup tg = new ToggleGroup();
		
		male.setToggleGroup(tg);
		male.setUserData("남자");

		female.setToggleGroup(tg);
		female.setUserData("여자");
		
		male.setSelected(true);
		
		CheckBox[] chkBox = { travel , hiking, reading, go, janggi, game, tennis, badminton };
		
		
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				if(tg.getSelectedToggle() != null) {
					gender = tg.getSelectedToggle().getUserData().toString();
				}
			}
		});
		
		confirm_Btn.setOnAction(e -> {
			display_txt.setText("이름 : " + name_txt.getText() + "\r\n");
			display_txt.appendText("성별 : " + gender + "\r\n");
			display_txt.appendText("취미 : ");
			
			for (int i = 0; i < chkBox.length; i ++) {
				if(chkBox[i].isSelected()) {
					display_txt.appendText(chkBox[i].getText() + " ");
				}
			}	
			 
		});
	}
}
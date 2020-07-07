package kr.or.ddit.exam4.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ScoreInputController implements Initializable {

	@FXML TextField name_Txt;
	@FXML TextField kor_Txt;
	@FXML TextField math_Txt;
	@FXML TextField eng_Txt;
	
	@FXML Button store_Btn;
	@FXML Button cancel_Btn;
	
	/*public ScoreInputController() {
		scoreController = new ScoreController();
	}*/
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name_Txt.setPromptText("이름 입력");
		kor_Txt.setPromptText("국어 점수 입력");
		math_Txt.setPromptText("수학 점수 입력");
		eng_Txt.setPromptText("영어 점수 입력");
	}

	/*@FXML public void store(ActionEvent event) {
		ScoreVO sv = new ScoreVO(name_Txt.getText(), Integer.parseInt(kor_Txt.getText()), 
				Integer.parseInt(math_Txt.getText()), Integer.parseInt(eng_Txt.getText()));
		
		scoreController.scoreAdd(sv);
	}*/
	
	/*public ObservableList<ScoreVO> initScore() {
		obScoreList.addAll(new ScoreVO("이원우", 90, 20, 10),
						new ScoreVO("삼원우", 80, 30, 20),
						new ScoreVO("사원우", 70, 40, 30),
						new ScoreVO("오원우", 60, 50, 40));
		return obScoreList;
	}*/
}
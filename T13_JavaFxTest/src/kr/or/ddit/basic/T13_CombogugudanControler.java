package kr.or.ddit.basic;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

public class T13_CombogugudanControler implements Initializable {
	
	@FXML 
	private ComboBox<Integer> cmbDan;
	@FXML 
	private Button btnDan;
	@FXML 
	private TextArea txtResult;
	
	private ObservableList<Integer> list;
	
	// 객체 주입할 때 어노테이션을 붙인다.
	

	// 컨트롤러에서 초기화 해야하는 작업을 실행하는 메서드
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList( 1, 2, 3, 4, 5, 6, 7, 8, 9 );
		
		cmbDan.setItems(list);
/*		
		btnDan.setOnAction(e -> {
			int dan = cmbDan.getSelectionModel().getSelectedItem();
			
			txtResult.setText(dan + "단\n\n");
			for(int i = 1; i <= 9; i ++) {
				int r = dan * i;
				txtResult.appendText(dan + " * " + i + " = " + r + "\n");
			}
		});*/
	}

	@FXML public void onBtnClicked(ActionEvent event) {
		int dan = cmbDan.getSelectionModel().getSelectedItem();
		
		txtResult.setText(dan + "단\n\n");
		for(int i = 1; i <= 9; i ++) {
			int r = dan * i;
			txtResult.appendText(dan + " * " + i + " = " + r + "\n");
		}
	}
}
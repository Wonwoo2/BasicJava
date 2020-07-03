package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class T05_FxmlLayoutTest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// fxml 파일을 읽어와 현재 Stage에 적용하기
		
		// Parent 객체는 모든 컨테이너의 조상 객체
		// 방법1
		Parent root = FXMLLoader.load(getClass().getResource("JavaFxmlLayout.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Fxml을 이용한 레이아웃 연습");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
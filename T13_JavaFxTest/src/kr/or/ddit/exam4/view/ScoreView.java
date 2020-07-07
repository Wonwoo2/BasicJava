package kr.or.ddit.exam4.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kr.or.ddit.exam4.controller.ScoreController;
import kr.or.ddit.exam4.controller.ScoreInputController;

public class ScoreView extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("ScoreTableView.fxml"));
		
		Parent parent = (Parent) loader.load();
		
		Scene scene = new Scene(parent);
		
		primaryStage.setTitle("성적관리 프로그램");
		primaryStage.setScene(scene);
		
		ScoreController scController = loader.getController();
		scController.setStage(primaryStage);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
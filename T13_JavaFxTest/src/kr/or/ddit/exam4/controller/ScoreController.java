package kr.or.ddit.exam4.controller;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kr.or.ddit.exam4.vo.ScoreVO;
import javafx.scene.input.MouseEvent;

public class ScoreController implements Initializable{

	@FXML BorderPane scoreTbView;
	@FXML TableView<ScoreVO> scoreTable;
	
	@FXML TableColumn<ScoreVO, String>  name;
	@FXML TableColumn<ScoreVO, String>  kor;
	@FXML TableColumn<ScoreVO, String>  math;
	@FXML TableColumn<ScoreVO, String>  eng;
	
	@FXML Button add_Btn;
	@FXML Button stdBar_Btn;
	
	private Stage primaryStage;
	private ObservableList<ScoreVO> obScoreList = FXCollections.observableArrayList();
	
	public void setStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		obScoreList.addAll(new ScoreVO("이원우", 90, 80, 85), 
				new ScoreVO("삼원우", 80, 75, 85),
				new ScoreVO("사원우", 95, 85, 75));
		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		kor.setCellValueFactory(new PropertyValueFactory<>("kor"));
		math.setCellValueFactory(new PropertyValueFactory<>("math"));
		eng.setCellValueFactory(new PropertyValueFactory<>("eng"));
		
		scoreTable.setItems(obScoreList);
		
		
		
		
	
		// scoreTable.setItems(scInputController.initScore());
		/* obScoreList = FXCollections.observableArrayList(
				new ScoreVO("이원우", 90, 80, 85), 
				new ScoreVO("삼원우", 80, 75, 85),
				new ScoreVO("사원우", 95, 85, 75));
		

		System.out.println(obScoreList);
		scoreTable.setItems(obScoreList);*/

		// scoreTable.setItems(obScoreList);
		
		
/*		add_Btn.setOnAction(e -> {
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(getClass().getResource("view/ScoreInputView.fxml"));
			
			
			Stage scoreInputStage = new Stage(StageStyle.UTILITY);
			Parent parent = null;
			
			try {
				parent = (Parent) loader.load();
				scoreInputStage.initModality(Modality.APPLICATION_MODAL);
				System.out.println(parent);
				scoreInputStage.initOwner(primaryStage);
				
				Scene scene = new Scene(parent);
				
				scoreInputStage.setTitle("추가");
				scoreInputStage.setScene(scene);
				scoreInputStage.show();
			
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});*/
		
	}
	

	@FXML public void add(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/scoreInputView.fxml"));
		
		Parent root = loader.load();
		
		Stage scoreInputStage = new Stage(StageStyle.UTILITY);
		
		scoreInputStage.initModality(Modality.APPLICATION_MODAL);
		scoreInputStage.initOwner(primaryStage);
		
		Button storeBtn = (Button) root.lookup("#store_Btn");
		Button cancelBtn = (Button) root.lookup("#cancel_Btn");
		
		TextField nameTxt = (TextField) root.lookup("#name_Txt");
		TextField korTxt = (TextField) root.lookup("#kor_Txt");
		TextField mathTxt = (TextField) root.lookup("#math_Txt");
		TextField engTxt = (TextField) root.lookup("#eng_Txt");
		
		storeBtn.setOnAction(e -> {
			ScoreVO sv = new ScoreVO(nameTxt.getText(), Integer.parseInt(korTxt.getText()), 
					Integer.parseInt(mathTxt.getText()), Integer.parseInt(engTxt.getText()));
			
			scoreAdd(sv);
		});
		
		cancelBtn.setOnAction(e -> {
			scoreInputStage.close();
		});
		
		
		Scene scene = new Scene(root);
		scoreInputStage.setScene(scene);
		
		scoreInputStage.setTitle("추가");
		scoreInputStage.showAndWait();
	}
	
	@FXML public void pieGraph(MouseEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/scorePieChart.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		Stage pieGraphStage = new Stage(StageStyle.UTILITY);
		
		pieGraphStage.initModality(Modality.APPLICATION_MODAL);
		pieGraphStage.initOwner(primaryStage);
		
		PieChart pieChart = (PieChart) root.lookup("#score_PieChart");
		
		Button pieChartExit = (Button) root.lookup("#pieChart_Exit");

		ScoreVO sv = scoreTable.getSelectionModel().getSelectedItem();
		
		if(sv == null) {
			return;
		}
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("국어", sv.getKor()),
				new PieChart.Data("수학", sv.getMath()),
				new PieChart.Data("영어", sv.getMath())
		);

		pieChart.setTitle("파이 그래프");
		pieChart.setLabelLineLength(50);
		pieChart.setData(pieChartData);
		
		
		pieChartExit.setOnAction(e -> {
			pieGraphStage.close();
		});
		
		pieGraphStage.setScene(scene);
		pieGraphStage.setTitle("파이 그래프");
		pieGraphStage.showAndWait();
	}
	

	@FXML public void barChart_Btn(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/scoreBarChart.fxml"));
		
		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		
		Stage pieGraphStage = new Stage(StageStyle.UTILITY);
		
		pieGraphStage.initModality(Modality.APPLICATION_MODAL);
		pieGraphStage.initOwner(primaryStage);
		
		CategoryAxis xAxis = (CategoryAxis) root.lookup("#bar_xAxis");
		NumberAxis yAxis = (NumberAxis) root.lookup("#bar_yAxis");
		
		BarChart<String, Number> bc = (BarChart<String, Number>) root.lookup("#score_barChart");
		Button barChart_Exit_Btn = (Button) root.lookup("#barChart_Exit");

		bc.setTitle("막대 그래프");
		
		XYChart.Series<String, Number> ser1 = new XYChart.Series<>();
		ser1.setName("국어");
		
		XYChart.Series<String, Number> ser2 = new XYChart.Series<>();
		ser2.setName("영어");
		
		XYChart.Series<String, Number> ser3 = new XYChart.Series<>();
		ser3.setName("수학");

		for (ScoreVO sv : obScoreList) {
			ser1.getData().add(new XYChart.Data<String, Number>(sv.getName(), sv.getKor()));
		}
		
		for (ScoreVO sv : obScoreList) {
			ser2.getData().add(new XYChart.Data<String, Number>(sv.getName(), sv.getMath()));
		}
		
		for (ScoreVO sv : obScoreList) {
			ser3.getData().add(new XYChart.Data<String, Number>(sv.getName(), sv.getEng()));
		}
		
		bc.getData().addAll(ser1, ser2,ser3);
		
		barChart_Exit_Btn.setOnAction(e -> {
			pieGraphStage.close();
		});
				
		pieGraphStage.setTitle("막대 그래프");
		pieGraphStage.setScene(scene);
		pieGraphStage.showAndWait();		
	}
	
	public void scoreAdd(ScoreVO sv) {
		
		obScoreList.add(sv);
	}

	
	/*@FXML public void add(ActionEvent event) {
		
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("../view/ScoreInputView.fxml"));
		
		Stage addStage = new Stage(StageStyle.UTILITY);
		
		Parent parent = null;
		try {
			parent = (Parent) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		Button btnAdd = (Button) parent.lookup("#store_Btn");
		Button btnCancel = (Button) parent.lookup("#cancel_Btn");
		
		TextField nameTxt = (TextField) parent.lookup("#name_Txt");
		TextField korTxt = (TextField) parent.lookup("#kor_Txt");
		TextField mathTxt = (TextField) parent.lookup("#math_Txt");
		TextField engTxt = (TextField) parent.lookup("#eng_Txt");
		
		btnAdd.setOnAction(e -> {	
			if(nameTxt.getText().isEmpty() || 
					korTxt.getText().isEmpty() ||
					mathTxt.getText().isEmpty() || 
					engTxt.getText().isEmpty() ) {
				errorMsg("입력 오류", "빈 항목이 있습니다.");
				return;
			}
			
			obScoreList.add(new ScoreVO(nameTxt.getText(), Integer.parseInt(korTxt.getText()), 
								Integer.parseInt(mathTxt.getText()), Integer.parseInt(engTxt.getText())));
			
			name.setCellValueFactory(new PropertyValueFactory<>("name"));
			kor.setCellValueFactory(new PropertyValueFactory<>("kor"));
			math.setCellValueFactory(new PropertyValueFactory<>("math"));
			eng.setCellValueFactory(new PropertyValueFactory<>("eng"));
			
			scoreTable.setItems(obScoreList);
		});
		
		btnCancel.setOnAction(e -> {
			addStage.close();
		});
		
		Scene scene = new Scene(parent);
		
		addStage.initModality(Modality.APPLICATION_MODAL);
		
		addStage.initOwner(primaryStage);
		
		addStage.setTitle("추가");
		addStage.setScene(scene);
		
		addStage.show();
	}
	*/
	// 에러 메시지
	public void errorMsg(String headerTxt, String msg) {
		Alert errorAlert = new Alert(AlertType.ERROR);
		errorAlert.setTitle("오류");
		errorAlert.setHeaderText(headerTxt);
		errorAlert.setContentText(msg);
		errorAlert.showAndWait();
	}
}
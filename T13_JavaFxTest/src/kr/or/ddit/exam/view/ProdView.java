package kr.or.ddit.exam.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProdView extends Application {
/*	private ILProdService lprodService;
	private IProdService prodService;
	
	public ProdMain() {
		lprodService = LProdServiceImpl.getInstance();
		prodService = ProdServiceImpl.getInstance();
	}
	*/
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*BorderPane root = new BorderPane();
		
		List<LProdVO> lprod = lprodService.getLProdList();
		
		HBox hbox = new HBox(30);
		
		ComboBox<LProdVO> combo1 = new ComboBox<>();
		ComboBox<ProdVO> combo2 = new ComboBox<>();
		TextArea result = new TextArea();
		
		ObservableList<LProdVO> lprodList = FXCollections.observableArrayList(lprod);
		
		combo1.setItems(lprodList);
		combo1.setValue(lprodList.get(0));
		
		combo1.setCellFactory(new Callback<ListView<LProdVO>, ListCell<LProdVO>>() {
			@Override
			public ListCell<LProdVO> call(ListView<LProdVO> param) {
				return new ListCell<LProdVO>() {
					protected void updateItem(LProdVO lprodItem, boolean empty) {
						super.updateItem(lprodItem, empty);

					if(lprodItem == null || empty) {
							setText(null);
						} else {
							setText(lprodItem.getLprod_nm());
						}
					}
				};
			}
		});
		
		combo1.setButtonCell(new ListCell<LProdVO>() {
			protected void updateItem(LProdVO lprodItem, boolean empty) {
				super.updateItem(lprodItem, empty);
				
				if(empty) {
					setText(null);
				} else {
					setText(lprodItem.getLprod_nm());
				}
			}
		});
		
		combo1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				String data = combo1.getValue().getLprod_Gu();
				List<ProdVO> prodL = prodService.getIsProductList(data);
				ObservableList<ProdVO> prodList = FXCollections.observableArrayList(prodL);
				
				combo2.setItems(prodList);
				combo2.setValue(prodList.get(0));
			}
		});
		
		combo2.setCellFactory(new Callback<ListView<ProdVO>, ListCell<ProdVO>>() {
			@Override
			public ListCell<ProdVO> call(ListView<ProdVO> param) {
				return new ListCell<ProdVO>() {
					protected void updateItem(ProdVO prodItem, boolean empty) {
						super.updateItem(prodItem, empty);

					if(prodItem == null || empty) {
							setText(null);
						} else {
							setText(prodItem.getProd_Name());
						}
					}
				};
			}
		});
		
		combo2.setButtonCell(new ListCell<ProdVO>() {
			protected void updateItem(ProdVO prodItem, boolean empty) {
				super.updateItem(prodItem, empty);
				
				if(empty) {
					setText(null);
				} else {
					setText(prodItem.getProd_Name());
				}
			}
		});


		combo2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ProdVO data = combo2.getValue();
				
				result.setText(data.getProd_Id() + "\n");
				result.appendText(data.getProd_Lgu() + "\n");
				result.appendText(data.getProd_Name() + "\n");
				result.appendText(data.getProd_Buyer() + "\n");
				result.appendText(data.getProd_Cost() + "\n");
				result.appendText(data.getProd_Price() + "\n");
				result.appendText(data.getProd_Sale() + "\n");
			}
		});
		
		hbox.getChildren().addAll(combo1, combo2);
		hbox.setPadding(new Insets(10));
		
		root.setTop(hbox);
		root.setCenter(result);*/
		
		Parent root = FXMLLoader.load(getClass().getResource("TableView.fxml"));
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("상품관리 프로그램");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
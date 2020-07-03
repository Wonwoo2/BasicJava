package kr.or.ddit.basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class T20_MenuTest extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		root.setTop(menuBar);
		
		// File menu 만들어 보기 => new, save, exit
		Menu fileMenu = new Menu("file");	// 주메뉴
		
		MenuItem newMenuItem = new MenuItem("New");	// 부메뉴
		MenuItem saveMenuItem = new MenuItem("Save");	// 부메뉴
		MenuItem exitMenuItem = new MenuItem("Exit");	// 부메뉴
		
		// 메뉴에 이벤트 설정
		exitMenuItem.setOnAction(e -> {
			// 해당 메뉴를 클릭했을 때 처리할 내용 기술
			Platform.exit();
		});
		
		// 주메뉴에 부메뉴를 추가
		fileMenu.getItems().addAll(newMenuItem, saveMenuItem, exitMenuItem);
		
		// ------------------------------------------------------------------
		Menu webMenu = new Menu("web");
		
		CheckMenuItem htmlMenuItem = new CheckMenuItem("HTML");
		htmlMenuItem.setSelected(false);
		
		CheckMenuItem cssMenuItem = new CheckMenuItem("CSS");
		cssMenuItem.setSelected(true);
		
		webMenu.getItems().addAll(htmlMenuItem, cssMenuItem);
		
		// ------------------------------------------------------------------
		
		Menu sqlMenu = new Menu("SQL");
		ToggleGroup tg = new ToggleGroup();
		
		RadioMenuItem mysqlItem = new RadioMenuItem("MySQL");
		mysqlItem.setToggleGroup(tg);
		
		RadioMenuItem oracleItem = new RadioMenuItem("Oracle");
		oracleItem.setToggleGroup(tg);
		
		RadioMenuItem mssqlItem = new RadioMenuItem("Ms-SQL");
		mssqlItem.setToggleGroup(tg);
		
		sqlMenu.getItems().addAll(mysqlItem, oracleItem, mssqlItem);
		
		// 부메뉴의 부메뉴 구성하기
		Menu tutorialMenu = new Menu("Tutorial");
		tutorialMenu.getItems().addAll(
				new CheckMenuItem("Java"),
				new CheckMenuItem("JavaFx"),
				new CheckMenuItem("Java Swing")
		);
		
		sqlMenu.getItems().addAll(new SeparatorMenuItem(), tutorialMenu);
		
		// 주메뉴들을 MenuBar에 추가
		menuBar.getMenus().addAll(fileMenu, webMenu, sqlMenu);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("메뉴 연습");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
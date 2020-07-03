package kr.or.ddit.exam.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import kr.or.ddit.exam.service.ILProdService;
import kr.or.ddit.exam.service.IProdService;
import kr.or.ddit.exam.service.LProdServiceImpl;
import kr.or.ddit.exam.service.ProdServiceImpl;
import kr.or.ddit.exam.vo.LProdVO;
import kr.or.ddit.exam.vo.ProdVO;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;

public class ProdController implements Initializable {
	private ILProdService lprodService;
	private IProdService prodService;
	
	private List<LProdVO> lprodList;
	private List<ProdVO> prodList;
	private ObservableList<LProdVO> obLProdList;
	private ObservableList<ProdVO> obProdList;
	
	@FXML BorderPane mainBorder;
	@FXML HBox h_box;
	@FXML ComboBox<LProdVO> lprod_Combo;
	@FXML ComboBox<ProdVO> prod_Combo;
	@FXML TableView<ProdVO> prod_tbView;
	@FXML TableColumn<ProdVO, String> prod_id;
	@FXML TableColumn<ProdVO, String> prod_name;
	@FXML TableColumn<ProdVO, String> prod_lgu;
	@FXML TableColumn<ProdVO, String> prod_buyer;
	@FXML TableColumn<ProdVO, String> prod_cost;
	@FXML TableColumn<ProdVO, String> prod_price;
	@FXML TableColumn<ProdVO, String> prod_sale;
	@FXML TableColumn<ProdVO, String> prod_detail;
	
	
	
	public ProdController() {
		lprodService = LProdServiceImpl.getInstance();
		prodService = ProdServiceImpl.getInstance();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lprodList = lprodService.getLProdList();
		
		obLProdList = FXCollections.observableArrayList(lprodList);
		
		lprod_Combo.setItems(obLProdList);
		lprod_Combo.setValue(obLProdList.get(0));
		
		lprod_Combo.setCellFactory(new Callback<ListView<LProdVO>, ListCell<LProdVO>>() {
			@Override
			public ListCell<LProdVO> call(ListView<LProdVO> param) {
				return new ListCell<LProdVO>() {
					protected void updateItem(LProdVO item, boolean empty) {
						super.updateItem(item, empty);
						
						if(item == null || empty) {
							setText(null);
						} else {
							setText(item.getLprod_nm());
						}
					}
				};
			}
		});	
		
		lprod_Combo.setButtonCell(new ListCell<LProdVO>() {
			protected void updateItem(LProdVO item, boolean empty) {
				super.updateItem(item, empty);
				
				if(item == null || empty) {
					setText(null);
				} else {
					setText(item.getLprod_nm());
				}
			}
		});
	}

	@FXML public void lprod_clicked(ActionEvent event) {
		LProdVO lprodVo = lprod_Combo.getSelectionModel().getSelectedItem();
		
		if(lprodVo == null) {
			return;
		}
		
		prodList = prodService.getIsProductList(lprodVo.getLprod_Gu());
		
		obProdList = FXCollections.observableArrayList(prodList);
		
		prod_Combo.setItems(obProdList);
		
		prod_Combo.setCellFactory(new Callback<ListView<ProdVO>, ListCell<ProdVO>>() {
			@Override
			public ListCell<ProdVO> call(ListView<ProdVO> param) {
				return new ListCell<ProdVO>() {
					protected void updateItem(ProdVO item, boolean empty) {
						super.updateItem(item, empty);
						
						if(item == null || empty) {
							setText(null);
						} else {
							setText(item.getProd_name());
						}
					}
				};
			}
		});	
		
		prod_Combo.setButtonCell(new ListCell<ProdVO>() {
			protected void updateItem(ProdVO item, boolean empty) {
				super.updateItem(item, empty);
				
				if(item == null || empty) {
					setText(null);
				} else {
					setText(item.getProd_name());
				}
			}
		});
		
		prod_Combo.setValue(obProdList.get(0));
	}

	@FXML public void prod_clicked(ActionEvent event) {
		ProdVO prodVo = prod_Combo.getSelectionModel().getSelectedItem();
		
		if(prodVo == null) {
			return;
		}
		
		prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
		prod_name.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
		prod_lgu.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
		prod_buyer.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
		prod_cost.setCellValueFactory(new PropertyValueFactory<>("prod_cost"));
		prod_price.setCellValueFactory(new PropertyValueFactory<>("prod_price"));
		prod_sale.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
		prod_detail.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
		
		obProdList = FXCollections.observableArrayList(prodVo);
		
		prod_tbView.setItems(obProdList);
	}
}
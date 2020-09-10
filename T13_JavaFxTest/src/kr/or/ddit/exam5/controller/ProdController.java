package kr.or.ddit.exam5.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import kr.or.ddit.exam5.service.ILProdService;
import kr.or.ddit.exam5.service.IProdService;
import kr.or.ddit.exam5.service.LProdServiceImpl;
import kr.or.ddit.exam5.service.ProdServiceImpl;
import kr.or.ddit.exam5.vo.LProd;
import kr.or.ddit.exam5.vo.Prod;

public class ProdController implements Initializable{

	@FXML HBox h_box;
	@FXML ComboBox<LProd> lprod_Combo;
	@FXML ComboBox<Prod> prod_Combo;
	@FXML TableView<Prod> prod_Table;
	@FXML TableColumn<Prod, String> prod_id;
	@FXML TableColumn<Prod, String> prod_name;
	@FXML TableColumn<Prod, String> prod_lgu;
	@FXML TableColumn<Prod, String> prod_buyer;
	@FXML TableColumn<Prod, Integer> prod_cost;
	@FXML TableColumn<Prod, Integer> prod_sale;
	@FXML TableColumn<Prod, String> prod_detail;
	@FXML TableColumn<Prod, String> prod_outline;
	@FXML Pagination prodPage;
	
	private ILProdService lprodService;
	private IProdService prodService;
	private ObservableList<Prod> obProdList;
	private ObservableList<LProd> obLProdList;
	
	private List<LProd> lprodList;
	private List<Prod> prodList;
	
	private int from, to, countForPage;
	
	private ObservableList<Prod> currentPage;
 	
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
		
		lprod_Combo.setCellFactory(new Callback<ListView<LProd>, ListCell<LProd>>() {
			@Override
			public ListCell<LProd> call(ListView<LProd> param) {
				return new ListCell<LProd> () {
					protected void updateItem(LProd item, boolean empty) {
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
		
		lprod_Combo.setButtonCell(new ListCell<LProd>() {
			protected void updateItem(LProd item, boolean empty) {
				super.updateItem(item, empty);
				
				if(item == null || empty) {
					setText(null);
				} else {
					setText(item.getLprod_nm());
				}
			}
		});
		
		prodList = prodService.getProdList();
		obProdList = FXCollections.observableArrayList(prodList);
		
		prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
		prod_name.setCellValueFactory(new PropertyValueFactory<>("prod_name"));
		prod_lgu.setCellValueFactory(new PropertyValueFactory<>("prod_lgu"));
		prod_buyer.setCellValueFactory(new PropertyValueFactory<>("prod_buyer"));
		prod_cost.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
		prod_sale.setCellValueFactory(new PropertyValueFactory<>("prod_sale"));
		prod_detail.setCellValueFactory(new PropertyValueFactory<>("prod_detail"));
		prod_outline.setCellValueFactory(new PropertyValueFactory<>("prod_outline"));

		setPage("");
	}

	@FXML public void lprod_clicked(ActionEvent event) {
		LProd lv = lprod_Combo.getSelectionModel().getSelectedItem();
		
		if(lv == null) {
			return;
		}
		
		prodList = prodService.getIsProductList(lv.getLprod_Gu());
		
		setPage(lv.getLprod_Gu());
		
		prod_Combo.setItems(obProdList);
		prod_Combo.setValue(obProdList.get(0));
		
		prod_Combo.setCellFactory(new Callback<ListView<Prod>, ListCell<Prod>>() {
			@Override
			public ListCell<Prod> call(ListView<Prod> param) {
				return new ListCell<Prod>() {
					protected void updateItem(Prod item, boolean empty) {
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
		
		prod_Combo.setButtonCell(new ListCell<Prod>() {
			protected void updateItem(Prod item, boolean empty) {
				super.updateItem(item, empty);
				
				if(item == null || empty) {
					setText(null);
				} else {
					setText(item.getProd_name());
				}
			}
		});
	}

	@FXML public void prod_clicked(ActionEvent event) {
		
	}
	
	
	public void setPage(String prod_lgu) {
		if(prodList.size() < 1) {
			return;
		}
		
		obProdList = FXCollections.observableArrayList(prodList);
		
		int total = obProdList.size();
		countForPage = 5;
		
		int totalPage = ((total - 1) / countForPage) + 1;		// 전체 페이지 수
		
		prodPage.setPageCount(totalPage);
		
		prodPage.setPageFactory(new Callback<Integer, Node>() {
			@Override
			public Node call(Integer pageIndex) {
				from = pageIndex * countForPage + 1;
				to = from + countForPage - 1;
				
				Map<String, String> pageMap = new HashMap<>();
				
				if(!prod_lgu.equals("")) {
					pageMap.put("lgu", prodList.get(0).getProd_lgu());
				}
				pageMap.put("from", from + "");
				pageMap.put("to", to + "");
				
				prodList = prodService.getCurrentPageList(pageMap);
				currentPage = FXCollections.observableArrayList(prodList);
				
				prod_Table.setItems(currentPage);
				return prod_Table;
			}
		});
	}
}
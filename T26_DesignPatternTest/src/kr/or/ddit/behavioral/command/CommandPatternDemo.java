package kr.or.ddit.behavioral.command;

public class CommandPatternDemo {

	public static void main(String[] args) {
		
		Stock abcStock = new Stock();
		
		BuyStock buyStock = new BuyStock(abcStock);
		SellStock sellStock = new SellStock(abcStock);
		
		Broker broker = new Broker();
		//주문 등록
		broker.takeOrder(buyStock);
		broker.takeOrder(sellStock);
		//주문 처리
		broker.placeOrder();
		
		
	}
	
}

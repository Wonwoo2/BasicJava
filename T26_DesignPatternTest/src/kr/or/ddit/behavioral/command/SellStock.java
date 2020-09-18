package kr.or.ddit.behavioral.command;

public class SellStock implements Order{

	private Stock abcStock;
	
	public SellStock(Stock abStock) {
		this.abcStock = abStock;
	}
	
	@Override
	public void execute() {
		abcStock.sell();
	}
	
	
}

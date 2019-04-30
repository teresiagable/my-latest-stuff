package gable.bookstore.entity;

public enum StockStatus {

	OK(0),
	NOT_IN_STOCK(1),
	DOES_NOT_EXIST(2);
	
	int responseCode;

	private StockStatus(int responseCode) {
		this.responseCode = responseCode;
	}
	
}

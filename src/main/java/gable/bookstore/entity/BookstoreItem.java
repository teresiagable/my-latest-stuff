package gable.bookstore.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class BookstoreItem  {

	private Book book;
	private int quantity;

	public BookstoreItem(String bookLine)  {

		String[] bookData = bookLine.split(";", 4);

		BigDecimal price;
		try {
			price = StringToBigDecimal(bookData[2]);

		
		this.book = new Book(bookData[0],bookData[1],price);
		this.quantity =Integer.parseInt(bookData[3]);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private BigDecimal StringToBigDecimal(String decimalString) throws ParseException {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		return (BigDecimal) decimalFormat.parse(decimalString);
	}

	public BookstoreItem(Book theBook, int quantity) {
		this.book = theBook;
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setTheBook(Book theBook) {
		this.book = theBook;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return this.book.getAuthor();
	}
	
	public String getTitle() {
		return this.book.getTitle();
	}
	
	public BigDecimal getPrice() {
		return this.book.getPrice();
	}
	

	//public boolean updateQuatity(Book book, )


	public void addQuantity(int quantity2) {
		this.quantity += quantity2;
	}
//	public StockStatus isInStock()
//	{
//		if(this.quantity>=1)
//		{
//			
//		}
//	}

	@Override
	public String toString() {
		return book + ", Quantity=" + quantity;
	}

	
}

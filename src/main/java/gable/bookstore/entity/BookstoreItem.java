package gable.bookstore.entity;

public class BookstoreItem  {

	private Book book;
	private int quantity;

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

	public boolean updateQuatity(Book book, )


	public void addQuantity(int quantity2) {
		this.quantity += quantity2;
	}

}

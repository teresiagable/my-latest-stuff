package gable.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import gable.bookstore.entity.BookstoreItem;

public class ShoppingCart {
	List<BookstoreItem> shoppingCart = new ArrayList<BookstoreItem>();
	
	private boolean emptyCart() {
		return false;
	}
	public boolean addBookToCart(BookstoreItem bookItem ) {
		return false;
	}
	public boolean removeFromCart(BookstoreItem bookItem) {
		return false;
	}
	public boolean checkOut() {
		return false;
	}
	
	
}

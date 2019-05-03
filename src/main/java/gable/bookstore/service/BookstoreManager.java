package gable.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import gable.bookstore.entity.Book;
import gable.bookstore.entity.BookstoreItem;

public class BookInventory implements BookList {

	public List<BookstoreItem> allTheBooks = new ArrayList<BookstoreItem>();

	public Book[] list(String searchString) {

		Stream<BookstoreItem> foundBooks = allTheBooks.stream().filter(b -> b.getAuthor().contains(searchString));

		return (Book[]) foundBooks.toArray();
	}

	
	public boolean add(Book book, int quantity) {
		boolean bookExists = false;
//		for (BookstoreItem bookstoreItem : allTheBooks) {
//
//			if (bookstoreItem.getBook().equals(book)) return false;
//			
//		}
		bookExists = allTheBooks.stream().anyMatch(b -> b.getBook().equals(book));
		if (!bookExists)
			return allTheBooks.add(new BookstoreItem(book, quantity));
		else return false;

	}

	public int[] buy(Book... books) {
		int[] bookStatus = new int[books.length];
		for (Book book : books) {
			
		}
		// TODO Auto-generated method stub
		return null;
	}


	public void add(List<BookstoreItem> theBookList) {
		this.allTheBooks.addAll(theBookList);
		
	}



}

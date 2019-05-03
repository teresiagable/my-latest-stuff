package gable.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import gable.bookstore.entity.Book;
import gable.bookstore.entity.BookstoreItem;
import gable.helper.HelpMe;


public class BookstoreManager implements BookList {

	public List<BookstoreItem> allTheBooks = new ArrayList<BookstoreItem>();
	public List<BookstoreItem> shoppingCart = new ArrayList<BookstoreItem>();

	public BookstoreManager(List<BookstoreItem> incomingBookList) {
		this.allTheBooks = incomingBookList;
	}

	public Book[] list(String searchString) {

		Predicate<BookstoreItem> authors =   b -> b.getAuthor().contains(searchString);
		Predicate<BookstoreItem> titles =   b -> b.getTitle().contains(searchString);
		
		List<BookstoreItem> foundBooks = allTheBooks.stream().filter(authors.or(titles)).collect(Collectors.toList());
//		List<BookstoreItem> foundAuthors = allTheBooks.stream().filter(b -> b.getAuthor().contains(searchString)).collect(Collectors.toList());
//		List<BookstoreItem> foundTitles = allTheBooks.stream().filter(b-> b.getTitle().contains(searchString)).collect(Collectors.toList());
//		foundAuthors.addAll(foundTitles);
//		List<BookstoreItem> allFound = foundAuthors.stream().distinct().collect(Collectors.toList());
		return (Book[]) foundBooks.toArray();
	}
	
	public void printAllBooks() {
		System.out.println(allTheBooks);
	}

	public boolean add(Book book, int quantity) {
		boolean bookExists = false;

		bookExists = allTheBooks.stream().anyMatch(b -> b.getBook().equals(book));
		if (!bookExists)
			return allTheBooks.add(new BookstoreItem(book, quantity));
		else
			return false;
	}



//	public void fillBookStore(List<BookstoreItem> theBookList) {
//		this.allTheBooks.addAll(theBookList);
//
//	}

	public void cashOut() {
		System.out.println("Proceed to checkout?");
		boolean doCheckOut = HelpMe.readYesNoFromUser();
		if(doCheckOut) {
			System.out.println("Books in shopping cart");
			System.out.println(shoppingCart);
			//if(StockStatusOk(shoppingCart)) {}
			
			
			
		}

		
	}
///
	
	/**
	 * @return true if all books are in stock
	 */
	private boolean StockStatusOK() {
		//shoppingCart.stream().forEach(b->b.);.allMatch(b->b.)
		return false;
	}

	public int[] buy(Book... books) {
		int[] bookStatus = new int[books.length];
		for (Book book : books) {

		}
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public void leave() {
		System.out.println("You are leaving The Bookstore");
		System.exit(0);		
	}

}

package gable.bookstore.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import gable.bookstore.entity.Book;
import gable.bookstore.entity.BookstoreItem;
import gable.bookstore.entity.StockStatus;
import gable.helper.HelpMe;

public class BookstoreManager implements BookList {

	private List<BookstoreItem> allTheBooks = new ArrayList<BookstoreItem>();
	public List<Book> shoppingCart = new ArrayList<Book>();

	public BookstoreManager(List<BookstoreItem> incomingBookList) {
		this.allTheBooks = incomingBookList;
	}

	public Book[] list(String searchString) {

		Predicate<BookstoreItem> authors = b -> b.getAuthor().toLowerCase().contains(searchString.toLowerCase());
		Predicate<BookstoreItem> titles = b -> b.getTitle().toLowerCase().contains(searchString.toLowerCase());

		List<BookstoreItem> foundBooks = allTheBooks.stream().filter(authors.or(titles)).collect(Collectors.toList());
		Book[] theList = new Book[foundBooks.size()];
		int i = 0;
		for (BookstoreItem bookstoreItem : foundBooks) {
			theList[i] = bookstoreItem.getBook();
			i++;
		}

		return theList;
	}

	public void printAllBooks() {
		allTheBooks.forEach(System.out::println);
	}

	public boolean add(Book book, int quantity) {
		boolean bookExists = false;

		bookExists = allTheBooks.stream().anyMatch(b -> b.getBook().equals(book));
		if (!bookExists)
			return allTheBooks.add(new BookstoreItem(book, quantity));
		else
			return false;
	}

	public void cashOut() {
		BigDecimal totalSum = new BigDecimal(0);
		System.out.println("Proceed to checkout?");
		boolean doCheckOut = HelpMe.readYesNoFromUser();
		if (doCheckOut) {
			System.out.println("Books in shopping cart:");
			shoppingCart.forEach(System.out::println);

			Book[] cart = shoppingCart.toArray(new Book[shoppingCart.size()]);

			int[] statusList = this.buy(cart);
			for (int i = 0; i < statusList.length; i++) {

				if (statusList[i] == StockStatus.OK.getResponseCode())
					totalSum = totalSum.add(shoppingCart.get(i).getPrice());
				else
					System.out.println("\n"+ shoppingCart.get(i) + " is not in stock or not for sale.");
			}

			System.out.println("The total amount to pay is " + totalSum);
			System.out.println("Your order have been shipped");
			shoppingCart.clear();

		}

	}

	public int[] buy(Book... books) {
		int[] bookStatus = new int[books.length];

		int i = 0;
		for (Book book : books) {
			int noInStock = getQuantity(book);

			if (noInStock >= 1) {
				removeBoughtBook(book, -1);
				bookStatus[i] = StockStatus.OK.getResponseCode();
			} else if (noInStock == Integer.MIN_VALUE)
				bookStatus[i] = StockStatus.DOES_NOT_EXIST.getResponseCode();
			else
				bookStatus[i] = StockStatus.NOT_IN_STOCK.getResponseCode();
			i++;
		}
		return bookStatus;

	}

	private boolean removeBoughtBook(Book book, int number) {

		
		for (BookstoreItem bookItem : allTheBooks) {
			if(bookItem.getBook().equals(book)) 
				bookItem.updateQuantity(number);
				return true;
		}
		return false;
		
		//Optional<BookstoreItem> bookItem = allTheBooks.stream().findFirst().filter(b -> b.getBook().equals(book));

//		if (bookItem.isPresent())
//			return bookItem.get().updateQuantity(-1);
//		else
//			return false;
		
		
	}

	private int getQuantity(Book book) {
		int do_not_exist = Integer.MIN_VALUE;

		for (BookstoreItem bookItem : allTheBooks) {
			if(bookItem.getBook().equals(book)) return bookItem.getQuantity();
		}
		
		return do_not_exist;
	}

	public void leave() {
		System.out.println("You are leaving The Bookstore");
		System.exit(0);
	}

	public void search(String stringFromUser) {

		for (Book book : this.list(stringFromUser.trim())) {
			System.out.println(book);
		}
	}

	public void addToCart() {
		int i = 1;
		for (BookstoreItem bookstoreItem : allTheBooks) {
			System.out.println(i + ". " + bookstoreItem.getBook());
			i++;
		}
		int bookNo = HelpMe.readIntegerfromUser("Enter number of the book you want to buy", 1, i-1);

		Book book = allTheBooks.get(bookNo - 1).getBook();
		shoppingCart.add(book);

		System.out.println(book + " added to shopping cart");

	}
}

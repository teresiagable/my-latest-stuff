package gable.bookstore.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gable.bookstore.entity.Book;
import gable.bookstore.entity.BookstoreItem;

public class BookstoreManagerTest {
	
	BookstoreManager theStore;
	List<BookstoreItem> bookList;
	Book bookToAdd1;
	Book bookToAdd2;
	Book bookToAdd3;
	Book bookToAdd4;
	Book[] booksToBuy;

	String bigDecimalString;
	BigDecimal aBigDecimal;

	String searchTitle;
	String searchAuthor;
	String searchHitInBoth;

	@Before
	public void init() {
		bookToAdd1 = new Book("The Title1", "The Author1", BigDecimal.valueOf(1234.5));
		bookToAdd2 = new Book("The HITTitle", "The Author", BigDecimal.valueOf(10.5));
		bookToAdd3 = new Book("The Title3", "The hitAuthor3", BigDecimal.valueOf(100));
		bookToAdd4 = new Book("The Title4", "The Author4", BigDecimal.valueOf(100));

		booksToBuy = new Book[] { bookToAdd1, bookToAdd2, bookToAdd3 };
		
		bookList = Arrays.asList(new BookstoreItem[] { 
									new BookstoreItem(bookToAdd1, 1),
									new BookstoreItem(bookToAdd2, 0),
									new BookstoreItem(bookToAdd3, 0)});
		
		theStore = new BookstoreManager(bookList);
		
		bigDecimalString = "12,333,444,55";
		aBigDecimal = BigDecimal.valueOf(12333444.55);

		searchTitle = "TITle1";
		searchAuthor = "auTHOr3";
		searchHitInBoth = "hiT";

	}

	@Test
	public void test_booklist_add() {
		Book bookToAdd = bookToAdd4;
		theStore.add(bookToAdd4, 10);
		
		assertEquals(bookToAdd4, theStore.list(bookToAdd.getTitle())[0]);

	}
	
	@Test
	public void test_booklist_list() {
		
		assertEquals(bookToAdd1, theStore.list(searchTitle)[0]);
		assertEquals(bookToAdd3, theStore.list(searchAuthor)[0]);
		
		Book[] toFind = new Book[] {bookToAdd2, bookToAdd3};
		assertArrayEquals(toFind, theStore.list(searchHitInBoth));
		

	}
	
	
}

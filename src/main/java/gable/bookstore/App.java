package gable.bookstore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gable.bookstore.entity.Book;
import gable.bookstore.entity.BookstoreItem;
import gable.bookstore.service.BookstoreManager;
import gable.helper.HelpMe;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App {
	//public static List<BookstoreItem> theBookList = new ArrayList<BookstoreItem>();
	//public static BookInventory theBookStore = new BookInventory();

	public static void main(String[] args) {
		
		BookstoreManager theBookStore = new BookstoreManager(addBooksFromTxtFile());

		System.out.println("Welcome to the Bookstore.");

		while (true) {

			int menuChoice = printAndGetMenuChoice();

			switch (menuChoice) {
			case 1:
				theBookStore.printAllBooks();
				break;
			case 2:
				theBookStore.search(HelpMe.readStringFromUser("Enter search value:"));
				break;
			case 3:
				theBookStore.addToCart();
				break;
//			case 4:
//				theBookStore.addBookToInventory();
//				break;
			case 5:
				theBookStore.cashOut();
				break;
			case 6:
				theBookStore.leave();
				break;
			default:
				break;
			}
		}

	}

	private static int printAndGetMenuChoice() {

		System.out.println("------------------");
		System.out.println("1. View all books");
		System.out.println("2. Search for a book");
		System.out.println("3. Purchase");
		System.out.println("4. Add a book to the store");
		System.out.println("5. Cash out");
		System.out.println("6. Leave");

		return HelpMe.readIntegerfromUser("Enter a number: ", 1, 6);
	}

	private static List<BookstoreItem> addBooksFromTxtFile() {

		List<BookstoreItem> theBookList = new ArrayList<BookstoreItem>();
		try {
			URL urlBookStore = new URL(
					"https://raw.githubusercontent.com/contribe/contribe/dev/bookstoredata/bookstoredata.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlBookStore.openStream()));

			String bookLine;
			boolean isAdded;

			while ((bookLine = reader.readLine()) != null) {

				BookstoreItem b = new BookstoreItem(bookLine);
				//System.out.println(b.getAuthor() + " " + b.getPrice() + " " + b.getQuantity());
				// System.out.println(b.getQuantity());
				theBookList.add(b);
			}
			reader.close();

		} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theBookList;
	}
}

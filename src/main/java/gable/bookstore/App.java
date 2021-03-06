package gable.bookstore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import gable.bookstore.entity.BookstoreItem;
import gable.bookstore.service.BookstoreManager;
import gable.helper.HelpMe;

import java.io.*;


public class App {

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
			case 4:
				theBookStore.removeFromCart();
				break;
			case 5:
				theBookStore.viewCart();
				break;
			case 6:
				theBookStore.addBookToInventory();
				break;
			case 7:
				theBookStore.cashOut();
				break;
			case 8:
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
		System.out.println("3. Add to shopping cart");
		System.out.println("4. Remove from shopping cart");
		System.out.println("5. View shopping cart");
		System.out.println("6. Add a book to the store");
		System.out.println("7. Cash out");
		System.out.println("8. Leave");

		return HelpMe.readIntegerfromUser("Enter a number: ", 1, 8);
	}

	private static List<BookstoreItem> addBooksFromTxtFile() {

		List<BookstoreItem> theBookList = new ArrayList<BookstoreItem>();
		try {
			URL urlBookStore = new URL(
					"https://raw.githubusercontent.com/contribe/contribe/dev/bookstoredata/bookstoredata.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlBookStore.openStream()));

			String bookLine;
			while ((bookLine = reader.readLine()) != null) {

				BookstoreItem b = new BookstoreItem(bookLine);
				theBookList.add(b);
			}
			reader.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theBookList;
	}
}

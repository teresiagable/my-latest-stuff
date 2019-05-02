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
import gable.bookstore.service.BookInventory;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App {
	//public static List<BookstoreItem> theBookList = new ArrayList<BookstoreItem>();
	//public static BookInventory theBookStore = new BookInventory();

	public static void main(String[] args) {
		
		BookInventory theBookStore = new BookInventory();


		// VendingMachineManager theManager = new
		// VendingMachineManager(getCurrentProducts());

		System.out.println("Welcome to the Bookstore.");

		addBooksFromTxtFile();

		while (true) {

			int menuChoice = printAndGetMenuChoice();

			switch (menuChoice) {
			case 1:
				theBookStore.listBooks();
				break;
			case 2:
				theBookStore.buyBook();
				break;
			case 3:
				theBookStore.cartInventory();
				break;
			case 4:
				theBookStore.addBook();
				break;
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
		// TODO Auto-generated method stub
		return 0;
	}

	private static void addBooksFromTxtFile() {

		try {
			URL urlBookStore = new URL(
					"https://raw.githubusercontent.com/contribe/contribe/dev/bookstoredata/bookstoredata.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlBookStore.openStream()));

			String bookLine;
			boolean isAdded;

			while ((bookLine = reader.readLine()) != null) {

				BookstoreItem b = new BookstoreItem(bookLine);
				System.out.println(b.getAuthor() + " " + b.getPrice() + " " + b.getQuantity());
				// System.out.println(b.getQuantity());
				theBookList.add(b);
			}
			reader.close();
			theBookStore.add(theBookList);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

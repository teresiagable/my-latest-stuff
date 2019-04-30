package gable.bookstore;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	
    	
    	URL urlBookStore;
    	String bookData;
    	List<Book> 
		try {
			urlBookStore = new URL("https://raw.githubusercontent.com/contribe/contribe/dev/bookstoredata/bookstoredata.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(urlBookStore.openStream()));

			while ((bookData = in.readLine()) != null)
				
			    System.out.println(bookData);
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

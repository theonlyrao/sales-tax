import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesTaxCalculator {

    BufferedReader inputStream = null;
    PrintWriter outputStream = null;
    List<String> rawCart = new ArrayList<String>();
    ParsedLine parsedLine;
    
    public SalesTaxCalculator() {};

    public ParsedLine parseLine(String rawLine) {
	parsedLine = new ParsedLine(rawLine);
	return parsedLine;
    }

    public List<String> analyze(String path) {

	rawCart = this.parseCart(path);
	
	List<String> formattedOutput = new ArrayList<String>();
	formattedOutput = rawCart;
	for ( int i = 0; i < formattedOutput.size(); i++ ) {
	    System.out.println(formattedOutput.get(i));
	}
	return formattedOutput;
    }

    public List<String> parseCart(String path) {
	List<String> cartItems = new ArrayList<String>();
	
        try {
            inputStream = new BufferedReader(new FileReader(path));
            outputStream = new PrintWriter(new FileWriter("cart.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                //outputStream.println(l);
		cartItems.add(l);
            }
	    inputStream.close();
        } catch (IOException x) {
	    System.err.println(x);
	}

	return cartItems;
    }
    
}

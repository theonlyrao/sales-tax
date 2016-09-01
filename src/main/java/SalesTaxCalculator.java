import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

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
	
	List<String> c = new ArrayList<String>();
	BigDecimal taxes = new BigDecimal(0);
	BigDecimal total = new BigDecimal(0);
	
	for ( int i = 0; i < rawCart.size(); i++ ) {
	    ParsedLine item = this.parseLine(rawCart.get(i));
	    if (item.isImported()) {
		c.add(item.quantity() + " imported " + item.item() + ": " + item.total());
	    } else {
		c.add(item.quantity() + " " + item.item() + ": " + item.total());
	    }
	    taxes = taxes.add(item.tax());
	    total = total.add(item.total());
	}

	c.add("Sales Taxes: " + taxes);
	c.add("Total: " + total);

	return c;
    }

    public List<String> parseCart(String path) {
	List<String> cartItems = new ArrayList<String>();
	
        try {
            inputStream = new BufferedReader(new FileReader(path));
            outputStream = new PrintWriter(new FileWriter("cart.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
		cartItems.add(l);
            }
	    inputStream.close();
        } catch (IOException x) {
	    System.err.println(x);
	}

	return cartItems;
    }
    
}

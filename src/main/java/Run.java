import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Run {
    public static void main(String[] args) {
	String path = args[0];

	SalesTaxCalculator calc = new SalesTaxCalculator();
	List<String> cartInfo = new ArrayList<String>();
	PrintWriter outputStream = null;
	
	cartInfo = calc.analyze(path);
	System.out.println("before try");

	try {
	    System.out.println("in try");
	    outputStream = new PrintWriter(new FileWriter("cart.txt", true));		    
	    for ( int j = 0; j < cartInfo.size(); j++) {
		System.out.println(cartInfo.get(j));
		outputStream.append(cartInfo.get(j));
	    }
	} catch (IOException x) {
	    System.err.println(x);
	}
    }
}

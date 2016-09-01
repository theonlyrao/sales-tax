import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
	String path = args[0];

	SalesTaxCalculator calc = new SalesTaxCalculator();
	List<String> cartInfo = new ArrayList<String>();
	
	cartInfo = calc.analyze(path);
	System.out.println("Cart analyzed");
	
	try {
	    System.out.println("Opening ./cart.txt");
	    FileWriter fileWriter = new FileWriter("cart.txt",true);
	    BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

	    for ( int j = 0; j < cartInfo.size(); j++) {
		System.out.println("Writing: \"" + cartInfo.get(j) + "\"");		
		bufferWriter.write(cartInfo.get(j));
		bufferWriter.newLine();		
	    }
	    
	    bufferWriter.close();
	    System.out.println("Closed ./cart.txt");	    
	    
	} catch (IOException x) {
	    System.err.println(x);
	}
    }
}

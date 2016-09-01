import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class SalesTaxCalculatorTest {
    @Test public void canSplitString() {
	SalesTaxCalculator calculator = new SalesTaxCalculator();
	String rawLineItem = "2 imported box of chocolates at 8.25";

	ParsedLine parsedLine;
	parsedLine = calculator.parseLine(rawLineItem);

	assertEquals(2, parsedLine.quantity());
	assertEquals(true, parsedLine.isImported());
	assertEquals("box of chocolates", parsedLine.item());
	assertEquals(16.50, parsedLine.subTotal(), 0.03);
	//assertEquals(0.825, parsedLine.tax(), 0.03);

    }
    
    @Test public void testThreeDomesticCart() {
	SalesTaxCalculator calculator = new SalesTaxCalculator();
	String cartPath = "./src/test/java/carts/threeDomestic.txt";

	List<String> output;
	output = calculator.analyze(cartPath);

	assertEquals("1 book: 12.49", output.get(0));
	assertEquals("1 music CD: 16.49", output.get(1));
	assertEquals("1 chocolate bar: 0.85", output.get(2));
	//assertEquals("Sales Taxes: 1.50", output.get(3));
	assertEquals("Total: 29.83", output.get(4));
    }
}

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.math.BigDecimal;

public class SalesTaxCalculatorTest {
    @Test public void canSplitString() {
    	SalesTaxCalculator calculator = new SalesTaxCalculator();
    	String rawLineItem = "2 imported box of chocolates at 8.25";

    	ParsedLine parsedLine;
    	parsedLine = calculator.parseLine(rawLineItem);

    	assertEquals(new BigDecimal("2"), parsedLine.quantity());
    	assertEquals(true, parsedLine.isImported());
    	assertEquals("box of chocolates", parsedLine.item());
    	assertEquals(new BigDecimal("16.50"), parsedLine.subTotal());
    }
    
    @Test public void testThreeDomesticCart() {
    	SalesTaxCalculator calculator = new SalesTaxCalculator();
    	String cartPath = "./src/test/java/carts/threeDomestic.txt";

    	List<String> output;
    	output = calculator.analyze(cartPath);

    	assertEquals("1 book: 12.49", output.get(0));
    	assertEquals("1 music CD: 16.49", output.get(1));
    	assertEquals("1 chocolate bar: 0.85", output.get(2));
    	assertEquals("Total: 29.83", output.get(4));
    }

    @Test public void canCalculateTax() {
    	SalesTaxCalculator calculator = new SalesTaxCalculator();
    	String cdString = "1 music CD at 14.99";
    	String chocolateString = "1 imported box of chocolates at 10.00";
    	String perfumeString = "1 imported bottle of perfume at 47.50";
	
    	ParsedLine cd = calculator.parseLine(cdString);
    	ParsedLine chocolate = calculator.parseLine(chocolateString);
    	ParsedLine perfume = calculator.parseLine(perfumeString);

    	assertEquals(false, cd.isImported());
    	assertEquals("music CD", cd.item());
    	assertEquals(new BigDecimal("1.50"), cd.tax());

    	assertEquals(true, chocolate.isImported());
    	assertEquals("box of chocolates", chocolate.item());
    	assertEquals(new BigDecimal("0.50"), chocolate.tax());

    	assertEquals(true, perfume.isImported());
    	assertEquals("bottle of perfume", perfume.item());
    	assertEquals(new BigDecimal("7.15"), perfume.tax());
    }
}

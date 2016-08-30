import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class SalesTaxCalculatorTest {
    @Test public void testThreeDomesticCart() {
	SalesTaxCalculator calculator = new SalesTaxCalculator();
	String cartPath = "./src/test/java/carts/threeDomestic.txt";

	List<String> output;
	output = calculator.analyze(cartPath);

	assertEquals("1 book: 12.49", output.get(0));
	assertEquals("1 music CD: 16.49", output.get(1));
	assertEquals("1 chocolate bar: 0.85", output.get(2));
	assertEquals("Sales Taxes: 1.50", output.get(3));
	assertEquals("Total: 29.83", output.get(4));
    }
}

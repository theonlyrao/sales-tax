import org.junit.Test;
import static org.junit.Assert.*;

eshellpublic class SalesTaxCalculatorTest {
    @Test public void testThreeDomesticCart() {
	SalesTaxCalculator calculator = new SalesTaxCalculator();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
	String cartPath = "./cart/threeDomestic.txt";

	String[] output;
	output = calculator.analyze(cartPath);

	assertEquals("1 book: 12.49", output[0]);
	assertEquals("1 music CD: 16.49", output[1]);
	assertEquals("1 chocolate bar: 0.85", output[2]);
	assertEquals("Sales Taxes: 1.50", output[3]);
	assertEquals("Total: 29.83", output[4]);
    }
}

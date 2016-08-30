import org.junit.Test;
import static org.junit.Assert.*;

public class ItemIndexTest {
    @Test public void testCanIdFood() {
	ItemIndex items = new ItemIndex();
	items.load();
	String item = "chocolate bar";

	String output;
	output = items.typeOf(item);

	assertEquals("food", output);
    }

    @Test public void testCanIdBooks() {
	ItemIndex items = new ItemIndex();
	items.load();
	String item = "book";

	String output;
	output = items.typeOf(item);

	assertEquals("book", output);
    }
    
}

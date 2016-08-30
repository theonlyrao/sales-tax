import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class ItemIndex {
    Hashtable<String, String> itemTypes = new Hashtable<String, String>();

    public void load() {

	itemTypes.put("chocolate bar", "food");
	itemTypes.put("book", "book");

    }

    public String typeOf(String item) {
	String type;
	type = itemTypes.get(item);
	System.out.println("item is " + item + " with type " + type);
	return type;
    }
}

import java.util.Hashtable;

public class ItemIndex {
    Hashtable<String, String> itemTypes = new Hashtable<String, String>();

    public void load() {

	itemTypes.put("chocolate bar", "food");
	itemTypes.put("book", "book");
	itemTypes.put("headache pills", "medical product");
	itemTypes.put("box of chocolates", "food");
	itemTypes.put("box of imported chocolates", "food");

    }

    public String typeOf(String item) {
	String type;
	type = itemTypes.get(item);
	return type;
    }
}

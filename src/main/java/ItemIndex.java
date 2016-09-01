import java.util.Hashtable;

public class ItemIndex {
    Hashtable<String, String> itemTypes = new Hashtable<String, String>();

    public void load() {

	itemTypes.put("chocolate bar", "food");
	itemTypes.put("book", "book");
	itemTypes.put("packet of headache pills", "medical product");
	itemTypes.put("box of chocolates", "food");
	itemTypes.put("box of imported chocolates", "food");
	itemTypes.put("music CD", "misc");	
	itemTypes.put("bottle of perfume", "misc");
    }

    public String typeOf(String item) {
	String type;
	type = itemTypes.get(item);
	return type;
    }
}

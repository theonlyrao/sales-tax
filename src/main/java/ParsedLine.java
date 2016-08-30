public class ParsedLine {

    String line;

    public ParsedLine(String rawLine) {
	line = rawLine;
    }

    public int quantity() {
	int quantity = 0;
	return quantity;
    }

    public boolean isImported() {
	return false;
    }

    public String item() {
	String item = "pizza";
	return item;
    }

    public float subTotal() {
	float subTotal = 0;
	return subTotal;
    }

    public float tax() {
	float tax = 0;
	return tax;
    }
}

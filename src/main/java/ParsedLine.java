import java.lang.Integer;

public class ParsedLine {

    String line;

    public ParsedLine(String rawLine) {
	line = rawLine;
    }

    public int quantity() {
	String[] tmp = new String[5];
	tmp = line.split("\\s+");
	
	int quantity;
	quantity = Integer.parseInt(tmp[0]);
	return quantity;
    }

    public boolean isImported() {
	return line.contains("imported");
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

import java.lang.Integer;

public class ParsedLine {

    String line;
    String[] tmp = new String[5];


    public ParsedLine(String rawLine) {
	line = rawLine;
	tmp = line.split("\\s+");	
    }

    public int quantity() {
	int quantity;
	quantity = Integer.parseInt(tmp[0]);
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

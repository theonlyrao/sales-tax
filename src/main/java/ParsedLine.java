import java.lang.Integer;

public class ParsedLine {

    String line;

    public ParsedLine(String rawLine) {
	line = rawLine;
    }

    public int quantity() {
	String[] a = new String[5];
	a = line.split("\\s+", 2);
	
	int quantity;
	quantity = Integer.parseInt(a[0]);
	return quantity;
    }

    public boolean isImported() {
	return line.contains("imported");
    }

    public String item() {
	String[] b1 = new String[5];
	b1 = line.split("\\s+", 2);

	String[] b2 = new String[5];
	b2 = b1[1].split(" at");

	if (b2[0].contains("imported")) {
	    b2[0] = b2[0].replace("imported", "");
	} 

	return b2[0].trim();
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

import java.lang.Integer;
import java.lang.Float;

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
	    b2[0] = b2[0].replace("imported ", "");
	} 

	return b2[0].trim();
    }

    public float subTotal() {
	String[] c = new String[10];	
	c = line.split("\\s+");

	float subTotal;
	subTotal = Float.parseFloat(c[c.length-1]);
	return subTotal * this.quantity();
    }

    public float tax() {
	float multiplier = 0;
	
	ItemIndex index = new ItemIndex();
	index.load();

	String localItem;
	localItem = this.item();

	String taxType;
	taxType = index.typeOf(localItem);

	if (this.isImported()) {
	    multiplier += 0.05;
	}

	if (taxType.equals("misc")) {
	    multiplier += 0.1;
	}
	
	float tax;
	tax = multiplier * this.subTotal();
	System.out.println("tax for " + localItem + " is " + tax);
	return (float) (Math.ceil(tax * 20)/20);
    }

    public float total() {
	return this.subTotal() + this.tax();
    }
}

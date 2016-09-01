import java.lang.Integer;
import java.lang.Float;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ParsedLine {

    String line;

    public ParsedLine(String rawLine) {
	line = rawLine;
    }

    public BigDecimal quantity() {
	String[] a = new String[5];
	a = line.split("\\s+", 2);
	
	BigDecimal quantity = new BigDecimal(a[0]);
	//quantity = Integer.parseInt(a[0]);
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

    public BigDecimal subTotal() {
	String[] c = new String[10];	
	c = line.split("\\s+");

	BigDecimal subTotal = new BigDecimal(c[c.length-1]);
	//subTotal = Float.parseFloat(c[c.length-1]);
	//return subTotal * this.quantity();

	return subTotal.multiply(this.quantity());
    }

    public BigDecimal tax() {
	BigDecimal multiplier = new BigDecimal(0);
	BigDecimal importTax = new BigDecimal("0.05");
	BigDecimal miscTax = new BigDecimal("0.10");
	
	ItemIndex index = new ItemIndex();
	index.load();

	String localItem;
	localItem = this.item();

	String taxType;
	taxType = index.typeOf(localItem);

	if (this.isImported()) {
	    multiplier = multiplier.add(importTax);
	}

	if (taxType.equals("misc")) {
	    multiplier = multiplier.add(miscTax);
	}
	
	BigDecimal t;
	t = multiplier.multiply(this.subTotal()).setScale(2, RoundingMode.UP);

	BigDecimal[] q = t.multiply(new BigDecimal("100")).divideAndRemainder(new BigDecimal("10"));
	BigDecimal r = q[1];

	//System.out.println("remainder is " + r);
	
	if ( r.equals(new BigDecimal("9.00")) ) {
	    t = t.add(new BigDecimal("0.01"));
	}

	if ( r.equals(new BigDecimal("8.00")) ) {
	    t = t.add(new BigDecimal("0.02"));
	}

	if ( r.equals(new BigDecimal("7.00")) ) {
	    t = t.add(new BigDecimal("0.03"));
	}

	if ( r.equals(new BigDecimal("6.00")) ) {
	    t = t.add(new BigDecimal("0.04"));
	}

	if ( r.equals(new BigDecimal("4.00")) ) {
	    t = t.add(new BigDecimal("0.01"));
	}

	if ( r.equals(new BigDecimal("3.00")) ) {
	    t = t.add(new BigDecimal("0.02"));
	}

	if ( r.equals(new BigDecimal("2.00")) ) {
	    t = t.add(new BigDecimal("0.03"));
	}

	if ( r.equals(new BigDecimal("1.00")) ) {
	    t = t.add(new BigDecimal("0.04"));
	}
	

	// BigDecimal twenty = new BigDecimal(20);

	// BigDecimal tax = new BigDecimal(((t.multiply(twenty)).divide(twenty)).ROUND_CEILING);

	//MathContext mc = new MathContext(5, RoundingMode.UP);

	//BigDecimal hundred = new BigDecimal(100);
	//BigDecimal tax = t.multiply(hundred);
	//tax = t.round(mc);
	//System.out.println(this.item() + " tax is " + t);	
	return t;
    }

    public BigDecimal total() {

	//return this.subTotal() + this.tax();
	BigDecimal total = this.subTotal().add(this.tax());

	return total;
    }
}

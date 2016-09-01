# Sales Tax

## How to use
1. create a text file called `myItems.txt` in the project root containing line items of the form "1 imported box of chocolates at 10.00", with each item on a separate line. If the item (e.g. "box of chocolates") does not appear in `ItemIndex` then there will be an error.
2. run `java Run ./myItems.txt`
3. run `cat ./cart.txt` to view the contents of the file created by the program

## Validation and TDD
The three sample test cases are solved by this program. Tests for these cases are availble [here](https://github.com/theonlyrao/sales-tax/blob/master/src/test/java/SalesTaxCalculatorTest.java#L20-L60).

This program was developed using TDD. The full test suite can be viewed [here](https://github.com/theonlyrao/sales-tax/tree/master/src/test/java).

## Program Design
The purpose of this program's design is to make it easy to expand or change the functionality of the program in the future. 

The design of the classes reflects the application of single responsibility programming as follows:
* The `Run` class has the responsibility of managing the reading and writing of the files involved. 
* The `SalesTaxCalculator` class has the responsibility of taking each line item in the input file, sending it for analysis, and then holding on to the aggregated results. 
* The `ParsedLine` class has the responsibility of parsing each line item and doing the calculations required by the `SalesTaxCalculator` class. 
* The `ItemIndex` class is used by the `ParsedLine` class to determine the correct tax rate for any particular item. By separating this index to a separate class, it will be easiser to implement a more robust solution for the need to look up the type of an item, such as using a database. The `SalesTaxCalculator` is exposed to the structure of the index only in [one section of code](https://github.com/theonlyrao/sales-tax/blob/master/src/main/java/ParsedLine.java#L55-L62). It would be possible to replace the internals of the current `ItemIndex` class with anything as long as an instance of that class can respond to the `typeOf()` message and will return that item's type as a string.

Finally, wherever possible the method names have been selected to assit the reader's comprehension of the code. For example, when the method `isImported()` when sent to an instance of the `ParsedLine` class will return a boolean indicating whether or not the item in that line item was imported.

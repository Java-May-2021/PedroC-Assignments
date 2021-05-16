
public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		c.performOperation(10.5);
		c.performOperation("+");
		c.performOperation(5.2);
		c.performOperation("*");
		c.performOperation(10);
		c.performOperation("=");
		System.out.println(c.getResults());

		Calculator c2 = new Calculator();
		c2.performOperation(10.5);
		c2.performOperation("*");
		c2.performOperation(5.2);
		c2.performOperation("+");
		c2.performOperation(10);
		c2.performOperation("=");
		System.out.println(c2.getResults());
}

}

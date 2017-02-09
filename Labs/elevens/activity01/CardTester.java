/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
	    Card test = new Card("A", "Giraffes", 2);
	    System.out.println(test.suit());
	    System.out.println(test.rank());
	    System.out.println(test.pointValue());
	    test = new Card("B", "Giraffes", 1);
	    System.out.println(test.suit());
	    System.out.println(test.rank());
	    System.out.println(test.pointValue());
	    Card test1 = new Card("B", "Giraffes", 1);
	    System.out.println(test1.matches(test));
	    test1 = new Card("B", "Lions", 1);
	    System.out.println(test1.matches(test));
	}
}

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
	    String[] ranks = {"A", "B", "C"};
	    String[] suits = {"Giraffes", "Lions"};
	    int[] values = {2,1,6};
	    Deck test = new Deck(ranks, suits, values);
	    System.out.println(test.size());
	    System.out.println(test.deal());
	    System.out.println(test.size());
	    System.out.println(test.isEmpty());
	    System.out.println(test);
	}
}

//Connie Lei
//APCS2 pd1
//HW#29--Stress is the Best
//2017-04-04

public class DequeTester{

    public static void main(String[] args){
	Deque A = new DDeque();

	System.out.println("Testing toString() method:");
	System.out.println("Empty Deque: " + A);
	System.out.println("Testing isEmpty(): " + A.isEmpty());
	System.out.println("Testing size(): " + A.size());
		
	System.out.println("Adding Elements at the Beginning: ");
	A.addFirst("one");
	System.out.println("one: " + A);
	A.addFirst("two");
	System.out.println("two: " + A);
	System.out.println("Expected: two one");

	System.out.print("Adding Elements at the End: ");
	A.addLast("one");
	System.out.println("one: " + A);
	A.addLast("two");
	System.out.println("two: " + A);
	System.out.println("Expected: two one one two");

	System.out.println("Testing Removing Elements at the Front: ");
	System.out.println(A.peekFirst());
	System.out.println(A.removeFirst());
	System.out.println(A.peekFirst());
	System.out.println(A.removeFirst());
	System.out.println(A.peekFirst());
	System.out.println(A.removeFirst());
	System.out.println("Testing Removing Elements (with only one element remaining: ");
	System.out.println(A.peekFirst());
	System.out.println(A.removeFirst());
	System.out.println("Testing Removing Elements (without any elements: ");
	System.out.println(A.peekFirst());
	System.out.println(A.removeFirst());
	System.out.println("Expected: null");

	System.out.println("Resetting Deque");
	A.addFirst("one");
	A.addFirst("two");
	A.addLast("one");
	A.addLast("two");
	System.out.println("A size: " + A.size());

	System.out.println("Testing Removing Elements at the End: ");
	System.out.println(A.peekLast());
	System.out.println(A.removeLast());
	System.out.println(A.peekLast());
	System.out.println(A.removeLast());
	System.out.println(A.peekLast());
	System.out.println(A.removeLast());
	System.out.println("Testing Removing Elements (with only one element remaining: ");
	System.out.println(A.peekLast());
	System.out.println(A.removeLast());
	System.out.println("Testing Removing Elements (without any elements: ");
	System.out.println(A.peekLast());
	System.out.println(A.removeLast());
	System.out.println("Expected: exception");

	System.out.println("Trying contains(Object): ");
	System.out.println("null: " + A.contains(null));
	System.out.println("String: " + A.contains("String"));
	System.out.println("1: " + A.contains(1));
	System.out.println("2.1: " + A.contains(2.1));
	A.addFirst(2.1);
	System.out.println("2.1: " + A.contains(2.1));
	A.addFirst(2.1);
	System.out.println("Multiple 2.1: " + A.contains(2.1));
	System.out.println("null: " + A.contains(null));
	System.out.println("String: " + A.contains("String"));
    }

}

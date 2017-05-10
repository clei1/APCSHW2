//Team DisCord
//Donia Tung & Connie Lei
//APCS2 pd1
//HW#32 -- Stress is the Best
//2017-04-19

import java.util.ArrayList; //need to import our underlying data structure

public class ArrayPriorityQueue implements PriorityQueue{ //implements interface

    //instance variables
    private ArrayList<Integer> _queue;
    private int _size; //nice to have for isEmpty

    //constructor -- initializes instance variables
    public ArrayPriorityQueue(){
	_queue = new ArrayList<Integer>();
	_size = 0; //even though _queue might have size 10, it is technically empty because no items of importance have been added
    }

    //--------------v  PriorityQueue interface methods  v--------------
    public void add(int x) {
	_queue.add(x);
	_size ++;
    }
    
    public boolean isEmpty() {
	return _size == 0;
    }
    
    public int peekMin() {
	if (isEmpty()) //exception throwing according to the API
	    throw new RuntimeException();
	else {
	    int temp = _queue.get(0);
	    for (int counter = 1 ; counter < _size ; counter ++) {
		if ((_queue.get(counter).compareTo(temp)) < 0)
		    temp = _queue.get(counter);
	    }
	    return temp;
	}
    }
    
    public int removeMin(){
	if (isEmpty()) //exception throwing according to the API
	    throw new RuntimeException();
	else{
	    int position = 0;
	    for (int counter = 1 ; counter < _size ; counter ++){
		if (_queue.get(counter).compareTo(_queue.get(position)) < 0){
		    position = counter;
		}
	    }
	    _size --;
	    return _queue.remove(position);
	}
    }
    //--------------^  PriorityQueue interface methods  ^--------------
    
    public String toString() {
	String print = "[";
	for(Integer i : _queue) {
	    print += " ";
	    print += i;
	}
	print += " ]";
	return print;
    }

    //main method for testing
    public static void main(String[] args) {

	PriorityQueue david = new ArrayPriorityQueue();
	System.out.println("Testing toString method: " + david);
	System.out.println("Testing isEmpty method: " + david.isEmpty());

	System.out.println("Testing adding");
	System.out.println(david);
	david.add(0);
	david.add(50);
	david.add(15);
	david.add(0);
	System.out.println(david);

	System.out.println("Testing isEmpty method: " + david.isEmpty());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());

	//should throw a runtime error exception
	System.out.println("Testing remove when empty");
	System.out.println(david.peekMin());
	System.out.println(david.removeMin());

    }//end main
    
}//end class
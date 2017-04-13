//Team DC
//Donia & Connie
//APCS2 pd1
//HW#28 -- Shuffling
//2017-03-30

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _front = null;
	    _end = null;
	    _size = 0;
	}


    public void enqueue( T enQVal ) 
    {
	if(_front == null){
	    _front = new LLNode<T>(enQVal, null);
	    _end = _front;
	}
	else{
	    LLNode<T> temp = new LLNode<T>(enQVal, null);
	    _end.setNext(temp);
	    _end = temp;
	}
	_size ++;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
	T value = _front.getValue();
	sample();
	return value;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * Similar to shuffling a deck of cards, 
     * you make sure there's more than one node and then you can cut the deck
     * if there isn't more than one node, you leave it be
     ******************************************/
    public void sample () 
    {
        _front = _front.getNext();
	_size--;
	if(_size > 1){
	    LLNode<T> oldFront = _front;
	    LLNode<T> newEnd = _front;
	    for(int counter = (int)(Math.random() * _size); counter > 1; counter --){
		newEnd = newEnd.getNext();
	    }
	    _front = newEnd.setNext(null);
	    _end.setNext(oldFront);
	    _end = newEnd;
	}
    }


    public boolean isEmpty() 
    { 
	return _front == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	String ret = "";
	LLNode<T> temp = _front;
	while(temp != null){
	    ret += temp.getValue();
	    ret += " ";
	    temp = temp.getNext();
	}
	return ret;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue

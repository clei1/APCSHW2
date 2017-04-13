//Team DC Legends of Tomorrow
//Donia Tung, Connie Lei
//APCS2 pd1
//HW#27: Sara Lance & Hawkgirl
//2017-03-29

import java.util.ArrayList;

public class ALQueue<T> implements Queue<T>{

    private ArrayList<T> line;
    
    public ALQueue(){
	line = new ArrayList<T>();
    }

    public void enqueue(T enQVal){
	line.add(enQVal);
    }
    //O(1);

    public T dequeue(){
	return line.remove(0);
    }
    //O(1);

    public boolean isEmpty(){
	return line.size() == 0;
    }
    
    public T peekFront(){
	return line.get(0);
    }
    //O(1);

    public String toString(){
	String ret = "";
	for(T x : line){
	    ret += x;
	    ret += " ";
	}
	return ret;
    }
    //O(n);
    
    public static void main( String[] args ) {

	//v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	Queue<String> LLQueuelJ = new ALQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( LLQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );
	//^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue


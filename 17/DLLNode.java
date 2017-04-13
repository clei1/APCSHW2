//Connie Lei
//APCS2 pd1
//HW#18
//2017-03-15

/*****************************************************
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode 
{

    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode; //pointer to next DLLNode
    private DLLNode _previousNode; //pointer to previous DLLNode

    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode previous, DLLNode next ) 
    {
	_cargo = value;
	_previousNode = previous;
	_nextNode = next;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrevious(){ return _previousNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) 
    {
	String temp = _cargo;
	_cargo = newCargo;
	return temp;
    }

    public DLLNode setNext( DLLNode newNext ) 
    {
	DLLNode temp = _nextNode;
	_nextNode = newNext;
	return temp;
    }

    public DLLNode setPrevious( DLLNode newPrevious){
	DLLNode temp = _previousNode;
	_previousNode = newPrevious;
	return temp;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) 
    {

	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null,  null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", first, null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", first.getNext(), null ) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

	// A naive list traversal:
	while( first != null ) {
	    System.out.println( first );
	    first = first.getNext();
	}
	

	//Q: When head ptr moves to next node in list,
	//   what happens to the node it just left?

    }//end main

}//end class LLNode

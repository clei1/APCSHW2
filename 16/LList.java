//Connie Lei
//APCS2 pd1
//HW#16 -- So Many Lists
//2017-03-12


/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private LLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add(String x){
	if(_head == null){
	    _head = new LLNode(x, null);
	}
	else{
	    LLNode temp = _head;
	    for(int y = 1; y < _size; y++){
		temp = temp.getNext();
	    }
	    temp.setNext(new LLNode(x, null));
	}
	_size += 1;
	return true;
    }

    public String get(int i){
	LLNode temp = _head;
	for(int x = 0; x < i; x++){
	    temp = temp.getNext();
	}
	return temp.getCargo();
    }

    public String set(int i, String x){
	LLNode temp = _head;
	for(int y = 0; y < i; y++){
	    temp = temp.getNext();
	}
	return temp.setCargo(x);
    }

    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList




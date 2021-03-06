//Connie Lei
//APCS2 pd1
//HW#19 -- When Will Mr.Brown return?
//2017-03-16


/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList<T> implements List<T>
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	_head = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add(T x){
	if(_head == null){
	    _head = new DLLNode<T>(x, null, null);
	}
	else{
	    DLLNode<T> temp = _head;
	    for(int y = 1; y < _size; y++){
		temp = temp.getNext();
	    }
	    temp.setNext(new DLLNode<T>(x, temp, null));
	}
	_size += 1;
	return true;
    }

    public T get(int i){
	DLLNode<T> temp = _head;
	for(int x = 0; x < i; x++){
	    temp = temp.getNext();
	}
	return temp.getCargo();
    }

    public T set(int i, T x){
	DLLNode<T> temp = _head;
	for(int y = 0; y < i; y++){
	    temp = temp.getNext();
	}
	return temp.setCargo(x);
    }

    //return number of nodes in list
    public int size() { return _size; }

    public T remove( int index ){
	DLLNode<T> before = _head;
	DLLNode<T> removed = _head;
	for(int x = 0; x < index; x++){
	    before = removed;
	    removed = removed.getNext();
	}
	before.setNext(removed.getNext());
	removed.getNext().setPrevious(before);
	_size -= 1;
	return removed.getCargo();
    }

    public void add( int index, T newVal ){
	DLLNode<T> before = _head;
	DLLNode<T> next = _head;
	for(int x = 0; x < index; x ++){
	    before = next;
	    next = next.getNext();
	}
        before.setNext(new DLLNode<T>(newVal, before, next));
	_size += 1;
    }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
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

	james.add( 1, "got" );
	System.out.println( "size: " + james.size() );

	james.remove(1);
	System.out.println( "size: " + james.size() );
		
	System.out.println( james );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList




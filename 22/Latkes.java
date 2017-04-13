//Connie Lei
//APCS2 pd1
//HW#22--Stacks
//2017-03-22

/***
 * class Latkes
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
        _stack = new String[size];
	_stackSize = 0;
    }

    //means of insertion
    public void push( String s ) 
    {
	_stack[_stackSize] = s;
	_stackSize += 1;
    }

    //means of removal
    public String pop( ) 
    { 
        _stackSize --;
	return stack[_stackSize];
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull() 
    {
        return _stackSize == _stack.length;
    }

}//end class Latkes


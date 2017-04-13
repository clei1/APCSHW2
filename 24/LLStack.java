//Connie Lei
//APCS2 pd1
//HW#Leon Leonwood Stack
//2017-03-25

/*****************************************************
 * class LLStack
 * Implements ADT stack as specified in local Stack.java
 * Generically typed
 * Uses a LinkedList as underlying container
 *****************************************************/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> 
{
    private LinkedList<T> _stack;

    public LLStack(){
	_stack = new LinkedList<T>();
    }
    
    public boolean isEmpty(){
	return (_stack.size() == 0);
    }

    public T peek(){
	return _stack.getLast();
    }

    public T pop(){
	return _stack.removeLast();
    }

    public void push(T x){
	_stack.add(x);
    }



    //main method for testing
    public static void main( String[] args ) 
{
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
	Stack<String> tastyStack = new LLStack<String>();

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coocoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//joo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//ioo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//hoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//goo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//foo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//eoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//doo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//boo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//aoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	System.out.println( tastyStack.pop() );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/   
    }//end main()

}//end class LLStack

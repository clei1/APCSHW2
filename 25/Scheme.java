//Connie Lei
//APCS2 pd1
//HW#25--Too Hard
//2017-03-27


/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 * <<< YOUR PROCEDURE HERE >>>
 * 
 * STACK OF CHOICE: linkedList by Connie
 * b/c ...
 * there is more functionality
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] temp = expr.split("\\s+");

	
	LLStack<String> numbers = new LLStack<String>();
	LLStack<Integer> operand = new LLStack<Integer>();
		   
       

    }

    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operator to
     *           sequence of numbers.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	int num = 0;
	if(op == 3){
	    num = 1;
	}
	while(!numbers.peek().equals("("){
	    if(op == 1){
		num += Integer.valueOf(numbers.pop());
	    }
	    else if(op == 2){
		num -= Integer.valueOf(numbers.pop());
	    }
	    else{
		num *= Integer.valueOf(numbers.pop());
	    }
	}
	return Integer.toString(num);
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7
	
	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17
	/*
	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//main

}//end class Scheme

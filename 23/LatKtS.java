//Connie Lei
//APCS2 pd1
//HW#23
//2017-03-22

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
	Latkes reverse = new Latkes(s.length());
	for(int x = 0; x < s.length(); x++){
	    reverse.push(s.substring(x, x + 1));
	}
	String rS = "";
	while(! reverse.isEmpty()){
	    rS += reverse.pop();
	}
	return rS;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	if(s.length() % 2 != 0){
	    return false;
	}
	Latkes temp = new Latkes(s.length());
	for(int x = 0; x < s.length(); x ++){
	    String current = s.substring(x, x + 1);
	    if(current.equals("{") ||
	       current.equals("[") ||
	       current.equals("("))
		temp.push(current);
	    else{
		String match = temp.pop();
		if((current.equals("}") && (! match.equals("{")))||
		   (current.equals(")") && (! match.equals("(")))||
		   (current.equals("]") && (! match.equals("[")))){
		    return false;
		}
	    }
	}
	    return true;
		
    }//end allMatched()

    /**
       Algorithm:
       If the substring is a starting character, add it to the stack.
       Once you reach a closing character, you check if the top of the stack equaled the matching set. 
       If it did not equal it, it means there is a mismatch. If there is even one mismatch, it returns false.
       If it runs through the entire string and all the matches are there, then it returns true.
    **/

    //main method to test
    public static void main( String[] args ) { 

	//v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
        // ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS

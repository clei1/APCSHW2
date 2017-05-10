//Connie Lei
//APCS2 pd1
//HW#34 -- Algorithm as Data Structure
//2016-05-04

/*****************************************************
 * class BST
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
        root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
	if(root == null)
	    root = new TreeNode(newVal);
	else
	    insertH(root, newVal);
    }   

    public void insertH(TreeNode root, int newVal){
	if(newVal < root.getValue()){ //splits it up into left or right subtree, if new value is less than the root, it goes to the left
	    if(root.getLeft() == null) //check if the subtree exists
		root.setLeft(new TreeNode(newVal)); //creation of a leaf
	    else
		insertH(root.getLeft(), newVal);
	}
	else{ //if the value isn't less than the root, it goes to the right
	    if(root.getRight() == null) //check if the subtree exists 
		root.setRight(new TreeNode(newVal)); //creation of a leaf
	    else
		insertH(root.getRight(), newVal); //recursion to go down to a branch 
	}

    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
        preOrderTrav(root);
    }

    //helper function for preOrder
    //root, left, right
    public void preOrderTrav(TreeNode root)
    {
	if(root != null){
	    System.out.print(root);
	    preOrderTrav(root.getLeft());
	    preOrderTrav(root.getRight());
	}
    }
    
    
    public void inOrderTrav() 
    {
	inOrderTrav(root);
    }

    //helper function for inOrder
    //left, root, right
    public void inOrderTrav(TreeNode root)
    {
	if(root != null){
	    inOrderTrav(root.getLeft());
	    System.out.print(root);
	    inOrderTrav(root.getRight());
	}
    }
	

    public void postOrderTrav() 
    {
        postOrderTrav(root);
    }

    //helper function for postOrder
    //left, right, root
    public void postOrderTrav(TreeNode root)
    {
	if(root != null){
	    postOrderTrav(root.getLeft()); 
	    postOrderTrav(root.getRight());
	    System.out.print(root);
	}
    }
    
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );
	  
	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();

	  System.out.println("");
	  System.out.println("");
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

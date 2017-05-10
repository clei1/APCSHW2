//Connie Lei
//APCS2 pd1
//HW#35 -- BSTs is the Perfect Place for Shade that’s just how I feel:: May the Fourth Be With You
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

    
    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
        return search(root, target);
    }

    TreeNode search( TreeNode root, int target)
    {
	if(root == null)
	    return null;
	if(root.getValue() < target)
	    return search(root.getRight(), target);
	if(root.getValue() > target)
	    return search(root.getLeft(), target);
	return root;
    }

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
	return height(root, 0);
    }

    public int height(TreeNode root, int count){
	//creates temp variables
	int right = 0; 
	int left = 0;
	
	if(root == null)
	    return count; //stops the getRight() and getLeft() methods from running because the root is null
	//also returns the counter without updating it because it isn't a node so it doesn't add to the height
	
	right = height(root.getRight(), count + 1); //stores the height of the right subtree, updates counter b/c the current node adds to the height
	left = height(root.getLeft(), count + 1); //stores the height of the left subtree, updates counter b/c the current node adds to the height
	
	if(left > right) //chooses whether the left subtree has a taller height
	    return left; //left is taller than right
	return right; //right is taller than left
    }
    
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(root);
    }

    public int numLeaves(TreeNode root){
	if(root == null) //reached a null node, probably from a leaf
	    return 0;
	if(root.getLeft() == null && root.getRight() == null){ //checks for leaf
	    return 1; //returns 1 to add to leaf
	}
	return numLeaves(root.getLeft()) + numLeaves(root.getRight()); //recursively waits like scheme 
    }
    

    //Main method for testing
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
	  
	  System.out.println( "pre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();

	  System.out.println("\n\nheight:" + arbol.height());
	  System.out.println("leaves:" + arbol.numLeaves());

	  arbol.insert(10);
	  arbol.insert(13);
	  arbol.insert(14);
	  arbol.insert(15);

	  System.out.println("\nAdding 10, 13, 14, 15");
	  System.out.println( "in-order traversal:" );
	  arbol.inOrderTrav();

	  System.out.println("\n\nheight:" + arbol.height());

	  System.out.println("leaves:" + arbol.numLeaves());

	  System.out.println("\nlooking for number not in tree:" + arbol.search(30));
	  System.out.println("looking for 10 in tree:" + arbol.search(10));
	  System.out.println("looking for 13 in tree:" + arbol.search(13));

	  System.out.println("\n--------------------New Tree-------------------");
	  arbol = new BST();
	  
	  System.out.println( "in-order traversal:" );
	  arbol.inOrderTrav();

	  System.out.println("\n\nheight:" + arbol.height());

	  arbol.insert(10);

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();

	  System.out.println("\n\nheight:" + arbol.height());
	  System.out.println("leaves:" + arbol.numLeaves());
	  
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class

//Connie Lei
//APCS2 pd1
//HW#37 -- Heap of Trouble
//2017-05-09

/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap 
{
    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
	String str = "";
	for(int i : _heap){
	    str += i;
	    str += " ";
	}
	return str;
    }//O(n)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    { 
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    {
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal ) 
    {
	int pos =  _heap.size(); //set the inital position where the new element is added to the end
	_heap.add(addVal); //adds the value to the ends
	int root = (pos - 1) / 2; //finds the parent of the new value
	while(pos != 0 && //checks to make sure that the position of the new element is not at the root, because if it is, then work is done, exit
	      _heap.get(root) > _heap.get(pos)){ //checks that the parent of the value isn't smaller than the value to ensure heap, if it is than, the new value is where it should be, exit
	    swap(root, pos); //swaps the places of the parent and the new value to fix heap
	    pos = root; //updates the position of the new value
	    root = (pos - 1) / 2; //updates the position of the new value's parent
	}
    } //O(log n)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public Integer removeMin() 
    {
	if(isEmpty())
	    return null;
	    
	int pos = 0; //sets the original position to 0, the minimun value
	int child = minChildPos(pos); //find the smallest of the child
	while(child != -1){ //checks for a child
	    swap(pos, child); //swaps the two because we want the position of the minimun to become a leaf
	    pos = child; //updates the position of the root
	    child = minChildPos(pos); //finds the children of the root's current positions
	}
	return _heap.remove(pos); //removes it
    }//O(?)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	int left = 2 * pos + 1;
	int right = 2 * pos + 2;
	if(_heap.size() > right){
	    if (_heap.get(left) > _heap.get(right))
		return right;
	    return left;
	}
	else if(_heap.size() > left)
	    return left;
	return -1;
    }//O(1)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {

	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);

    }//end main()

}//end class ALHeap

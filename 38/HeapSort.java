//Connie Lei
//APCS2 pd1
//HW#38 -- Sort of Like Magic
//HW#39 -- Heaping Piles of Sordidness
//2017-05-10

import java.util.ArrayList;

public class HeapSort{

    /*
    public static void sort(ArrayList<Integer> array){
	ALHeap temp = new ALHeap();
	int size = array.size();
	while(! array.isEmpty()){
	    temp.add(array.remove(0));
	}
	while(! temp.isEmpty()){
	    array.add(temp.removeMin());
	}
    }
    //O(n)
    */
    
    public static void sort(ArrayList<Integer> array){
	int sorted = 0; //partition
	while(sorted < array.size()){
	    heapify(array, sorted);
	    sorted ++;
	}
    }
    //O(?)
    
    public static void heapify(ArrayList<Integer> _heap, int sorted){

	int current = _heap.size() - 1;
	while(current > sorted){
	    int parent = (((current - sorted) - 1) / 2 + sorted); //shift
	    if(_heap.get(current) < _heap.get(parent)){
		swap(_heap, current, parent);

		int parentP = current;

		//parent has a child smaller than it, needs swapping 
		while(needSwap(_heap, parentP, sorted)){
		    
		    int parentPL = (2 * (parentP - sorted) + 1) + sorted;
		    int parentPR = (2 * (parentP - sorted) + 2) + sorted;

		    //left child needs to be swapped with parent
		    if(parentPR >= _heap.size()){
			swap(_heap, parentP, parentPL);
			parentP = parentPL;
		    }

		    //either left or right child needs to be swapped, choose smaller of two
		    else{
	    
			//left child needs to be swapped
			if(_heap.get(parentPR) > _heap.get(parentPL)){
			    swap(_heap, parentP, parentPL);
			    parentP = parentPL;
			}

			//right child needs to be swapped
			else{
			    swap(_heap, parent, parentPR);
			    parentP = parentPR;
			}
		    }
		}
	    }
	    current --;
	}
    }

    public static boolean needSwap(ArrayList<Integer> _heap, int pos, int sorted){
	int parentP = pos;
	int parentPL = (2 * (parentP - sorted) + 1) + sorted;
	int parentPR = (2 * (parentP - sorted) + 2) + sorted;

	//if parent is leaf
	if(parentPL >= _heap.size())
	    return false;

	//has one left child
	else if(parentPR >= _heap.size())

	    //returns if left child needs to be swapped with parent
	    return _heap.get(parentP) > _heap.get(parentPL);

	//has both children
	else{
	    
	    //left child is smaller than right child
	    if(_heap.get(parentPR) > _heap.get(parentPL))
		//left child is smaller than parent, needs swapping
		return _heap.get(parentP) > _heap.get(parentPL);

	    //right child is smaller than left child
	    else
		//right child is smaller than parent, needs swapping
		return _heap.get(parentP) > _heap.get(parentPR);
	    
	}
    }

    public static void swap(ArrayList<Integer> _heap, int pos1, int pos2){
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    
    public static void main(String[] args){
	ArrayList<Integer> Anna = new ArrayList<Integer>();
	Anna.add(10);
	Anna.add(11);
	Anna.add(4);
	Anna.add(3);
	Anna.add(49);
	Anna.add(18);
	Anna.add(288);
	Anna.add(1);
	System.out.println(Anna);

	sort(Anna);

	System.out.println("After sorting");
	System.out.println(Anna);
	
	System.out.println("After sorting twice");
	System.out.println(Anna);

	ArrayList<Integer> Ginny = new ArrayList<Integer>();
	Ginny.add(288);
	Ginny.add(49);
	Ginny.add(18);
	Ginny.add(11);
	Ginny.add(10);
	Ginny.add(4);
	Ginny.add(3);
	Ginny.add(1);

	System.out.println("\nAnotha one");
	System.out.println(Ginny);

	sort(Ginny);

	System.out.println("After sorting");
	System.out.println(Ginny);

	ArrayList<Integer> Hermione = new ArrayList<Integer>();
	System.out.println("\nAnotha one, but empty");
	System.out.println(Hermione);

	sort(Hermione);

	System.out.println("After sorting");
	System.out.println(Hermione);
    }
}

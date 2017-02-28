//Connie Lei
//APCS2 pd1
//HW#6 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
//2017-02-10

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 

  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] merged = new int[a.length + b.length];
	int aPos = 0;
	int bPos = 0;
	for ( int x = 0; x < merged.length; x ++){
	    if(aPos == a.length){
		merged[x] = b[bPos];
		bPos += 1;
	    }
	    else if(bPos == b.length){
		merged[x] = a[aPos];
		aPos += 1;
	    }
	    else if(a[aPos] <  b[bPos]){
		merged[x] = a[aPos];
		aPos += 1;
	    }
	    else{
		merged[x] = b[bPos];
		bPos += 1;
	    }	    
	}
	return merged;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if(arr.length == 1){
	    return arr;
	}
	else{
	    int[] arr1 = new int[ arr.length/2];
	    int[] arr2 = new int[ arr.length - arr.length/2];
	    for(int x = 0; x < arr.length; x++){
		if(x < arr1.length){
		    arr1[x] = arr[x];
		}
		else{
		    arr2[x -(arr1.length)] = arr[x];
		}
	    }
	    return(merge(sort(arr1), sort(arr2)));
	}
    }//end sort()

    //merge(sort(arr1), sort(arr2))
    //merge(sort(merge(arr1.1), merge
    // arr1 5
    // arr1[0-2] arr1[3-5]

    //merge(sort(arr[0-5]), sort(arr[6-10]))
    //merge(merge(sort(arr[0-2]), sort(arr[3-5])), merge(sort(arr[6-8]), sort(arr[9-10])))


    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    }//end main()

}//end class MergeSort


//Connie Lei
//APCS2 pd1
//HW#15 -- So So Quick
//2017-03-09

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): Input the lowerbound and upperbound, then find the median and use that as the pivot. If the lowerbound and upperbound subtract to 0 or 1, then stop because that is sorted.
 *
 * 2a. Worst pivot choice / array state and associated runtime: The worst choice is either the miniumun or the maximum because you split it into the entire array -1 and 0. It would be 0(n^2).
 *
 * 2b. Best pivot choice / array state and associated runtime: The best choice is the median because it ensures you are splitting the array in half. It would be O(logn).
 *
 * 3. Approach to handling duplicate values in array: It is already done with parititon because it moves it to the left since all values equal or less than our pivot is moved to the left.
 *
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }

    public static int partition(int [] arr, int lb, int ub, int pivot){
	// lb = lower bound, ub = upper bound
	int v = arr[pivot];
	swap(ub, pivot, arr);
	int s = lb;
	for (int i = lb; i < ub; i++){
	    if (arr[i] <= v) {
		swap(s, i, arr);
		s++;
	    }
	}
	swap(ub, s, arr);
	//printArray(arr);
	//System.out.println(" Returns: "+ s +"\n"); //prints final value of s
	return s;
    }

    public static int findElement(int [] arr, int y){
	int lb = 0;
	int ub = arr.length -1;
	int pivot = arr.length/2;
	int comp = -1; // Compared value
	while (comp != y){
	    comp = partition(arr, lb, ub, pivot);
	    if (comp > y){
		ub = comp;
		pivot = comp - 1;
	    }
	    else{
		lb = comp;
		pivot = comp + 1;
	    }
	}
	return comp;
    }

    public static void qsortH(int[] arr, int lb, int ub){
	if(ub > lb){
	    int mid = partition(arr, lb, ub, lb);
	    qsortH(arr, mid + 1, ub);
	    qsortH(arr, lb, mid - 1);
	}
    }
    
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) 
    { 
        qsortH(d, 0, d.length -1);
    }

    // Thinkers are encouraged to roll their own subroutines.
    // Insert your auxiliary helper methods here.


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case:
	int [] arr1 = {1, 3, 5,7,12};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after sort: " );
	printArr(arrN);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);
	

	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort

//Connie Lei
//APCS2 pd1
//HW#14 -- So So Fast
//2017-03-07

/*
The base case is that mysterion returns a position equal to the number of numbers below it that are smaller.
If that number is equal to the position we want,then we can return the number at that position.
The recursion will stop once it hits a base case.
However, the branching occurs either up or down. If the number is greater than the position we want, then we go lower because
this means there are smaller numbers under our position. This means our current position is too large.
If the number is smaller, we go up because our current psotion is too large.
 */

class Mysterion 
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
    //--------------^  HELPER METHODS  ^--------------



    public static int mysterion( int arr[], int a, int b, int c)
    {
	int v = arr[c];

	swap( c, b, arr);
	int s = a;

	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }//end mysterion
    
}//end class Mysterion

    
public class FastSelect{

    public static int fastSearch(int[] arr, int a){
	int x = a - 1;
	   
	int temp = Mysterion.mysterion(arr, 0, arr.length-1, arr.length/2);
	if(x == temp){
	    return arr[x];
	}
	else{
	    if(temp > x){
		return arr[Mysterion.mysterion(arr, 0, arr.length - 1 - temp, temp/2)];
	    }
	    else{
		return arr[Mysterion.mysterion(arr, temp, arr.length - 1, (temp + arr.length - 1)/2)];
	    }
	}
    }
    
    public static void main(String[] args){
	int[] p1 = {8,21,17,69,343};
	int[] p3 = {1,28,33,4982,37};
	int[] p4 = {5,4,17,9000,6};
	int[] p5 = {3,0,16,599,1024};
	/*
    	for( int testC = 0; testC < 5; testC++ ) {
	    System.out.println("p1's magic nums:");
	    Mysterion.printArr(p1);
	    System.out.println("p1's " + (testC + 1) + " lowest number:");
	    System.out.println(fastSearch(p1, testC));
	    Mysterion.printArr(p1);
	    System.out.println("-----------------------");

	    System.out.println("p3's magic nums:");
	    Mysterion.printArr(p3);
	    System.out.println("p3's " + (testC + 1) + " lowest number:");
	    System.out.println(fastSearch(p3, testC));
	    Mysterion.printArr(p3);
	    System.out.println("-----------------------");

	    System.out.println("p4's magic nums:");
	    Mysterion.printArr(p4);
	    System.out.println("p4's " + (testC + 1) + " lowest number:");
	    System.out.println(fastSearch(p4, testC));
	    Mysterion.printArr(p4);
	    System.out.println("-----------------------");

	    System.out.println("p5's magic nums:");
	    Mysterion.printArr(p5);
	    System.out.println("p5's " + (testC + 1) + " lowest number:");
	    System.out.println(fastSearch(p5, testC));
	    Mysterion.printArr(p5);
	    System.out.println("-----------------------");	    
	}
	
	System.out.println("p3's magic nums:");
	Mysterion.printArr(p3);
	System.out.println("p3's " + 1 + " lowest number:");
	System.out.println(fastSearch(p3, 0));
	Mysterion.printArr(p3);
	System.out.println("-----------------------");
	*/

	int[] test = {1,2,3,4,5,6,7,8,9,10};
	Mysterion.shuffle(test);
        System.out.println(fastSearch(test, 8));
    }//end main
}

//Connie Lei
//APCS2 pd1
//HW#13--We Be Dem
//2017-03-06

public class Mysterion{

    /*
      fxn mysterion(arr,a,b,c)
      v = arr[c]
      swap arr[c], arr[b]
      s = a
      for i in [a....b-1]
      if arr[i] < v
          swap arr[s], arr[i]
	  s+1
      swap arr[b], arr[s]
      return s
    */

    public static int[] swap(int[] arr, int x, int y){
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
	return arr;
    }

    public static void print(int[] arr){
	String temp = "[";
	for(int i: arr){
	    temp += i;
	    temp += ", ";
	}
	temp += "]";
	System.out.println(temp);	   
    }

    //a is low
    //b is high
    //c is partition or pivot
    public static int mysterion(int[] arr, int a, int b, int c){
	print(arr);
	int v = arr[c];
	arr = swap(arr, c, b);
	int s = a;
	for(int i = a; i < b; i++){
	    if(arr[i] < v){
		arr = swap(arr, s, i);
		s ++;
	    }
	}
	arr = swap(arr, b, s);
	print(arr);
	return s;
    }

    public static void main(String[] args){
	int[] arr = {8, 17, 29, 78, 153, 88, 10000};
	System.out.println(mysterion(arr, 0, 2, 2));
	System.out.println(mysterion(arr, 2, 0, 1));
	System.out.println(mysterion(arr, 0, 4, 4));
	System.out.println(mysterion(arr, 2, 2, 2));
	//System.out.println(mysterion(arr, 0, 2, 80));
    }
}

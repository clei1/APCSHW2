//ViCtory
//Connie Lei && Vernita Lawren
//HW#02 -- I Am Still Searching
//2016-02-02

public class MatrixFinder{

    /*
      You start from the top right corner. You have three options: 
      1) You can return the coordinates if the target matches
      2) You can increase the number by moving down, increasing vertically
      3) You can decrease the number by moving left, decreasing horizontally
      It is a zigzag pattern moving on the diagonal.
      The worst case scenario is O(2n-1) and best case is O(1).
     */

    public static String searchMatrix(int[][] matrix, int target){
	int iteration = 0;
	int row = 0;
	int col = matrix.length - 1;
	while(col >= 0 &&
	      row >= 0 &&
	      row < matrix.length){
	    //System.out.println("(" + row + "," + col + ")");
	    iteration ++;
	    //System.out.println(iteration);
	    if(matrix[row][col] == target){
		return ("(" + row + "," + col + ")");
	    }
	    else if(matrix[row][col] > target){
		col --;
	    }
	    else if(matrix[row][col] < target){
		row ++;
	    }
	}
	return "(-1, -1)";
    }

    public static void main(String[] args){
	int[][] bey = {
	    { 1,  3,  5 },
	    { 3,  7,  8 },
	    { 6, 12, 15 },
	};
	int[][] orwell ={
	    {5, 5, 5, 5},
	    {5, 5, 5, 5},
	    {5, 5, 5, 5},
	    {5, 5, 5, 5},
	};
	System.out.println(searchMatrix(bey, 6));
	System.out.println(searchMatrix(bey, 9));
	//System.out.println(searchMatrix(bey, 15));
	System.out.println(searchMatrix(orwell, 5));
	System.out.println(searchMatrix(orwell, 9));
    }
}

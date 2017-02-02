// Team ViCtory
// Connie Lei, Vernita Lawren
// APCS2 pd1
// HW1 -- Speaking In Pseudocode
// 2017-02-02

public class Search{
    public static String searchMatrix(int[][] matrix, int target){
	int row = 0;
	int col = 0;
	while(row < matrix.length &&
	      col < matrix.length &&
	      row >= 0 ){
	    if(matrix[row][col] == target){
		return ("(" + row + "," + col + ")");
	    }
	    else if(matrix[row][col] > target){
		row--;
		col++;
	    }
	    else if(row == matrix.length - 1){
		col ++;
	    }
	    else if{
		row ++;
	    }
	}
	return "Target number could not be found in the matrix.";
	// this one does not work at all, I literally had to change where I started... makes me mad
	// creds to Zicheng for winky faces and vauge pointers
	// still boggles my mind
	// i just need this here so i can find out how to make it work for this one...
    }

    public static String searchMatrix1(int[][] matrix, int target){
	int row = 0
	int col = matrix.length - 1;
	while(col >= 0 &&
	      row >= 0 &&
	      row < matrix.length){
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
	return "Target number could not be found in the matrix.";
    }
}

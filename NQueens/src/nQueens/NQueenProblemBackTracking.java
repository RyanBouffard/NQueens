package nQueens;

import java.util.Scanner; 


public class NQueenProblemBackTracking { 
 final int N = 8; 
 private static int count = 0;

 /* A utility function to print solution */
 void printBoard(int board[][]) 
 { 

     for (int i = 0; i < N; i++) { 
         for (int j = 0; j < N; j++) 
             System.out.print(" " + board[i][j] 
                              + " "); 
         System.out.println(); 
     } 
	 System.out.println("");
	 System.out.println("---------------------------------------");
	 System.out.println("");
 } 


 boolean placeAndCheckIfSafe(int board[][], int row, int col) { 
     
	 
	 
	 board[row][col] = 1;
     printBoard(board); 
	 
	 
     /* Check upper diagonal on left side */
     for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
         if (board[i][j] == 1 && i!=row && j!=col) {
             return false; 
         }
     }
     
     /* Check lower diagonal on left side */
     for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
         if (board[i][j] == 1 && i!=row && j!=col) {
             return false; 
         }
     }
     // upper right
     for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
    	 if (board[i][j] == 1 && i!=row && j!=col) {
             return false; 
    	 }

     }
    // lower right
     for (int i = row, j = col; i < N  && j < N; i++, j++) {
    	 if (board[i][j] == 1 && i!=row && j!=col) {
             return false; 
    	 }
     }
     // column
     for (int i = 0; i < N; i++) {
    	 if (board[i][col] == 1 && i!=row) {
             return false;
    	 }
     }
     // row
     for (int i = 0; i < N; i++) {
         if (board[row][i] == 1 && i!=col) {
             return false; 
         }
     }
     
     return true; 
 } 


 boolean solveNQ(int board[][], int row, int startPos) { 
     // base case: If all queens are placed then return true 
     if (row == N) {
         return true;
     }
	 if (row == 0) {
		 row++;
	 } 

     for (int i = 0; i < N; i++) { 
    	 count++;
    	 
         if (placeAndCheckIfSafe(board, row, i)) { 
             if (solveNQ(board, row + 1, startPos) == true) {
                 return true; 
             }
         } 
        	 board[row][i] = 0; // BACKTRACK  
     } 


     return false; 
 } 


 boolean setupNQ(int startPos) 
 { 
	 int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
     board[0][startPos] = 1;
     if (solveNQ(board, 0, startPos) == false) { 
    	 System.out.print("Error: Can't find solution."); 
         System.out.println("");
         return false; 
     } 

     return true; 
 } 

 // driver program
 public static void main(String args[]) { 

	 Scanner scan = new Scanner(System.in);
	 System.out.println("Please enter starting column for Q1 (0-7): ");
	 int startingColumn = scan.nextInt();
//	 int startingColumn = 7;
	 
	 NQueenProblemBackTracking Queen = new NQueenProblemBackTracking(); 
//	 long startTime = System.nanoTime();
     Queen.setupNQ(startingColumn); 
//     long endTime = System.nanoTime();
//     long totalTime = endTime - startTime;
     System.out.println("Iterations: "+count);
//     System.out.println("totalTime: "+totalTime+" ns");

 } 
} 
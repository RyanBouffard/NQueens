package nQueens;

import java.util.Scanner;

public class NQueenProblemForwardChecking {
	 final static int N = 8; 
	 private static int count = 0;
	 
	 static void printBoard(Square[][] board) 
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
	
	 static void createThreats(Square[][] board, int row, int col) {
		 // upper left
		 for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			 board[i][j].setThreats(board[i][j].getThreats()+1);
		 }
		 // lower left
		 for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
			 board[i][j].setThreats(board[i][j].getThreats()+1);
		 }
	     // upper right   	 
		 for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
			 board[i][j].setThreats(board[i][j].getThreats()+1);
		 }    
		 // lower right
		 for (int i = row, j = col; i < N  && j < N; i++, j++) {
			 board[i][j].setThreats(board[i][j].getThreats()+1);
		 }
		 // row
		 for (int i = 0; i < N; i++) {
			 board[row][i].setThreats(board[row][i].getThreats()+1);
		 }
		 // column
		 for (int i = 0; i < N; i++) {
			 board[i][col].setThreats(board[i][col].getThreats()+1);
		 }
	        	 
	 }
	 
	 static void removeThreats(Square[][] board, int row, int col) {
		 // upper left
		 for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			 board[i][j].setThreats(board[i][j].getThreats()-1);
		 }
		 // lower left
		 for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
			 board[i][j].setThreats(board[i][j].getThreats()-1);
		 }
	     // upper right   	 
		 for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
			 board[i][j].setThreats(board[i][j].getThreats()-1);
		 }    
		 // lower right
		 for (int i = row, j = col; i < N  && j < N; i++, j++) {
			 board[i][j].setThreats(board[i][j].getThreats()-1);
		 }
		 // row
		 for (int i = 0; i < N; i++) {
			 board[row][i].setThreats(board[row][i].getThreats()-1);
		 }
		 // column
		 for (int i = 0; i < N; i++) {
			 board[i][col].setThreats(board[i][col].getThreats()-1);
		 }
	        	 
	 }
	 
	 boolean solveNQ(Square board[][], int row, int startPos) { 
	     
	     if (row == N) {
	         return true;
	     }
		 if (row == 0) {
			 row++;
		 } 
		 
	     for (int i = 0; i < N; i++) { 

	         if (board[row][i].getPlacedQueen() == 0 && board[row][i].getThreats() == 0)  { 
	         	 count++;

	             board[row][i].setPlacedQueen(1);
	             createThreats(board,row,i);
//	             System.out.println(board[0][1].getThreats());
	             printBoard(board); 
	             // recursive function to place the rest of the queens
	             if (solveNQ(board, row + 1, startPos) == true) 
	                 return true; 
//	             printBoard(board); 
	             // backtrack
	             board[row][i].setPlacedQueen(0);
	             removeThreats(board,row,i);

	         } 
	     }
		return false; 
	 }
	 
	 
	 boolean setupNQ(int startPos) { 
			Square[][] board = new Square[N][N];
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					Square s1 = new Square(0,0);
					board[i][j] = s1;
				}
			}
			board[0][startPos].setPlacedQueen(1);
			createThreats(board,0,startPos);
	     if (solveNQ(board, 0, startPos) == false) { 
	         System.out.print("Error: Can't find solution."); 
	         System.out.println("");
	         return false; 
	     } 

//	     printBoard(board); 
	     return true; 
	 } 
	 
	 // driver program
	 public static void main(String args[]) { 

		 Scanner scan = new Scanner(System.in);
		 System.out.println("Please enter starting column for Q1 (0-7): ");
		 int startingColumn = scan.nextInt();
		 
		 NQueenProblemForwardChecking Queen = new NQueenProblemForwardChecking(); 
//		 long startTime = System.nanoTime();
		 Queen.setupNQ(startingColumn); 
//		 long endTime = System.nanoTime();
//	     long totalTime = endTime - startTime;
		 System.out.println("Iterations: "+count);
//	     System.out.println("totalTime(remove printing of trace for accurate time): "+totalTime+" ns");

	 } 
}

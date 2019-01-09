package com.java.core.hard;

public class MaxBlackSquare {
	public static Subsquare findLargestSubsquare(int[][] grid) { // O(n) * runtime of findSubSquare()
		Cell[][] processed = preprocessGrid(grid);
		for (int dimension = processed.length; dimension >= 1; dimension--) {
			Subsquare subsquare = findSubsquare(processed, dimension);
			if (subsquare != null) {
				return subsquare;
			}
		}
		return null;
	}
	
	public static Cell[][] preprocessGrid(int[][] grid) { // O(n^2)
		int rows = grid.length;
		int cols = grid[0].length;
		
		Cell[][] preprocessed = new Cell[grid.length][grid.length];
		for (int row = rows - 1; row >= 0; row--) {
			for (int col = cols - 1; col >= 0; col--) {
				preprocessed[row][col] = new Cell(0,0);
				if (grid[row][col] == 1) {
					preprocessed[row][col].blacksRight = 1 + ((col + 1 < cols) ? preprocessed[row][col + 1].blacksRight : 0);
					preprocessed[row][col].blacksDown  = 1 + ((row + 1 < rows) ? preprocessed[row + 1][col].blacksDown  : 0);
				}
			}
		}
		return preprocessed;
	}
	
	private static Subsquare findSubsquare(Cell[][] cellMatrix, int length) { // O(n^2) (since 2 for loops)
		int wiggleRoom = cellMatrix.length - length;
	  
		for (int startRow = 0; startRow <= wiggleRoom; startRow++) {
			for (int startCol = 0; startCol <= wiggleRoom; startCol++) {
				if (isValidSquare(cellMatrix, startRow, startCol, length)) {
					return new Subsquare(startRow, startCol, length);
				}
			}
		}
		return null;
	}
	
	private static boolean isValidSquare(Cell[][] cellMatrix, int row, int col, int length) { // O(1)
		Cell topLeft     = cellMatrix[row][col];
		Cell topRight    = cellMatrix[row][col + length - 1];
		Cell bottomLeft  = cellMatrix[row + length - 1][col];
		Cell bottomRight = cellMatrix[row + length - 1][col + length - 1];
		if (topLeft.blacksDown < length || topLeft.blacksRight < length) {
			return false;
		} else if (topRight.blacksDown < length || topRight.blacksRight < 1) {
			return false;
		} else if (bottomLeft.blacksDown < 1 || bottomLeft.blacksRight < length) {
			return false;
		} else if (bottomRight.blacksDown < 1 || bottomRight.blacksRight < 1) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Test 17.23: Max Black Square\n");
        int[][] matrix = {{1,0,1,1,1},
		                  {1,1,1,0,1},
		                  {1,1,1,1,1},
		                  {1,1,1,1,0},
		                  {1,0,1,0,1}};
        test(matrix);
	}
	
	private static void test(int[][] matrix) {
        System.out.println(MaxBlackSquare.findLargestSubsquare(matrix));
	}
}


class Cell {
	public int blacksRight = 0; // including itself
	public int blacksDown  = 0; // including itself
	
	public Cell(int right, int below) {
		blacksRight = right;
		blacksDown  = below;
	}
}

class Subsquare {
	 int row;
	 int col;
	 int length;
    
	 public Subsquare(int r, int c, int l) {
		 row    = r;
		 col    = c;
		 length = l;
	 }
	 
	 @Override
	 public String toString() {
		 return "row = " + row + "  col = " + col + "  length = " + length;
	 }
}

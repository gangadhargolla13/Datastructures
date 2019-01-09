package com.java.core.moderate;

public class TicTacWin {
boolean[] winnerMap;
	
	public static int convertBoardToInt(char[][] board) {
		int sum = 0;
		int factor = 1;
		int dimension = board.length; // assumes square board
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				char ch = board[row][col];
				int value = 0;
				switch (ch) {
					case ' ':
						value = 0 * factor;
						break;
					case 'o':
						value = 1 * factor;
						break;
					case 'x':
						value = 2 * factor;
					    break;
					default: // should not occur
						break;
				}
				sum += value;
				factor *= dimension;
			}
		}
		return sum;
	}
	
	public boolean hasWon(int board) {
		return winnerMap[board]; // assuming this array has been filled with proper values
	}
	public static void main(String[] args) {
		System.out.println("*** Test 16.4: Tic Tac Win\n");
		char[][] board = {{'x', 'o', 'x'},
						  {' ', ' ', ' '},
						  {' ', ' ', ' '}};
		test(board); // converted to "int" value should be 23 for the above board
	}
	
	private static void test(char[][] board) {
		int intValue = TicTacWin.convertBoardToInt(board);
		System.out.println("Board int value: " + intValue);
	}
}

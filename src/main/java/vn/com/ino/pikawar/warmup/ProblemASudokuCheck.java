package vn.com.ino.pikawar.warmup;

import java.util.HashSet;

public class ProblemASudokuCheck {
	private static final char NO_VALUE = '.';

	boolean sudokuChecking(char[][] board) {
		return isValidColumns(board) && isValidRows(board) && isValidCubes(board);
	}

	private boolean isValidRows(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			// for each row i create rows to check
			HashSet<Character> row = new HashSet<Character>();
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != NO_VALUE && !row.add(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidColumns(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			// for each column i, create hashset to check
			HashSet<Character> column = new HashSet<Character>();
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != NO_VALUE && !column.add(board[j][i])) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValidCubes(char[][] board) {
		for (int i = 0; i < board.length - 2; i += 3) {
			for (int j = 0; j < board.length - 2; j += 3) {

				HashSet<Character> cube = new HashSet<Character>();
				for (int k = 0; k < board.length; k++) {
					if (board[i + k % 3][j + k / 3] != NO_VALUE && !cube.add(board[i + k % 3][j + k / 3])) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

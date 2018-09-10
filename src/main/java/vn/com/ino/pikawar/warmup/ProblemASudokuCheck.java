package vn.com.ino.pikawar.warmup;

import java.util.HashSet;

/**
 * @author HieuNH5
 * 
 *         Sudoku is a number-placement puzzle. The objective is to fill a 9 Å~ 9
 *         grid with numbers in such a way that each column, each row, and each
 *         of the nine 3 Å~ 3 sub-grids that compose the grid all contain all of
 *         the numbers from 1 to 9 one time.
 * 
 *         Implement an algorithm that will check whether the given grid of
 *         numbers represents a valid Sudoku puzzle according to the layout
 *         rules described above. Note that the puzzle represented by grid does
 *         not have to be solvable.
 * 
 *         Example
 * 
 *         For grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'], ['.', '.',
 *         '6', '.', '.', '.', '.', '.', '.'], ['.', '.', '.', '.', '.', '.',
 *         '.', '.', '.'], ['.', '.', '1', '.', '.', '.', '.', '.', '.'], ['.',
 *         '6', '7', '.', '.', '.', '.', '.', '9'], ['.', '.', '.', '.', '.',
 *         '.', '8', '1', '.'], ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
 *         ['.', '.', '.', '.', '.', '7', '.', '.', '.'], ['.', '.', '.', '5',
 *         '.', '.', '.', '7', '.']]
 * 
 *         the output should be sudoku2(grid) = true;
 * 
 *         For grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'], ['.', '.',
 *         '.', '.', '6', '.', '.', '.', '.'], ['7', '1', '.', '.', '7', '5',
 *         '.', '.', '.'], ['.', '7', '.', '.', '.', '.', '.', '.', '.'], ['.',
 *         '.', '.', '.', '8', '3', '.', '.', '.'], ['.', '.', '8', '.', '.',
 *         '7', '.', '6', '.'], ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
 *         ['.', '1', '.', '2', '.', '.', '.', '.', '.'], ['.', '2', '.', '.',
 *         '3', '.', '.', '.', '.']]
 * 
 *         the output should be sudoku2(grid) = false. The given grid is not
 *         correct because there are two 1s in the second column. Each column,
 *         each row, and each 3 Å~ 3 subgrid can only contain the numbers 1
 *         through 9 one time.
 * 
 *         Input/Output
 * 
 *         [execution time limit] 0.5 seconds (cpp) [input] array.array.char
 *         grid A 9 Å~ 9 array of characters, in which each character is either a
 *         digit from '1' to '9' or a period '.'. [output] boolean Return true
 *         if grid represents a valid Sudoku puzzle, otherwise return false.
 *
 */
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

package vn.com.ino.pikawar.warmup;

public class SudokuSolver {

	public int[][] solve(int[][] board) {
		// use backtrack

		return board;
	}

	public int[][] solveBackTrack(int[][] board, int x, int y) {
		int[][] solveBoard = board;
		if (y == 9) {
			if (x == 8) {
				return solveBoard;
			} else {
				return solveBackTrack(solveBoard, x + 1, 0);
			}
		} else if (solveBoard[x][y] == 0) {
			for (int k = 1; k <= 9; k++) {
				if (isValidSudoku(solveBoard, x, y, k)) {
					solveBoard[x][y] = k;
					return solveBackTrack(board, x, y + 1);
				}
			}
		} else {
			return solveBackTrack(board, x, y + 1);
		}

		return solveBoard;
	}

	/**
	 * @param board
	 * @param x
	 *            column
	 * @param y
	 *            row
	 * @param k
	 *            value need to check
	 * @return
	 */
	boolean isValidSudoku(int[][] board, int x, int y, int k) {
		for (int i = 0; i < 9; i++) {
			if (board[x][i] == k) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][y] == k)
				return false;
		}
		int a = x / 3, b = y / 3;
		for (int i = 3 * a; i < 3 * a + 3; i++) {
			for (int j = 3 * b; j < 3 * b + 3; j++) {
				if (board[i][j] == k)
					return false;
			}
		}
		return true;
	}

}

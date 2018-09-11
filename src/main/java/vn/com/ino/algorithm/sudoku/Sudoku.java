package vn.com.ino.algorithm.sudoku;

public class Sudoku {

	private int[][] board;

	public static final int BOARD_SIZE = 9;
	public static final int EMPTY_CELL = 0;

	public void setBoard(int board[][]) {
		this.board = board;
	}

	public int[][] getBoard() {
		return this.board;
	}

	private boolean isInRow(int row, int number) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (this.board[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isInColumn(int column, int number) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (this.board[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isInBox(int row, int column, int number) {
		int boxRow = row / 3;
		int boxColumn = column / 3;
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[3 * boxRow + i % 3][3 * boxColumn + i / 3] == number) {
				return true;
			}
		}
		return false;
	}

	private boolean isOk(int row, int column, int number) {
		return !isInRow(row, number) && !isInColumn(column, number) && !isInBox(row, column, number);
	}

	public boolean solve() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (this.board[row][col] == EMPTY_CELL) {
					// check each value for value
					for (int number = 1; number <= BOARD_SIZE; number++) {
						if (isOk(row, col, number)) {
							board[row][col] = number;
							if (solve()) {
								return true;
							} else {
								board[row][col] = EMPTY_CELL;
							}
						}

					}
					return false;
				}
			}
		}
		return true;
	}

	public void display() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(" " + this.board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}

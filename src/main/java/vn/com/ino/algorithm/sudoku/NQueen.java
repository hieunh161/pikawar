package vn.com.ino.algorithm.sudoku;

import java.util.Arrays;

public class NQueen {

	// private static final int VALUE = 1;
	// private static final int EMPTY = 0;
	private int size;
	private int[][] board;

	public NQueen(int size) {
		this.size = size;
		this.board = new int[size][size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(this.board[i], 0);
		}
	}

	public boolean test(int index) {
		// check if end test return OK
		// find next index
		// assign sth
		// test(nextIndex)
		// reset sth
		return false;
	}

	public int place(int row, int count) {
		if (row == size) {
			for (int[] r : this.board) {
				for (int c : r)
					System.out.print(c + " ");
				System.out.println("");
			}
			System.out.println("================\n");
			return ++count;
		}
		for (int i = 0; i < size; i++)
			if (isSafe(row, i)) {
				this.board[row][i] = 1;
				count = place(row + 1, count);
				this.board[row][i] = 0;
			}
		return count;
	}

	private boolean isSafe(int row, int col) {
		// check row
		for (int i = 0; i < this.size; i++) {
			if (i != col && this.board[row][i] == 1) {
				return false;
			}
		}
		// check col
		for (int i = 0; i < this.size; i++) {
			if (i != row && this.board[i][col] == 1) {
				return false;
			}
		}
		// check cross
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (Math.abs(i - row) == Math.abs(j - col) && this.board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	public void display() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (col != size - 1) {
					System.out.print(this.board[row][col] + " ");
				} else {
					System.out.println(this.board[row][col]);
				}
			}
		}
	}
}

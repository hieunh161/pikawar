package vn.com.ino.algorithm.sudoku;

import org.junit.Test;

public class NQueenTest {

	private final NQueen nQueen = new NQueen(5);

	@Test
	public void shouldPassTestCase() {
		System.out.println(nQueen.place(0, 0));
	}
}

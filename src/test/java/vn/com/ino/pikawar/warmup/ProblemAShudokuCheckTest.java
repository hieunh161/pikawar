package vn.com.ino.pikawar.warmup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemAShudokuCheckTest {
	private final ProblemASudokuCheck sudokuChecker = new ProblemASudokuCheck();

	@Test
	public void shouldBePassTestCase1() {
		char[][] board = new char[][] { { '.', '.', '.', '1', '4', '.', '.', '2', '.' },
				{ '.', '.', '6', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '1', '.', '.', '.', '.', '.', '.' }, { '.', '6', '7', '.', '.', '.', '.', '.', '9' },
				{ '.', '.', '.', '.', '.', '.', '8', '1', '.' }, { '.', '3', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '.', '.', '7', '.', '.', '.' }, { '.', '.', '.', '5', '.', '.', '.', '7', '.' } };
		boolean found = sudokuChecker.sudokuChecking(board);
		assertThat(found, equalTo(true));
	}

	@Test
	public void shouldBePassTestCase2() {
		char[][] board = new char[][] { { '.', '.', '.', '.', '2', '.', '.', '9', '.' },
				{ '.', '.', '.', '.', '6', '.', '.', '.', '.' }, { '7', '1', '.', '.', '7', '5', '.', '.', '.' },
				{ '.', '7', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '8', '3', '.', '.', '.' },
				{ '.', '.', '8', '.', '.', '7', '.', '6', '.' }, { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
				{ '.', '1', '.', '2', '.', '.', '.', '.', '.' }, { '.', '2', '.', '.', '3', '.', '.', '.', '.' } };
		boolean found = sudokuChecker.sudokuChecking(board);
		assertThat(found, equalTo(false));
	}

	@Test
	public void shouldBePassTestCase3() {
		char[][] board = new char[][] { { '.', '.', '4', '.', '.', '.', '6', '3', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '5', '.', '.', '.', '.', '.', '.', '9', '.' },
				{ '.', '.', '.', '5', '6', '.', '.', '.', '.' }, { '4', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '7', '.', '.', '.', '.', '.' }, { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		boolean found = sudokuChecker.sudokuChecking(board);
		assertThat(found, equalTo(false));
	}

	@Test
	public void shouldBePassTestCase4() {
		char[][] board = new char[][] { { '.', '.', '.', '.', '.', '.', '.', '.', '2' },
				{ '.', '.', '.', '.', '.', '.', '6', '.', '.' }, { '.', '.', '1', '4', '.', '.', '8', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '3', '.', '.', '.', '.' }, { '5', '.', '8', '6', '.', '.', '.', '.', '.' },
				{ '.', '9', '.', '.', '.', '.', '4', '.', '.' }, { '.', '.', '.', '.', '5', '.', '.', '.', '.' } };
		boolean found = sudokuChecker.sudokuChecking(board);
		assertThat(found, equalTo(true));
	}

	@Test
	public void shouldBePassTestCase5() {
		char[][] board = new char[][] { { '.', '9', '.', '.', '4', '.', '.', '.', '.' },
				{ '1', '.', '.', '.', '.', '.', '6', '.', '.' }, { '.', '.', '3', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
				{ '3', '.', '.', '.', '5', '.', '.', '.', '.' }, { '.', '.', '7', '.', '.', '4', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '7', '.', '.', '.', '.' } };
		boolean found = sudokuChecker.sudokuChecking(board);
		assertThat(found, equalTo(true));
	}
}

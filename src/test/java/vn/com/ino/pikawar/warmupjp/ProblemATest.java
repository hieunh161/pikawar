package vn.com.ino.pikawar.warmupjp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemATest {
	ProblemA problemA = new ProblemA();

	@Test
	public void shouldBePassTestCase1() {
		String[] result = problemA.mostCommonWords("He is a pupil", 1);

		assertThat(result, equalTo(new String[] { "a" }));
	}

	@Test
	public void shouldBePassTestCase2() {
		String[] result = problemA.mostCommonWords("He is a pupil", 5);

		assertThat(result, equalTo(new String[] { "a", "he", "is", "pupil", "" }));
	}

	@Test
	public void shouldBePassTestCase3() {
		String[] result = problemA.mostCommonWords("He is a pupil, and she is a student", 2);

		assertThat(result, equalTo(new String[] { "a", "is" }));
	}

	@Test
	public void shouldBePassTestCase4() {
		String[] result = problemA.mostCommonWords("He is a pupil, and she is a student ", 3);

		assertThat(result, equalTo(new String[] { "a", "is", "and" }));
	}
}

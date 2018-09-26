package vn.com.ino.pikawar.warmupjp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemBTest {
	ProblemB problemB = new ProblemB();

	@Test
	public void shouldBePassTestCase1() {
		int result = problemB.numOfDivisors(1);

		assertThat(result, equalTo(1));
	}

	@Test
	public void shouldBePassTestCase2() {
		int result = problemB.numOfDivisors(2);

		assertThat(result, equalTo(2));
	}

	@Test
	public void shouldBePassTestCase3() {
		int result = problemB.numOfDivisors(8);

		assertThat(result, equalTo(4));
	}
	
	@Test
	public void shouldBePassTestCase4() {
		int result = problemB.numOfDivisors(10);

		assertThat(result, equalTo(4));
	}
	
	@Test
	public void shouldBePassTestCase5() {
		int result = problemB.numOfDivisors(100);

		assertThat(result, equalTo(9));
	}
}

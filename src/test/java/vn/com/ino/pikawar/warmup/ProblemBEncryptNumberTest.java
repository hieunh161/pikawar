package vn.com.ino.pikawar.warmup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemBEncryptNumberTest {
	private final ProblemBEncryptNumber encrypNumber = new ProblemBEncryptNumber();

	@Test
	public void shouldBePassTestCase1() {
		assertThat(encrypNumber.solve("123"), equalTo(3));
	}

	@Test
	public void shouldBePassTestCase2() {
		assertThat(encrypNumber.solve("12"), equalTo(2));
	}

	@Test
	public void shouldBePassTestCase3() {
		assertThat(encrypNumber.solve("0"), equalTo(0));
	}

	@Test
	public void shouldBePassTestCase4() {
		assertThat(encrypNumber.solve("1"), equalTo(1));
	}

	@Test
	public void shouldBePassTestCase5() {
		assertThat(encrypNumber.solve("301"), equalTo(0));
	}
}

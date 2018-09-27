package vn.com.ino.pikawar.warmup;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemCNumber2WordTest {
	private final ProblemCNumber2Word number2Word = new ProblemCNumber2Word();

	@Test
	public void shouldBePassTestCase1() {
		assertThat(number2Word.convert("0"), equalTo("khong"));
	}

	@Test
	public void shouldBePassTestCase2() {
		assertThat(number2Word.convert("4"), equalTo("bon"));
	}

	@Test
	public void shouldBePassTestCase3() {
		assertThat(number2Word.convert("5"), equalTo("nam"));
		assertThat(number2Word.convert("15"), equalTo("muoi lam"));
		assertThat(number2Word.convert("25"), equalTo("hai muoi lam"));
		assertThat(number2Word.convert("115"), equalTo("mot tram muoi lam"));
		assertThat(number2Word.convert("225"), equalTo("hai tram hai muoi lam"));
		assertThat(number2Word.convert("205"), equalTo("hai tram le nam"));
	}

	@Test
	public void shouldBePassTestCase4() {
		assertThat(number2Word.convert("10"), equalTo("muoi"));
	}

	@Test
	public void shouldBePassTestCase5() {
		assertThat(number2Word.convert("14"), equalTo("muoi bon"));
	}

	@Test
	public void shouldBePassTestCase6() {
		assertThat(number2Word.convert("15"), equalTo("muoi lam"));
	}

	@Test
	public void shouldBePassTestCase7() {
		assertThat(number2Word.convert("12345"), equalTo("muoi hai ngan ba tram bon muoi lam"));
	}
}

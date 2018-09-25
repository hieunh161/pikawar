package vn.com.ino.pikawar.round1;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class ProblemGTest {

	ProblemG dijkstra = new ProblemG();

	@Test
	public void shouldBePassTestCase1() {
		String result = dijkstra.travelPath("Bac Giang", "Ha Noi",
				new String[][] { { "Bac Giang", "Bac Ninh", "9000" }, { "Bac Giang", "Ha Noi", "2000" } });

		assertThat(result, equalTo("Bac Giang;Ha Noi"));
	}

	@Test
	public void shouldBePassTestCase2() {
		String result = dijkstra.travelPath("Bac Giang", "Ha Noi", new String[][] { { "Bac Giang", "Bac Ninh", "9000" },
				{ "Bac Giang", "Ha Noi", "50000" }, { "Bac Ninh", "Ha Noi", "10000" } });

		assertThat(result, equalTo("Bac Giang;Bac Ninh;Ha Noi"));
	}

	@Test
	public void shouldBePassTestCase3() {
		String result = dijkstra.travelPath("Bac Giang", "Ha Noi",
				new String[][] { { "Bac Giang", "Thai Nguyen", "9000" }, { "Bac Giang", "Bac Ninh", "9000" },
						{ "Bac Giang", "Ha Noi", "50000" }, { "Bac Ninh", "Ha Noi", "10000" },
						{ "Thai Nguyen", "Ha Noi", "10000" } });

		assertThat(result, equalTo("Bac Giang;Bac Ninh;Ha Noi"));
	}

	@Test
	public void shouldBePassTestCase4() {
		String result = dijkstra.travelPath("Ha Noi", "Hai Phong",
				new String[][] { { "Ha Noi", "Hung Yen", "9000" }, { "Hung Yen", "Hai Phong", "50000" },
						{ "Bac Giang", "Ha Noi", "50000" }, { "Ha Noi", "Bac Ninh", "10000" },
						{ "Thai Nguyen", "Ha Noi", "10000" }, { "Ha Noi", "Hai Phong", "110000" },
						{ "Bac Ninh", "Hai Phong", "80000" } });

		assertThat(result, equalTo("Ha Noi;Hung Yen;Hai Phong"));
	}

	@Test
	public void shouldBePassTestCase5() {
		String result = dijkstra.travelPath("Ha Noi", "Hai Phong",
				new String[][] { { "Ha Noi", "Hung Yen", "40000" }, { "Hung Yen", "Hai Phong", "50000" },
						{ "Bac Giang", "Ha Noi", "50000" }, { "Ha Noi", "Bac Ninh", "10000" },
						{ "Thai Nguyen", "Ha Noi", "10000" }, { "Ha Noi", "Hai Phong", "110000" },
						{ "Bac Ninh", "Hai Phong", "80000" } });

		assertThat(result, equalTo("Ha Noi;Bac Ninh;Hai Phong"));
	}

	@Test
	public void shouldBePassTestCase6() {
		String result = dijkstra.travelPath("Ha Noi", "Hai Phong",
				new String[][] { { "Ha Noi", "Hung Yen", "9000" }, { "Ha Noi", "Bac Ninh", "10000" },
						{ "Thai Nguyen", "Ha Noi", "10000" }, { "Ha Noi", "Hai Phong", "110000" },
						{ "Bac Ninh", "Hai Phong", "80000" } });

		assertThat(result, equalTo("Ha Noi;Bac Ninh;Hai Phong"));
	}
}

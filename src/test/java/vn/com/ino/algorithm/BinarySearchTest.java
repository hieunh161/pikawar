package vn.com.ino.algorithm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void shouldBeFound() {
		// just generate data
		Random r = new Random();
		int size = 100;
		int maxElement = 100000;
		Integer[] integers = Stream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray(Integer[]::new);
		// the element that should be found
		Integer shouldBeFound = integers[r.nextInt(size - 1)];
		BinarySearch search = new BinarySearch();
		// running time check
		double startTime = System.currentTimeMillis();
		int atIndex = search.find(integers, shouldBeFound);
		double endTime = System.currentTimeMillis();
		System.out.println(
				String.format("Should be found: %d. Found %d at index %d. An array length %d. Running time %f (ms)",
						shouldBeFound, integers[atIndex], atIndex, size, endTime - startTime));
		assertThat(atIndex, greaterThan(-1));
		int toCheck = Arrays.binarySearch(integers, shouldBeFound);
		assertThat(atIndex, equalTo(toCheck));
	}

}

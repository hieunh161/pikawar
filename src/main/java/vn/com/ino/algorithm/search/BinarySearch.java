package vn.com.ino.algorithm.search;

/**
 *
 *
 *
 * Binary search is one of the most popular algorithms The algorithm finds the
 * position of a target value within a sorted array
 *
 * Worst-case performance O(log n) Best-case performance O(1) Average
 * performance O(log n) Worst-case space complexity O(1)
 *
 *
 * @author Varun Upadhyay (https://github.com/varunu28)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 *
 * @see SearchAlgorithm
 * @see IterativeBinarySearch
 *
 */

public class BinarySearch implements SearchAlgorithm {
	@Override
	public <T extends Comparable<T>> int find(T array[], T key) {
		return search(array, key, 0, array.length);
	}

	/**
	 * This method implements the Generic Binary Search
	 *
	 * @param array
	 *            The array to make the binary search
	 * @param key
	 *            The number you are looking for
	 * @param left
	 *            The lower bound
	 * @param right
	 *            The upper bound
	 * @return the location of the key
	 **/
	private <T extends Comparable<T>> int search(T array[], T key, int left, int right) {
		if (right < left)
			return -1; // this means that the key not found

		// find median
		int median = (left + right) >>> 1;
		int comp = key.compareTo(array[median]);

		if (comp < 0) {
			return search(array, key, left, median - 1);
		}

		if (comp > 0) {
			return search(array, key, median + 1, right);
		}

		return median;
	}

}

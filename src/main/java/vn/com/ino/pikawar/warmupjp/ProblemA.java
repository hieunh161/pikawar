package vn.com.ino.pikawar.warmupjp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProblemA {
	String[] mostCommonWords(String text, int n) {
		String[] output = new String[n];
		Arrays.fill(output, "");
		String[] w = text.toLowerCase().split("[^a-zA-Z]+");
		class Word implements Comparable<Word> {
			String word;
			int count;

			public Word(int count, String word) {
				this.count = count;
				this.word = word;
			}

			public int compareTo(Word other) {
				if (this.count == other.count) {
					return this.word.compareTo(other.word);
				}
				return other.count - this.count;
			}

			public boolean equals(Object other) {
				if (other == null || this.getClass() != other.getClass())
					return false;
				return this.word.equals(((Word) other).word);
			}
		}
		List<Word> list = new ArrayList<>();
		for (String wordStr : w) {
			Word word = new Word(1, wordStr);
			int index = list.indexOf(word);
			if (index != -1) {
				list.get(index).count++;
			} else
				list.add(word);
		}
		Collections.sort(list);
		int index = 0, count = 0;
		while (count < n && index < list.size()) {
			output[count++] = list.get(index++).word;
		}
		return output;
	}
}

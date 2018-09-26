package vn.com.ino.pikawar.warmupjp;

public class ProblemB {
	int numOfDivisors(long n) {
		int count = 0;
		int a = (int) Math.sqrt(n);
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0)
				count += 2;
		}
		if (n == a * a)
			count++;
		return count;
	}

}

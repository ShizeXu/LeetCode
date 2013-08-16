package LeetCode;

/*[(m-1)+(n-1)]!/[(m-1)!*(n-1)!]，偏不用DP...*/

public class n061_UniquePaths {
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m < 2 || n < 2)
			return 1;
		int a = Math.max(--m, --n);
		int b = Math.min(m, n);
		double res = 1;
		for (int i = a + b; i > a; i--) {
			res *= i;
			res /= (i - a);
		}
		return (int) Math.round(res);
	}
}

package LeetCode;

/*[(m-1)+(n-1)]!/(m!*n!)£¬Æ«²»ÓÃDP...*/

public class n061_UniquePaths {
	public int uniquePaths(int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m < 2 || n < 2)
			return 1;
		m--;
		n--;
		double res = 1;
		for (int i = m + n; i > m; i--) {
			res *= i;
			res /= (i - m);
		}
		long resres = Math.round(res);
		return (int) resres;
	}
}
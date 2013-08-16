package LeetCode;

public class n070_ClimbingStairs {
	/* Fibonacci Array, O(logN) solution */
	int[][] calMatrix(int[][] a, int[][] b) {
		int[][] res = new int[2][2];
		res[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		res[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		res[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		res[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
		return res;
	}

	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] res = { { 1, 0 }, { 0, 1 } };
		int[][] fact = { { 1, 1 }, { 1, 0 } };
		while (n > 0) {
			if ((n ^ (n - 1)) == 1)
				res = calMatrix(res, fact);
			fact = calMatrix(fact, fact);
			n >>= 1;
		}
		return res[0][0];
	}

	/* Original O(n) solution */
	public int climbStairsWithDP(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] res = new int[n];
		res[n - 1] = 1;
		res[n - 2] = 2;
		for (int i = n - 3; i >= 0; i--) {
			res[i] = res[i + 1] + res[i + 2];
		}
		return res[0];
	}
}

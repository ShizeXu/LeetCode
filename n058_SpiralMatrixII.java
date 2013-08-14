package LeetCode;

public class n058_SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] res = new int[n][];
		int i = 0, j = 0;
		for (i = 0; i < n; i++)
			res[i] = new int[n];
		int round = (n + 1) / 2;
		int k = 1;
		for (i = 0; i < round; i++) {
			// FULL
			for (j = i; j <= n - i - 1; j++) {
				res[i][j] = k++;
			}
			// PART
			for (j = i + 1; j < n - i - 1; j++) {
				res[j][n - i - 1] = k++;
			}
			if (n - i - 1 > i) {
				// FULL
				for (j = n - i - 1; j >= i; j--) {
					res[n - i - 1][j] = k++;
				}
				// PART
				for (j = n - i - 2; j > i; j--) {
					res[j][i] = k++;
				}
			}
		}
		return res;
	}
}
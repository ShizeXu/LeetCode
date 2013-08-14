package LeetCode;

public class n063_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		if (n == 0)
			return 0;
		int[][] res = new int[m][];
		int i = 0, j = 0;
		for (i = 0; i < m; i++)
			res[i] = new int[n];
		res[m - 1][n - 1] = grid[m - 1][n - 1];
		for (i = m - 2; i >= 0; i--)
			res[i][n - 1] = res[i + 1][n - 1] + grid[i][n - 1];
		for (i = n - 2; i >= 0; i--)
			res[m - 1][i] = res[m - 1][i + 1] + grid[m - 1][i];
		for (i = m - 2; i >= 0; i--) {
			for (j = n - 2; j >= 0; j--) {
				res[i][j] = grid[i][j] + Math.min(res[i + 1][j], res[i][j + 1]);
			}
		}
		return res[0][0];
	}
}
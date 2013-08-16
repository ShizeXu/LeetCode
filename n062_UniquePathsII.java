package LeetCode;

public class n062_UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		if (n == 0 || obstacleGrid[m - 1][n - 1] == 1)
			return 0; // 终点是障碍的情况
		int[][] res = new int[m][];
		int i = 0, j = 0;
		for (i = 0; i < m; i++)
			res[i] = new int[n];
		res[m - 1][n - 1] = 1;
		for (i = m - 2; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] == 0)
				res[i][n - 1] = 1;
			else
				break;
		}
		for (i = n - 2; i >= 0; i--) {
			if (obstacleGrid[m - 1][i] == 0)
				res[m - 1][i] = 1;
			else
				break;
		}
		for (i = m - 2; i >= 0; i--) {
			for (j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1)
					res[i][j] = 0;
				else {
					res[i][j] = res[i + 1][j] + res[i][j + 1];
				}
			}
		}
		return res[0][0];
	}
}

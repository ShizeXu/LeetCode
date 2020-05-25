package LeetCode;

public class n072_EditDistance {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = word1.length();
		int n = word2.length();
		int[][] res = new int[m + 1][];
		int i = 0, j = 0;
		for (i = 0; i < m + 1; i++)
			res[i] = new int[n + 1];
		for (i = 0; i < m + 1; i++)
			res[i][n] = m - i;
		for (i = 0; i < n + 1; i++)
			res[m][i] = n - i;
		for (i = m - 1; i >= 0; i--) {
			for (j = n - 1; j >= 0; j--) {
				if (word1.charAt(i) == word2.charAt(j))
					res[i][j] = res[i + 1][j + 1];
				else {
					int tmp = Math.min(res[i + 1][j], res[i + 1][j + 1]);
					res[i][j] = 1 + Math.min(tmp, res[i][j + 1]);
				}
			}
		}
		return res[0][0];
	}
}

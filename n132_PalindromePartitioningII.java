package LeetCode;

public class n132_PalindromePartitioningII {
	public int minCut(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s.length();
		if (n <= 1)
			return 0;
		boolean[][] res = new boolean[n][n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++)
			res[i][i] = true; // 第一层初始化
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = i; j >= 0; j--) {
				if (s.charAt(j) == s.charAt(i) && (i - j < 2 || res[i - 1][j + 1])) { // key
																						// condition
					res[i][j] = true;
					if (j == 0)
						min = 0;
					else
						min = Math.min(min, 1 + dp[j - 1]);
				}
			}
			dp[i] = min;
		}
		return dp[n - 1];
	}
}

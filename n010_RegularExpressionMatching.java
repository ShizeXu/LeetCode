package LeetCode;

public class n010_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dp = new int[s.length() + 1][p.length()];
		return isMatch(s, p, dp, 0, 0);
	}

	boolean isMatch(String s, String p, int[][] dp, int i, int j) {
		int m = s.length();
		int n = p.length();
		if (j == n && i == m)
			return true;
		if (j == n || i > m)
			return false;
		if (dp[i][j] != 0)
			return dp[i][j] > 0 ? true : false;
		boolean res = false;
		char y = p.charAt(j);
		if (j + 1 == n || p.charAt(j + 1) != '*') {
			if (i == m) {
				dp[i][j] = -1;
				return false;
			}
			res = (s.charAt(i) == y || y == '.') && isMatch(s, p, dp, i + 1,
					j + 1);
		} else {
			int k = i;
			do {
				res = isMatch(s, p, dp, k, j + 2);
				if (res)
					break;
			} while (k < m && (s.charAt(k++) == y || y == '.'));
		}
		if (res) {
			dp[i][j] = 1;
			return true;
		} else {
			dp[i][j] = -1;
			return false;
		}
	}
}
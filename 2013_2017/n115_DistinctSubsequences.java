package LeetCode;

public class n115_DistinctSubsequences {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = S.length();
		int n = T.length();
		if (n == 0 || m < n)
			return 0;
		int[][] res = new int[n + 1][m + 1];
		for (int i = m; i >= 0; i--)
			res[n][i] = 1; // 额外初始化一层，方便统一处理
		for (int i = n - 1; i >= 0; i--) { // 每次往前多匹配 T 的一个字符
			char x = T.charAt(i);
			for (int j = m + i - n; j >= 0; j--) {
				res[i][j] = res[i][j + 1];
				if (S.charAt(j) == x) {
					res[i][j] += res[i + 1][j + 1]; // 能增加这么多种可能
				}
			}
		}
		return res[0][0];
	}
}

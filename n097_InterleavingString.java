package LeetCode;

public class n097_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = s1.length();
		int n = s2.length();
		if (m + n != s3.length())
			return false;
		boolean[][] res = new boolean[m + 1][n + 1];
		res[m][n] = true;
		for (int i = m - 1; i >= 0; i--) {
			res[i][n] = (res[i + 1][n] && s1.charAt(i) == s3.charAt(n + i));
		}
		for (int i = n - 1; i >= 0; i--) {
			res[m][i] = (res[m][i + 1] && s2.charAt(i) == s3.charAt(m + i));
		}
		// 每一个点依赖于右边和下面的点
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				res[i][j] = (res[i + 1][j] && s1.charAt(i) == s3.charAt(i + j)) || (res[i][j + 1] && s2
						.charAt(j) == s3.charAt(i + j));
			}
		}
		return res[0][0];
	}
}

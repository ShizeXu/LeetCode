package LeetCode;

import java.util.ArrayList;

public class n131_PalindromePartitioning {
	void join(ArrayList<ArrayList<String>> resArr, boolean[][] res,
			ArrayList<String> tmp, int begin, String s) {
		int n = s.length();
		if (begin == n) {
			resArr.add((ArrayList<String>) tmp.clone());
			return;
		}
		for (int i = begin; i < n; i++) {
			if (res[begin][i]) {
				tmp.add(s.substring(begin, i + 1));
				join(resArr, res, tmp, i + 1, s);
				tmp.remove(tmp.size() - 1);
			}
		}
		return;
	}

	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<String>> resArr = new ArrayList<ArrayList<String>>();
		int n = s.length();
		if (n == 0)
			return resArr;
		boolean[][] res = new boolean[n][n];
		for (int i = 0; i < n; i++)
			res[i][i] = true; // 第一层初始化
		for (int i = 0; i < n - 1; i++)
			res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)); // 第二层初始化
		for (int k = 2; k < n; k++) {
			for (int i = 0; i < n - k; i++) {
				res[i][i + k] = (s.charAt(i) == s.charAt(i + k) && res[i + 1][i + k
						- 1]); // 递推公式
			}
		}
		ArrayList<String> tmp = new ArrayList<String>();
		join(resArr, res, tmp, 0, s); // 拼接结果
		return resArr;
	}
}
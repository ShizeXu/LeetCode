package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class n131_PalindromePartitioning {
	// 不DP不舒服斯基
	ArrayList<Stack<String>> join(boolean[][] res, int begin, String s,
			HashMap<Integer, ArrayList<Stack<String>>> dp) {
		int n = s.length();
		ArrayList<Stack<String>> resArr = new ArrayList<Stack<String>>();
		if (begin == n) {
			resArr.add(new Stack<String>());
			return resArr;
		}
		if (dp.containsKey(begin))
			return dp.get(begin);
		for (int i = begin; i < n; i++) {
			if (res[begin][i]) {
				ArrayList<Stack<String>> arr = join(res, i + 1, s, dp);
				String str = s.substring(begin, i + 1);
				for (Stack<String> sta : arr) {
					Stack<String> tmp = (Stack<String>) sta.clone();
					tmp.push(str);
					resArr.add(tmp);
				}
			}
		}
		dp.put(begin, resArr);
		return resArr;
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
		HashMap<Integer, ArrayList<Stack<String>>> dp = new HashMap<Integer, ArrayList<Stack<String>>>();
		ArrayList<Stack<String>> resSta = join(res, 0, s, dp); // 拼接结果
		for (Stack<String> sta : resSta) {
			ArrayList<String> arr = new ArrayList<String>();
			while (!sta.isEmpty()) {
				arr.add(sta.pop());
			}
			resArr.add(arr);
		}
		return resArr;
	}
}

package LeetCode;

import java.util.ArrayList;

public class n021_GenerateParentheses {
	ArrayList<String> subGeneration(int have, int l, int r) {
		ArrayList<String> res = new ArrayList<String>();
		if (l == 0 && r == 0) {
			res.add("");
			return res;
		}
		if (l > 0) {
			ArrayList<String> tmp = subGeneration(have + 1, l - 1, r);
			int len = tmp.size();
			for (int i = 0; i < len; i++) {
				res.add("(" + tmp.get(i));
			}
		}
		if (have > 0 && r > 0) {
			ArrayList<String> tmp = subGeneration(have - 1, l, r - 1);
			int len = tmp.size();
			for (int i = 0; i < len; i++) {
				res.add(")" + tmp.get(i));
			}
		}
		return res;
	}

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return subGeneration(0, n, n);
	}
}
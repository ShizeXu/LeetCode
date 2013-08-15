package LeetCode;

import java.util.ArrayList;

public class n021_GenerateParentheses {
	void subGeneration(ArrayList<String> resArr, StringBuilder res, int l, int r) {
		if (l == 0 && r == 0) {
			resArr.add(res.toString());
			return;
		}
		if (l > 0) {
			res.append('(');
			subGeneration(resArr, res, l - 1, r);
			res.deleteCharAt(res.length() - 1);
		}
		if (r > l) {
			res.append(')');
			subGeneration(resArr, res, l, r - 1);
			res.deleteCharAt(res.length() - 1);
		}
	}

	public ArrayList<String> generateParenthesis(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> resArr = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		subGeneration(resArr, sb, n, n);
		return resArr;
	}
}
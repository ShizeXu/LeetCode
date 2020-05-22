package LeetCode;

import java.util.HashMap;

public class n010_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || p == null)
			return false;
		HashMap<String, Boolean> dp = new HashMap<String, Boolean>();
		return match(s, p, 0, 0, dp);
	}

	boolean match(String s, String p, int i, int j, HashMap<String, Boolean> dp) {
		if (j == p.length())
			return i == s.length();
		String str = String.valueOf(i) + "_" + String.valueOf(j);
		if (dp.containsKey(str))
			return dp.get(str);
		char x = p.charAt(j);
		if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
			int k = i;
			do {
				if (match(s, p, k, j + 2, dp))
					return true;
			} while (k < s.length() && (x == s.charAt(k++) || x == '.'));
		}
		if (i == s.length())
			return false;
		if ((s.charAt(i) == x || x == '.') && (match(s, p, i + 1, j + 1, dp))) {
			return true;
		}
		dp.put(str, false);
		return false;
	}
}

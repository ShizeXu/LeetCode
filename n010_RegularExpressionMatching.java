package LeetCode;

import java.util.HashMap;

public class n010_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<String, Boolean> mapDp = new HashMap<String, Boolean>();
		return isMatch(s, p, mapDp, 0, 0);
	}

	boolean isMatch(String s, String p, HashMap<String, Boolean> mapDp, int i,
			int j) {
		int m = s.length();
		int n = p.length();
		if (j == n && i == m)
			return true;
		if (j == n || i > m)
			return false;
		String str = String.valueOf(i) + "_" + String.valueOf(j);
		if (mapDp.containsKey(str))
			return mapDp.get(str);
		boolean res = false;
		char y = p.charAt(j);
		if (j + 1 == n || p.charAt(j + 1) != '*') {
			if (i == m) {
				mapDp.put(str, false);
				return false;
			}
			res = (s.charAt(i) == y || y == '.') && isMatch(s, p, mapDp, i + 1,
					j + 1);
		} else {
			int k = i;
			do {
				res = isMatch(s, p, mapDp, k, j + 2);
				if (res)
					break;
			} while (k < m && (s.charAt(k++) == y || y == '.'));
		}
		mapDp.put(str, res);
		return res;
	}
}

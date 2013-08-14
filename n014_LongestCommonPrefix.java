package LeetCode;

public class n014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuilder res = new StringBuilder();
		int n = strs.length;
		int len = strs[0].length();
		for (int i = 0; i < len; i++) {
			char tmp = strs[0].charAt(i);
			int j = 1;
			for (j = 1; j < n; j++) {
				if (i >= strs[j].length() || tmp != strs[j].charAt(i)) {
					break;
				}
			}
			if (j == n) {
				res.append(tmp);
			} else {
				break;
			}
		}
		return res.toString();
	}
}
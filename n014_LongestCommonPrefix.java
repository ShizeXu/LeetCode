package LeetCode;

public class n014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuilder sb = new StringBuilder();
		if (strs == null || strs.length == 0)
			return sb.toString();
		for (int i = 0; i < strs[0].length(); i++) {
			char x = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i >= strs[j].length() || strs[j].charAt(i) != x)
					return sb.toString();
			}
			sb.append(x);
		}
		return sb.toString();
	}
}

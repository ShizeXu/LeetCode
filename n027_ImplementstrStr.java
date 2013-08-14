package LeetCode;

public class n027_ImplementstrStr {
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = haystack.length();
		int n = needle.length();
		if (m < n)
			return null;
		for (int i = 0; i <= m - n; i++) {
			int j = 0;
			for (j = 0; j < n; j++) {
				if (haystack.charAt(j + i) != needle.charAt(j))
					break;
			}
			if (j == n) {
				return haystack.substring(i);
			}
		}
		return null;
	}
}
package LeetCode;

public class n027_ImplementstrStr {
	// KMP match, O(n)
	public String strStr(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = haystack.length();
		int n = needle.length();
		if (n == 0)
			return haystack;
		if (m == 0 || m < n)
			return null;

		int[] next = getNext(needle);
		int i = 0, j = 0;
		while (i < m) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++; // 与i一起递增
			} else {
				j = next[j]; // 递减，因此递减次数不会超过i的递增次数(m)，因此总代价也是2*m = O(m)
			}
			if (j == n)
				return haystack.substring(i - n);
		}
		return null;
	}

	int[] getNext(String needle) {
		int n = needle.length();
		int[] next = new int[n];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < n - 1) {
			if (j < 0 || needle.charAt(i) == needle.charAt(j)) {
				next[++i] = ++j; // 与i一起递增
			} else {
				j = next[j]; // 递减，因此递减次数不会超过i的递增次数(m)，因此总代价也是2*m = O(m)
			}
		}
		return next;
	}
}

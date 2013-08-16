package LeetCode;

public class n076_MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = T.length(), m = S.length();
		if (n < 1 || n > m)
			return "";
		int minVal = Integer.MAX_VALUE;
		int minIndex = -1;
		int[] need = new int[256];
		int[] has = new int[256];
		for (int i = 0; i < 256; i++) {
			need[i] = 0;
			has[i] = 0;
		}
		for (int i = 0; i < n; i++)
			need[T.charAt(i)]++;
		int end = 0, start = 0;
		int cnt = 0;
		for (end = 0; end < m; end++) { // O(m)
			char x = S.charAt(end);
			has[x]++;
			if (has[x] <= need[x])
				cnt++;
			if (need[x] > 0 && cnt == n) { // find a qualified window
				for (; start <= end; start++) { // minimize window size
					char y = S.charAt(start);
					if (has[y] > need[y])
						has[y]--;
					else
						break;
				}
				int tmp = end - start + 1;
				if (tmp < minVal) {
					minVal = tmp;
					minIndex = start;
				}
			}
		}
		if (minVal == Integer.MAX_VALUE)
			return "";
		return S.substring(minIndex, minIndex + minVal);
	}
}
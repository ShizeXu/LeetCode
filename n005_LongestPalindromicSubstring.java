package LeetCode;

public class n005_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int maxi = 0;
		int max = 0;
		StringBuilder sb = new StringBuilder();
		sb.append('\001');
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			sb.append('\001');
		}
		String ss = sb.toString();
		int n = ss.length();
		int[] res = new int[n];
		res[0] = 0;
		int far = 0;
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (far > i) {
				if (res[index * 2 - i] + i < far) {
					res[i] = res[index * 2 - i];
					continue;
				}
			}

			int j = far + 1;
			while (j < n && (i * 2 - j >= 0)
					&& ss.charAt(j) == ss.charAt(i * 2 - j)) {
				j++;
			}
			res[i] = j - i - 1;
			if (res[i] > max) {
				max = res[i];
				maxi = i;
			}
			far = j - 1;
			index = i;
		}
		sb = new StringBuilder();
		for (int i = maxi - max + 1; i <= maxi + max - 1; i += 2) {
			sb.append(ss.charAt(i));
		}
		return sb.toString();
	}
}

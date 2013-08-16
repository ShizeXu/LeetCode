package LeetCode;

public class n090_DecodeWays {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = s.length();
		if (n == 0)
			return 0;
		int[] res = new int[n + 1];
		res[n] = 1;
		res[n - 1] = (s.charAt(n - 1) == '0' ? 0 : 1);
		for (int i = n - 2; i >= 0; i--) {
			char x = s.charAt(i);
			if (x == '0') {
				res[i] = 0; // set 0 directly
			} else {
				res[i] = res[i + 1];
				if (x == '1' || (x == '2' && s.charAt(i + 1) <= '6')) {
					res[i] += res[i + 2];
				}
			}
		}
		return res[0];
	}
}
package LeetCode;

public class n006_ZigZagConversion {
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n;
		if (nRows == 1)
			n = 1;
		else
			n = 2 * nRows - 2;
		StringBuilder[] sb = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++)
			sb[i] = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int tmp = i % n;
			sb[Math.min(tmp, n - tmp)].append(s.charAt(i));
		}
		for (int i = 1; i < nRows; i++) {
			sb[0].append(sb[i]);
		}
		return sb[0].toString();
	}
}

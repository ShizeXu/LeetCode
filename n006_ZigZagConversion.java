package LeetCode;

public class n006_ZigZagConversion {
	public String convert(String s, int nRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if (len == 0)
			return "";
		if (nRows == 1)
			return s;
		int gap = 2 * nRows - 2;
		int m = len / gap;
		if (m * gap != len)
			m++;
		StringBuilder res = new StringBuilder();
		for (int j = 0; j < m; j++) {
			res.append(s.charAt(j * (gap)));
		}
		for (int i = 1; i < nRows - 1; i++) {
			for (int j = 0; j < m; j++) {
				if (j * gap + i < len) {
					res.append(s.charAt(j * gap + i));
					if ((j + 1) * gap - i < len) {
						res.append(s.charAt((j + 1) * gap - i));
					}
				}
			}
		}
		for (int j = 0; j < m; j++) {
			if (j * gap + nRows - 1 < len) {
				res.append(s.charAt(j * gap + nRows - 1));
			} else
				break;
		}
		return res.toString();
	}
}
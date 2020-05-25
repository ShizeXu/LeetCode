package LeetCode;

public class n013_RomantoInteger {
	public int romanToInt(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() < 1)
			return 0;
		int result = 0;
		int sub = getRomanValue(s.charAt(0));
		int lastv = sub;
		for (int i = 1; i < s.length(); ++i) {
			char curc = s.charAt(i);
			int curv = getRomanValue(curc);
			if (curv == lastv)
				sub += curv;
			else if (curv < lastv) {
				result += sub;
				sub = curv;
			} else {
				sub = curv - sub;
			}
			lastv = curv;
		}
		result += sub;
		return result;
	}

	public int getRomanValue(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}

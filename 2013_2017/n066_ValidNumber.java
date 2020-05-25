package LeetCode;

public class n066_ValidNumber {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s = s.trim();
		s = s.toLowerCase();
		if (s.equals(""))
			return false;
		char x = s.charAt(0);
		if (x == '-' || x == '+')
			s = s.substring(1);
		if (s.equals(""))
			return false;
		boolean eFlag = false, pFlag = false;
		x = s.charAt(0);
		int n = s.length();
		if (x == '.') {
			if (n < 2)
				return false;
			pFlag = true;
		} else if (x < '0' || x > '9')
			return false;
		for (int i = 1; i < n; i++) {
			x = s.charAt(i);
			if (x == 'e') {
				if (i == n - 1 || eFlag)
					return false;
				if (i == 1 && s.charAt(i - 1) == '.')
					return false;
				eFlag = true;
			} else if (x == '.') {
				if (eFlag || pFlag)
					return false;
				pFlag = true;
			} else if (x == '-' || x == '+') {
				if (s.charAt(i - 1) != 'e' || i == n - 1)
					return false;
			} else if (x > '9' || x < '0')
				return false;
		}
		return true;
	}
}

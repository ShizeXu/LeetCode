package LeetCode;

public class n008_StringtoInteger {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		double res = 0;
		str = str.trim();
		if (str.equals(""))
			return 0;
		char x = str.charAt(0);
		boolean flag = false;
		int i = 0;
		if (x == '-') {
			flag = true;
			i++;
		} else if (x == '+') {
			i++;
		}
		while (i < str.length()) {
			x = str.charAt(i++);
			if (x < '0' || x > '9')
				break;
			res = res * 10 + (x - '0');
			if (flag && res - 1 > Integer.MAX_VALUE)
				return Integer.MIN_VALUE;
			else if (!flag && res > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}
		return (int) (flag ? (0 - res) : res);
	}
}

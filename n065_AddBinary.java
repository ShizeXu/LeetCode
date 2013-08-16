package LeetCode;

public class n065_AddBinary {
	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		StringBuilder res = new StringBuilder();
		int m = a.length();
		int n = b.length();
		if (m == 0)
			return b;
		if (n == 0)
			return a;
		int add = 0;
		while (m > 0 && n > 0) {
			res.append((char) ('0' + add ^ (a.charAt(m - 1) - '0') ^ (b
					.charAt(n - 1) - '0')));
			int tmp = add + (a.charAt(--m) - '0') + (b.charAt(--n) - '0');
			add = (tmp > 1 ? 1 : 0);
		}
		while (m-- > 0) {
			int tmp = a.charAt(m) - '0' + add;
			add = (tmp > 1 ? 1 : 0);
			res.append(tmp == 1 ? '1' : '0');
		}
		while (n-- > 0) {
			int tmp = b.charAt(n) - '0' + add;
			add = (tmp > 1 ? 1 : 0);
			res.append(tmp == 1 ? '1' : '0');
		}
		if (add > 0)
			res.append('1');
		return res.reverse().toString();
	}
}

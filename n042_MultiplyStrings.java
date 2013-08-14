package LeetCode;

import java.util.ArrayList;

public class n042_MultiplyStrings {
	// 计算大数和四位数以内数的乘法
	public String subTask(String a, String b) {
		int n = a.length();
		int val = Integer.parseInt(b);
		ArrayList<Integer> aa = new ArrayList<Integer>();
		while (n > 4) {
			aa.add(Integer.parseInt(a.substring(n - 4)));
			a = a.substring(0, n - 4);
			n -= 4;
		}
		aa.add(Integer.parseInt(a));
		String res = "0";
		for (int i = 0; i < aa.size(); i++) {
			int tmp = val * aa.get(i);
			StringBuilder str = new StringBuilder();
			for (int j = 0; j < i * 4; j++) {
				str.append('0');
			}
			while (tmp > 0) {
				str.append((char) (tmp % 10 + '0'));
				tmp /= 10;
			}
			res = sumTask(str.reverse().toString(), res);
		}
		return res;
	}

	// 计算大数和大数的加法
	public String sumTask(String a, String b) {
		int add = 0;
		StringBuilder res = new StringBuilder();
		int m = a.length();
		int n = b.length();
		if (m < n) {
			String c = a;
			int p = m;
			a = b;
			b = c;
			m = n;
			n = p;
		}
		m--;
		n--;
		while (m >= 0) {
			int tmp = (int) (a.charAt(m) - '0') + add;
			add = 0;
			if (n >= 0)
				tmp += (int) (b.charAt(n) - '0');
			if (tmp > 9) {
				add++;
				tmp -= 10;
			}
			res.append((char) (tmp + '0'));
			m--;
			n--;
		}
		if (add > 0) {
			res.append('1');
		}
		return res.reverse().toString();
	}

	// 计算大数和大数的乘法
	public String multiply(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if ("0".equals(b) || "0".equals(a)) // 先排除，不然后面排除更麻烦
			return "0";
		int m = a.length();
		int n = b.length();
		if (m < n) {
			String c = a;
			int p = m;
			a = b;
			b = c;
			m = n;
			n = p;
		}
		int cnt = 0;
		String res = "0";
		while (n > 0) {
			String tmpRes = subTask(a, b.substring(Math.max(0, n - 4), n));
			n -= 4;
			for (int i = 0; i < cnt; i++)
				tmpRes += "0000";
			cnt++;
			res = sumTask(tmpRes, res);
		}
		return res;
	}
}
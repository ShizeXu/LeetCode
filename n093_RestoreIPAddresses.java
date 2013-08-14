package LeetCode;

import java.util.ArrayList;

public class n093_RestoreIPAddresses {
	void ipAddr(ArrayList<String> resArr, String res, String s, int num) {
		int n = s.length();
		int len = res.length();
		if (num == 5) {
			if (n == 0) {
				res = res.substring(0, len - 1); // 删除最后一个"."
				resArr.add(res);
			}
			return;
		}
		if (n == 0)
			return;
		char x = s.charAt(0);

		// one bit
		res += x + ".";
		ipAddr(resArr, res, s.substring(1), num + 1);
		res = res.substring(0, len);
		// two bit
		if (x != '0' && n >= 2) {
			res += s.substring(0, 2) + ".";
			ipAddr(resArr, res, s.substring(2), num + 1);
			res = res.substring(0, len);
			// three bit
			if (n >= 3) {
				if (x == '1' || (x == '2' && (s.charAt(1) < '5' || (s.charAt(1) == '5' && s
						.charAt(2) <= '5')))) {
					res += s.substring(0, 3) + ".";
					ipAddr(resArr, res, s.substring(3), num + 1);
					res = res.substring(0, len);
				}
			}
		}
	}

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> resArr = new ArrayList<String>();
		String res = "";
		ipAddr(resArr, res, s, 1);
		return resArr;
	}
}
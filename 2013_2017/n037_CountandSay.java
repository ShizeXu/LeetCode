package LeetCode;

public class n037_CountandSay {
	public String subCount(String root) {
		int n = root.length();
		StringBuilder sb = new StringBuilder();
		char prev = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			char cur = root.charAt(i);
			if (cur == prev)
				cnt++;
			else {
				if (prev != 0) { // 第一条是空
					StringBuilder tmp = new StringBuilder();
					while (cnt > 0) {
						tmp.append((char) (cnt % 10 + '0'));
						cnt = cnt / 10;
					}
					sb.append(tmp.reverse()); // 翻转
					sb.append(prev);
				}
				cnt = 1;
				prev = cur;
			}
		}
		if (prev != 0) { // 补漏
			StringBuilder tmp = new StringBuilder();
			while (cnt > 0) {
				tmp.append((char) (cnt % 10 + '0'));
				cnt = cnt / 10;
			}
			sb.append(tmp.reverse());
			sb.append(prev);
		}
		return sb.toString();
	}

	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String res = "1";
		for (int i = 0; i < n - 1; i++) {
			res = subCount(res);
		}
		return res;
	}
}

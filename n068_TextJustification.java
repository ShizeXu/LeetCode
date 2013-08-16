package LeetCode;

import java.util.ArrayList;

public class n068_TextJustification {
	public String justify(String[] w, int x, int y, int cnt, int L) {
		int n = w.length;
		String res = "";
		if (x == y || y == n - 1) { // left justify銆備袱涓潯浠讹細鍙湁涓�釜鍗曡瘝锛屾垨鑰呮渶鍚庝竴琛屻�
			res = w[x];
			for (int i = x + 1; i <= y; i++) {
				res += " " + w[i];
			}
			while (res.length() < L)
				res += " ";
			return res;
		}
		int gap = L - cnt;
		for (int i = y; i > x; i--) {
			int tmp = gap / (i - x); // 鑻ユ棤娉曞钩鍒嗗垯宸﹁竟姣斿彸杈瑰绌烘牸
			gap -= tmp;
			String tmpRes = " ";
			while (tmp > 0) {
				tmpRes += " ";
				tmp--;
			}
			tmpRes += w[i];
			res = tmpRes + res;
		}
		res = w[x] + res;
		return res;
	}

	public ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = words.length;
		ArrayList<String> res = new ArrayList<String>();
		if (n == 0)
			return res;
		int i = 0, j = 0;
		while (i < n) {
			int cnt = 0;
			for (j = i; j < n; j++) {
				if (cnt > 0) {
					if (cnt + words[j].length() + 1 > L)
						break;
					cnt++; // 娉ㄦ剰鏄笉break涓斾笉鏄涓�釜璇嶇殑鏃跺�鎵�+
				}
				cnt += words[j].length();
			}
			res.add(justify(words, i, j - 1, cnt, L)); // 璁板緱j-1
			i = j; // 涓嬩竴涓瓧绗�
		}
		return res;
	}
}

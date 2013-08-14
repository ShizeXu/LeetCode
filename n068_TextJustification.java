package LeetCode;

import java.util.ArrayList;

public class n068_TextJustification {
	public String justify(String[] w, int x, int y, int cnt, int L) {
		int n = w.length;
		String res = "";
		if (x == y || y == n - 1) { // left justify������������ֻ��һ�����ʣ��������һ�С�
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
			int tmp = gap / (i - x); // ���޷�ƽ������߱��ұ߶�ո�
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
					cnt++; // ע���ǲ�break�Ҳ��ǵ�һ���ʵ�ʱ���++
				}
				cnt += words[j].length();
			}
			res.add(justify(words, i, j - 1, cnt, L)); // �ǵ�j-1
			i = j; // ��һ���ַ�
		}
		return res;
	}
}
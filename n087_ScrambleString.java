package LeetCode;

public class n087_ScrambleString {
	int[][][] flag;

	public boolean scramble(String a, String b, int p, int q, int len) {
		if (flag[len][p][q] != 0)
			return (flag[len][p][q] == 1 ? true : false); // �Ѿ������
		if (a.substring(p, p + len + 1).equals(b.substring(q, q + len + 1))) { // �Ӵ����
			flag[len][p][q] = 1;
			return true;
		}
		for (int i = p + 1; i < p + len + 1; i++) { // i �ǵ�һ�����еڶ����Ӵ�����ʼλ��
			if (scramble(a, b, p, q, i - p - 1) && scramble(a, b, i, q + i - p,
					len - i + p)) { // ��Ӧƥ��
				flag[len][p][q] = 1;
				return true;
			}
			if (scramble(a, b, p, q + len - (i - p - 1), i - p - 1) && scramble(
					a, b, i, q, len - i + p)) { // ����ƥ��
				flag[len][p][q] = 1;
				return true;
			}
		}
		flag[len][p][q] = -1;
		return false;
	}

	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.equals(s2))
			return true;
		int n = s1.length();
		if (n == 1)
			return false;

		flag = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					flag[i][j][k] = 0;
				}
			}
		}
		return scramble(s1, s2, 0, 0, n - 1);
	}
}
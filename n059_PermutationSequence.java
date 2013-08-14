package LeetCode;

public class n059_PermutationSequence {
	public String getPermutation(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] fact = new int[8]; // �׳˱�
		int tmp = 1, i = 0;
		for (i = 1; i <= 8; i++) {
			tmp *= i;
			fact[i - 1] = tmp;
		}
		StringBuilder sb = new StringBuilder();
		if (n < 2)
			return "1";
		boolean[] flag = new boolean[9]; // ��Ǻ���
		for (i = 0; i < 9; i++) {
			flag[i] = false;
		}
		while (n > 1) {
			tmp = 1;
			while (tmp * fact[n - 2] < k)
				tmp++;
			int tmptmp = 0;
			i = 0;
			for (i = 0; i < 9; i++) {
				if (!flag[i])
					tmptmp++;
				if (tmptmp == tmp)
					break;
			}
			sb.append((char) (i + 1 + '0'));
			flag[i] = true;
			k -= (tmp - 1) * fact[n - 2];
			n--;
		}
		for (i = 0; i < 9; i++) { // �������һ��
			if (!flag[i])
				break;
		}
		sb.append((char) (i + 1 + '0'));
		return sb.toString();
	}
}
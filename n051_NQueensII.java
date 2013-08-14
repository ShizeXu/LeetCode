package LeetCode;

public class n051_NQueensII {
	public int subCnt(int[] res, int n, int x) {
		if (x > n - 1)
			return 1; // DONE
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			// CHECK
			for (int j = 0; j < x; j++) {
				if (i == res[j] || Math.abs(i - res[j]) == Math.abs(j - x)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res[x] = i;
				cnt += subCnt(res, n, x + 1);
			}
		}
		return cnt;
	}

	public int totalNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] res = new int[n];
		int cnt = 0;

		// 利用对称性。实际上等于subCnt(res, n, 0)
		for (int i = 0; i < n / 2; i++) {
			res[0] = i;
			cnt += subCnt(res, n, 1);
		}
		cnt *= 2;
		if (n % 2 == 1) {
			res[0] = n / 2;
			cnt += subCnt(res, n, 1);
		}
		return cnt;
	}
}
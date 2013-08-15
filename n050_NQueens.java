package LeetCode;

import java.util.ArrayList;

public class n050_NQueens {
	public void subSolve(ArrayList<String[]> resArr, int[] res, int n, int x) {
		if (x > n - 1) { // DONE
			String[] tmp = new String[n];
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb.append(j == res[i] ? 'Q' : '.');
				}
				tmp[i] = sb.toString();
			}
			resArr.add(tmp);
			return;
		}

		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int j = 0;
			// CHECK
			for (j = 0; j < x; j++) {
				if (res[j] == i || Math.abs(res[j] - i) == Math.abs(j - x)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				res[x] = i;
				subSolve(resArr, res, n, x + 1);
				res[x] = -1; // 可有可无，因为不会影响到后续子问题
			}
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> resArr = new ArrayList<String[]>();
		int[] res = new int[n];
		if (n < 1)
			return resArr;
		subSolve(resArr, res, n, 0);
		return resArr;
	}
}
package LeetCode;

import java.util.ArrayList;

public class n053_SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		if (m < 1)
			return res;
		int n = matrix[0].length;
		if (n < 1)
			return res;
		int round = Math.min((m + 1) / 2, (n + 1) / 2);
		int i = 0, j = 0;
		for (i = 0; i < round; i++) {
			for (j = i; j <= n - i - 1; j++)
				res.add(matrix[i][j]); // 全
			for (j = i + 1; j < m - i - 1; j++)
				res.add(matrix[j][n - i - 1]); // 去头尾
			if (m - i - 1 > i) {
				for (j = n - i - 1; j >= i; j--)
					res.add(matrix[m - i - 1][j]); // 全
			}
			if (n - i - 1 > i) {
				for (j = m - i - 2; j > i; j--)
					res.add(matrix[j][i]); // 去头尾
			}
		}
		return res;
	}
}

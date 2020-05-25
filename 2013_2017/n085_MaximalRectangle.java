package LeetCode;

public class n085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m < 1)
			return 0;
		int n = matrix[0].length;
		if (n < 1)
			return 0;
		int[] H = new int[n];
		int[] L = new int[n];
		int[] R = new int[n];
		for (int i = 0; i < n; i++)
			R[i] = n;

		int res = 0;
		for (int i = 0; i < m; i++) {
			int left = 0, right = n;
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == '1') {
					++H[j];
					L[j] = Math.max(L[j], left); // 和上层一起选出短板
				} else {
					left = j + 1;
					H[j] = 0;
					L[j] = 0;
				}
			}
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					R[j] = Math.min(R[j], right);
					res = Math.max(res, H[j] * (R[j] - L[j])); // 和上层一起选出短板
				} else {
					right = j;
					R[j] = n;
				}
			}
		}
		return res;
	}
};

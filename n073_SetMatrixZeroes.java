package LeetCode;

public class n073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m < 1)
			return;
		int n = matrix[0].length;
		if (n < 1 || (n == 1 && m == 1))
			return;
		boolean row = true, column = true; // 两个标记量
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				column = false;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				row = false;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
					// should not break
				}
			}
		}
		for (int j = 1; j < n; j++) { // Column
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) { // Row
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (!column)
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		if (!row)
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;
		return;
	}
}
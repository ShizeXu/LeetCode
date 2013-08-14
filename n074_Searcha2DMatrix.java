package LeetCode;

public class n074_Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;
		if (n == 0)
			return false;
		int l = 0, r = m - 1;
		int p = 0;
		boolean flag = false;
		while (l <= r) {
			p = (l + r) / 2;
			if (matrix[p][0] > target) {
				r = p - 1;
			} else {
				if (p < m - 1 && matrix[p + 1][0] <= target) { // 特殊处理，区别是在该行还是后面的行中
					l = p + 1;
				} else {
					flag = true; // 找到可能在的行
					break;
				}
			}
		}
		if (!flag)
			return false;
		l = 0;
		r = n - 1;
		int q = 0;
		while (l <= r) {
			q = (l + r) / 2;
			if (matrix[p][q] > target) {
				r = q - 1;
			} else if (matrix[p][q] < target) {
				l = q + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
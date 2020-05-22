package LeetCode;

public class n074_Searcha2DMatrix {
	// 拉成一维感觉直观一些
	boolean subSearch(int[][] matrix, int l, int r, int tar) {
		if (l > r)
			return false;
		int m = l + (r - l) / 2;
		int val = findVal(matrix, m);
		if (val == tar)
			return true;
		if (val > tar)
			return subSearch(matrix, l, m - 1, tar);
		return subSearch(matrix, m + 1, r, tar);
	}

	int findVal(int[][] matrix, int index) {
		int n = matrix[0].length;
		int x = index / n;
		int y = index % n;
		return matrix[x][y];
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix.length == 0)
			return false;
		return subSearch(matrix, 0, matrix.length * matrix[0].length - 1,
				target);
	}
}

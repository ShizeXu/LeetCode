package LeetCode;

public class n047_RotateImage {
	public void rotate(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = matrix.length;
		if (n < 2)
			return;
		int round = n / 2;
		for (int i = 0; i < round; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[j][n - i - 1];
				// RIGHT
				matrix[j][n - i - 1] = matrix[i][j];
				// UP
				matrix[i][j] = matrix[n - j - 1][i];
				// LEFT
				matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
				// DOWN
				matrix[n - i - 1][n - j - 1] = tmp;
			}
		}
	}
}
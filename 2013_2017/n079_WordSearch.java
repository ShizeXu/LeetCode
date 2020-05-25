package LeetCode;

public class n079_WordSearch {
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	boolean isValid(char[][] matrix, int i, int j) {
		return (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length);
	}

	boolean isExist(char[][] matrix, boolean[][] flag, int i, int j, String word) {
		if (word.equals(""))
			return true;
		char x = word.charAt(0);
		word = word.substring(1);
		for (int k = 0; k < 4; k++) {
			int m = i + d[k][0];
			int n = j + d[k][1];
			if (isValid(matrix, m, n) && matrix[m][n] == x && !flag[m][n]) {
				flag[m][n] = true;
				if (isExist(matrix, flag, m, n, word))
					return true;
				flag[m][n] = false;
			}
		}
		return false;
	}

	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m, n;
		if (board == null || (m = board.length) == 0
				|| (n = board[0].length) == 0)
			return false;
		boolean[][] flag = new boolean[m][n];
		char x = word.charAt(0);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (x == board[i][j]) {
					flag[i][j] = true;
					if (isExist(board, flag, i, j, word.substring(1)))
						return true;
					flag[i][j] = false;
				}
			}
		}
		return false;
	}
}

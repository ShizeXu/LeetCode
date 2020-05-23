package LeetCode;

public class n036_SudokuSolver {
	public boolean subSolve(char[][] board) {
		int p = 0, q = 0;
		boolean flag = false;
		for (p = 0; p < 9; p++) {
			for (q = 0; q < 9; q++) {
				if (board[p][q] == '.') {
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		if (!flag)
			return true; // SUCCESS

		boolean[] num = new boolean[9];
		for (int i = 0; i < 9; i++)
			num[i] = false;
		for (int i = 0; i < 9; i++) { // 第一层
			char x = board[p][i];
			if (x <= '9' && x >= '0')
				num[x - '0' - 1] = true;
		}
		for (int i = 0; i < 9; i++) { // 第二层
			char x = board[i][q];
			if (x <= '9' && x >= '0')
				num[x - '0' - 1] = true;
		}
		int m = p / 3;
		int n = q / 3;
		for (int i = m * 3; i < m * 3 + 3; i++) { // 第三层
			for (int j = n * 3; j < n * 3 + 3; j++) {
				char x = board[i][j];
				if (x <= '9' && x >= '0')
					num[x - '0' - 1] = true;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (!num[i]) {
				board[p][q] = (char) ('0' + 1 + i);
				if (subSolve(board)) // SUCCESS
					return true;
				board[p][q] = '.'; // Back-trace
			}
		}
		return false; // FAIL
	}

	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		subSolve(board);
	}
}

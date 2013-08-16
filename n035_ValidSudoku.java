package LeetCode;

public class n035_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean[] num = new boolean[9];
		// ROW
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++)
				num[k] = false;
			for (int j = 0; j < 9; j++) {
				char x = board[i][j];
				if (x <= '9' && x >= '1') {
					if (num[x - '0' - 1])
						return false;
					num[x - '0' - 1] = true;
				}
			}
		}
		// COLUMN
		for (int j = 0; j < 9; j++) {
			for (int k = 0; k < 9; k++)
				num[k] = false;
			for (int i = 0; i < 9; i++) {
				char x = board[i][j];
				if (x <= '9' && x >= '1') {
					if (num[x - '0' - 1])
						return false;
					num[x - '0' - 1] = true;
				}
			}
		}
		// SQUARE
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 9; k++)
					num[k] = false;
				for (int p = i * 3; p < i * 3 + 3; p++) {
					for (int q = j * 3; q < j * 3 + 3; q++) {
						char x = board[p][q];
						if (x <= '9' && x >= '1') {
							if (num[x - '0' - 1])
								return false;
							num[x - '0' - 1] = true;
						}
					}
				}
			}
		}
		return true;
	}
}

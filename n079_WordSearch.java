package LeetCode;

public class n079_WordSearch {
	public boolean subExist(char[][] board, int x, int y, boolean[][] flag,
			String word, int i) {
		if (i == word.length())
			return true;
		int X = board.length;
		int Y = board[0].length;

		flag[x][y] = true; // mark used
		if (x < X - 1 && !flag[x + 1][y] && board[x + 1][y] == word.charAt(i)) { // down, note three conditions
			if (subExist(board, x + 1, y, flag, word, i + 1))
				return true;
		}
		if (y < Y - 1 && !flag[x][y + 1] && board[x][y + 1] == word.charAt(i)) { // right
			if (subExist(board, x, y + 1, flag, word, i + 1))
				return true;
		}
		if (x > 0 && !flag[x - 1][y] && board[x - 1][y] == word.charAt(i)) { // up
			if (subExist(board, x - 1, y, flag, word, i + 1))
				return true;
		}
		if (y > 0 && !flag[x][y - 1] && board[x][y - 1] == word.charAt(i)) { // left
			if (subExist(board, x, y - 1, flag, word, i + 1))
				return true;
		}
		flag[x][y] = false; // back-trace
		return false;
	}

	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int X = board.length;
		if (X < 1)
			return false;
		int Y = board[0].length;
		if (Y < 1)
			return false;
		boolean[][] flag = new boolean[X][Y];
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (subExist(board, i, j, flag, word, 1))
						return true;
				}
			}
		}
		return false;
	}
}

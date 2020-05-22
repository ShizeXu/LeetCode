package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class n130_SurroundedRegions {
	class Pair {
		int x;
		int y;

		Pair(int xx, int yy) {
			x = xx;
			y = yy;
		}
	}

	public void solve(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = board.length;
		if (m < 3)
			return;
		int n = board[0].length;
		if (n < 3)
			return;
		Queue<Pair> queue = new LinkedList<Pair>();
		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				queue.offer(new Pair(0, i));
				board[0][i] = 'Y';
			}
		}
		for (int i = 1; i < m - 1; i++) {
			if (board[i][n - 1] == 'O') {
				queue.offer(new Pair(i, n - 1));
				board[i][n - 1] = 'Y';
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			if (board[m - 1][i] == 'O') {
				queue.offer(new Pair(m - 1, i));
				board[m - 1][i] = 'Y';
			}
		}
		for (int i = m - 2; i >= 1; i--) {
			if (board[i][0] == 'O') {
				queue.offer(new Pair(i, 0));
				board[i][0] = 'Y';
			}
		}

		while (queue.size() > 0) {
			Pair tmp = queue.poll();
			int x = tmp.x, y = tmp.y;
			if (x > 0 && board[x - 1][y] == 'O') {
				board[x - 1][y] = 'Y';
				queue.offer(new Pair(x - 1, y));
			}
			if (x < m - 1 && board[x + 1][y] == 'O') {
				board[x + 1][y] = 'Y';
				queue.offer(new Pair(x + 1, y));
			}
			if (y > 0 && board[x][y - 1] == 'O') {
				board[x][y - 1] = 'Y';
				queue.offer(new Pair(x, y - 1));
			}
			if (y < n - 1 && board[x][y + 1] == 'O') {
				board[x][y + 1] = 'Y';
				queue.offer(new Pair(x, y + 1));
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'Y')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
		}
	}
}

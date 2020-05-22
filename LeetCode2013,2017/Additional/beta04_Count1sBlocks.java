package Additional;

import java.util.LinkedList;
import java.util.Queue;

class Index {
	int x;
	int y;

	Index(int a, int b) {
		x = a;
		y = b;
	}
}

public class beta04_Count1sBlocks {
	static int[][] d = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	boolean isValid(int[][] a, int i, int j) {
		return (i >= 0 && i < a.length && j >= 0 && j < a[0].length);
	}

	int countBlock(int[][] a) {
		int m = a.length, n = a[0].length;
		Queue<Index> q0 = new LinkedList<Index>();
		Queue<Index> q1 = new LinkedList<Index>();
		boolean[][] flag = new boolean[m][n];
		if (a[0][0] == 0) {
			q0.offer(new Index(0, 0));
			flag[0][0] = true;
		} else {
			q1.offer(new Index(0, 0));
		}
		int cnt = 0;
		while (q1.size() > 0 || q0.size() > 0) {
			while (q1.size() > 0) {
				Index tmp = q1.poll();
				if (flag[tmp.x][tmp.y])
					continue;
				cnt++; // find a new block, has to do this under flag judgment
				Queue<Index> block = new LinkedList<Index>();
				block.offer(tmp);
				while (!block.isEmpty()) { // try to reach all 1s at once
					Index cur = block.poll();
					flag[cur.x][cur.y] = true;
					for (int i = 0; i < d.length; i++) {
						int u = cur.x + d[i][0];
						int v = cur.y + d[i][1];
						if (isValid(a, u, v) && !flag[u][v]) {
							if (a[u][v] == 0) {
								flag[u][v] = true;
								q0.offer(new Index(u, v));
							} else {
								block.offer(new Index(u, v));
							}
						}
					}
				}
			}
			while (q0.size() > 0) { // try to reach all 0s at once
				Index cur = q0.poll();
				for (int i = 0; i < d.length; i++) {
					int u = cur.x + d[i][0];
					int v = cur.y + d[i][1];
					if (isValid(a, u, v) && !flag[u][v]) {
						if (a[u][v] == 0) {
							flag[u][v] = true;
							q0.offer(new Index(u, v));
						} else {
							q1.offer(new Index(u, v));
						}
					}
				}
			}
		}
		return cnt;
	}
}

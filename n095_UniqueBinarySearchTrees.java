package LeetCode;

public class n095_UniqueBinarySearchTrees {
	public int numTrees(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0)
			return 0;
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = 0;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i / 2; j++) { // 枚举根节点
				res[i] += 2 * res[j] * res[i - j - 1];
			}
			if (i % 2 == 1)
				res[i] += res[i / 2] * res[i / 2];
		}
		return res[n];
	}
}

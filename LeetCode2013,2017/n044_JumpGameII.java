package LeetCode;

public class n044_JumpGameII {
	public int jump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		if (n == 1)
			return 0;
		int far = A[0];
		int preFar = 0;
		int cnt = 1;
		while (far < n - 1) {
			int tmpFar = far;
			for (int j = preFar + 1; j <= far; j++) { // 从上次计算结束的地方开始计算，以免重复
				if (j + A[j] > tmpFar) {
					tmpFar = j + A[j];
				}
			}
			preFar = far; // preFar用来剪枝，即上次算到这里
			far = tmpFar;
			cnt++;
		}
		return cnt;
	}
}

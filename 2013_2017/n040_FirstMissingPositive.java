package LeetCode;

public class n040_FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int i = 0;
		for (i = 0; i < n; i++) { // 预处理
			if (A[i] <= 0)
				A[i] = n + 1;
		}
		for (i = 0; i < n; i++) {
			int val = Math.abs(A[i]); // 只取正数部分
			if (val <= n)
				A[val - 1] = 0 - Math.abs(A[val - 1]); // KEY POINT
		}
		for (i = 0; i < n; i++) {
			if (A[i] > 0)
				return i + 1;
		}
		return i + 1;
	}
}

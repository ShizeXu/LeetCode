package LeetCode;

public class n052_MaximumSubarray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int[] max = new int[n];
		int[] maxLast = new int[n];
		if (n < 1)
			return 0;
		maxLast[0] = A[0];
		max[0] = A[0]; // 若无要求至少一个元素，这里是Math.max(0, A[0])
		for (int i = 1; i < n; i++) {
			maxLast[i] = Math.max(A[i], A[i] + maxLast[i - 1]);
			max[i] = Math.max(maxLast[i], max[i - 1]);
		}
		return max[n - 1];
	}
}
package LeetCode;

public class n041_TrappingRainWater {
	public int trap(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int max = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] > A[max])
				max = i;
		}
		int tmpH = 0;
		int res = 0;
		for (int i = 0; i < max; i++) {
			if (tmpH > A[i])
				res += (tmpH - A[i]);
			else
				tmpH = A[i];
		}
		tmpH = 0;
		for (int i = n - 1; i > max; i--) {
			if (tmpH > A[i])
				res += (tmpH - A[i]);
			else
				tmpH = A[i];
		}
		return res;
	}
}

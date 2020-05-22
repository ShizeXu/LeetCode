package LeetCode;

public class n080_RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		if (n < 3)
			return n;
		int prev = A[0];
		int cnt = 1, cur = 1;
		for (int i = 1; i < n; i++) {
			if (A[i] == prev) {
				if (cnt < 2) {
					A[cur++] = prev;
					cnt++;
				}
			} else {
				prev = A[i];
				A[cur++] = prev;
				cnt = 1;
			}
		}
		return cur;
	}
}

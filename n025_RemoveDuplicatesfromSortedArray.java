package LeetCode;

public class n025_RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int m = 0;
		int prev = 0;
		Boolean first = true;
		for (int i = 0; i < n; i++) {
			if (first) {
				prev = A[i];
				m++;
				first = false;
				continue;
			}
			if (A[i] != prev) {
				prev = A[i];
				A[m] = A[i];
				m++;
			} // else continue
		}
		return m;
	}
}

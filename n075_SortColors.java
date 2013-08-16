package LeetCode;

public class n075_SortColors {
	public void sortColors(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int x0 = 0, x1 = n - 1, x2 = n - 1;
		while (x0 <= x1) { // O(n)
			int t = A[x0];
			if (A[x0] == 2) {
				A[x0] = A[x2];
				A[x2] = t;
				x2--;
				if (x2 < x1)
					x1 = x2;
			} else if (A[x0] == 1) {
				A[x0] = A[x1];
				A[x1] = t;
				x1--;
			} else {
				x0++;
			}
		}
	}
}

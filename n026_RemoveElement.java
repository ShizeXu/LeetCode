package LeetCode;

public class n026_RemoveElement {
	public int removeElement(int[] A, int elem) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		int m = 0;
		for (int i = 0; i < n; i++) {
			if (elem != A[i] && (m++) < i) {
				A[m - 1] = A[i];
			}
		}
		return m;
	}
}
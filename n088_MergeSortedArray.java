package LeetCode;

public class n088_MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		m--;
		n--;
		while (m >= 0 || n >= 0) {
			if (m < 0)
				A[n] = B[n--];
			else if (n < 0)
				break;
			else {
				if (A[m] >= B[n])
					A[m + n + 1] = A[m--];
				else
					A[m + n + 1] = B[n--];
			}
		}
	}
}
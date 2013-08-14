package LeetCode;

public class n002_MedianofTwoSortedArrays {
	double findMedian(int[] A, int[] B, int l, int r) {
		int m = A.length;
		int n = B.length;
		if (l > r)
			return findMedian(B, A, 0, n - 1);

		int i = (l + r) / 2;
		int j = (m + n) / 2 - i - 1;
		if (j > n - 1 || (j >= 0 && A[i] < B[j]))
			return findMedian(A, B, i + 1, r);
		else if (j + 1 < 0 || (j < n - 1 && A[i] > B[j + 1]))
			return findMedian(A, B, l, i - 1);
		else { // A[i] is the potential median
			if ((m + n) % 2 == 1)
				return A[i];
			// Either A[i-1] or B[j]
			else if (i > 0 && j >= 0)
				return (A[i] + Math.max(A[i - 1], B[j])) / 2.0;
			else if (i > 0)
				return (A[i] + A[i - 1]) / 2.0;
			else
				return (A[i] + B[j]) / 2.0;
		}
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = A.length;
		int n = B.length;
		if (m == 0) {
			return n % 2 == 1 ? B[n / 2] : (B[n / 2 - 1] + B[n / 2]) / 2.0;
		} else if (n == 0) {
			return m % 2 == 1 ? A[m / 2] : (A[m / 2 - 1] + A[m / 2]) / 2.0;
		}
		return findMedian(A, B, 0, m - 1);
	}
}
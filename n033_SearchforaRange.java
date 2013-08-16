package LeetCode;

public class n033_SearchforaRange {
	int sub_search(int[] A, int l, int r, int t, Boolean isLeft) {
		if (l > r) {
			if (isLeft)
				return (l < A.length && A[l] == t) ? l : -1;
			else
				return (r >= 0 && A[r] == t) ? r : -1;
		}
		int m = (l + r) / 2;
		if (A[m] < t)
			return sub_search(A, m + 1, r, t, isLeft);
		if (A[m] > t)
			return sub_search(A, l, m - 1, t, isLeft);
		// else if A[m]==t
		if (isLeft)
			return sub_search(A, l, m - 1, t, isLeft);
		return sub_search(A, m + 1, r, t, isLeft);
	}

	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		if (n < 1) {
			int[] res = { -1, -1 };
			return res;
		}
		int[] res = { sub_search(A, 0, n - 1, target, true),
				sub_search(A, 0, n - 1, target, false) };
		return res;
	}
}

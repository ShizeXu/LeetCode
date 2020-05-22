package LeetCode;

public class n032_SearchinRotatedSortedArray {
	public int sub_search(int[] A, int l, int r, int t) {
		if (l > r)
			return -1;
		int m = l + (r - l) / 2;
		if (A[m] == t)
			return m;
		if (A[m] >= A[l]) { // 左边有序
			if (t < A[m] && t >= A[l])
				return sub_search(A, l, m - 1, t);
			return sub_search(A, m + 1, r, t);
		}
		// 右边有序
		if (t > A[m] && t <= A[r])
			return sub_search(A, m + 1, r, t);
		return sub_search(A, l, m - 1, t);
	}

	public int search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return sub_search(A, 0, A.length - 1, target);
	}
}

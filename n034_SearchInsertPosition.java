package LeetCode;

public class n034_SearchInsertPosition {
	public int sub_search(int[] A, int l, int r, int t) {
		if (l > r)
			return l; // 返回较大的边界
		int m = (l + r) / 2;
		if (A[m] == t)
			return m;
		if (A[m] < t)
			return sub_search(A, m + 1, r, t);
		else
			return sub_search(A, l, m - 1, t);
	}

	public int searchInsert(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return sub_search(A, 0, A.length - 1, target);
	}
}

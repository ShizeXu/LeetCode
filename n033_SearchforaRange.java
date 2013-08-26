package LeetCode;

public class n033_SearchforaRange {
	public int[] searchRange(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = 0, r = A.length - 1;
		int mid = 0;
		while (l <= r) { // find an arbitrary target in array
			mid = l + (r - l) / 2;
			if (A[mid] > target)
				r = mid - 1;
			else if (A[mid] < target)
				l = mid + 1;
			else
				break;
		}
		if (l > r) {
			int[] res = { -1, -1 };
			return res;
		}
		// new range has been limited to [l,r]
		int newL = mid;
		while (newL <= r) {
			int m = newL + (r - newL) / 2;
			if (A[m] <= target)
				newL = m + 1;
			else
				r = m - 1;
		}
		int newR = mid;
		while (newR >= l) {
			int m = l + (newR - l) / 2;
			if (A[m] >= target)
				newR = m - 1;
			else
				l = m + 1;
		}
		int[] res = { l, r };
		return res;
	}
}

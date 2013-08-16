package LeetCode;

public class n081_SearchinRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = A.length;
		for (int i = 0; i < n; i++) {
			if (A[i] == target)
				return true;
		}
		return false;
	}
}

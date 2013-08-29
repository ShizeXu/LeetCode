package LeetCode;

public class n011_ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = 0, r = height.length - 1;
		int res = 0;
		while (l < r) {
			int low = Math.min(height[l], height[r]);
			int tmp = low * (r - l);
			res = Math.max(res, tmp);

			while (l < r && height[l] <= low)
				l++;
			while (l < r && height[r] <= low)
				r--;
		}
		return res;
	}
}

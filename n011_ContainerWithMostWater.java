package LeetCode;

public class n011_ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = 0, r = height.length - 1;
		int res = 0;
		while (l < r) {
			int tmp = Math.min(height[l], height[r]) * (r - l);
			res = Math.max(res, tmp);
			int low = Math.min(height[l], height[r]);
			if (height[l] <= height[r]) {
				while (l < r && height[l] <= low)
					l++;
			} else {
				while (l < r && height[r] <= low)
					r--;
			}
		}
		return res;
	}
}
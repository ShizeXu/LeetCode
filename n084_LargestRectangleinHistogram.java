package LeetCode;

public class n084_LargestRectangleinHistogram {
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = height.length;
		if (n < 1)
			return 0;
		int[] r = new int[n];
		int[] l = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = i;
			while (l[i] > 0 && height[l[i] - 1] >= height[i])
				l[i] = l[l[i] - 1]; // 跳跃式地往前找，l[i]--的话将超时
		}
		for (int i = n - 1; i >= 0; i--) {
			r[i] = i;
			while (r[i] < n - 1 && height[r[i] + 1] >= height[i])
				r[i] = r[r[i] + 1]; // 跳跃式地往后找，r[i]++的话将超时
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			int tmp = (r[i] - l[i] + 1) * height[i];
			max = (max >= tmp ? max : tmp);
		}
		return max;
	}
}
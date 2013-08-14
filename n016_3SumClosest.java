package LeetCode;

import java.util.Arrays;

public class n016_3SumClosest {
	public int threeSumClosest(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		Arrays.sort(num);
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < n - 2; i++) {
			int l = i + 1;
			int r = n - 1;
			while (l < r) {
				int tmp = num[l] + num[r] + num[i];
				// 和3Sum比就这里不一样，判等改为判是否更小
				if (Math.abs(tmp - target) < min) {
					min = Math.abs(tmp - target);
					res = tmp;
				}
				if (tmp < target) {
					l++;
				} else if (tmp > target) {
					r--;
				} else {
					return target;
				}
			}
		}
		return res;
	}
}
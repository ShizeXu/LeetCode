package LeetCode;

import java.util.ArrayList;

public class n089_GrayCode {
	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			result.add(0);
			return result;
		}
		int max = 1;
		for (int k = 0; k < n; k++)
			max *= 2;
		for (int k = 0; k < max; k++) {
			int multi = 1;
			int tmp = k;
			int res = 0;
			for (int i = 0; i < n - 1; i++) {
				res += multi * ((tmp & 1) ^ ((tmp >> 1) & 1)); // 格雷码规则
				multi *= 2;
				tmp = tmp >> 1;
			}
			res += multi * tmp;
			result.add(res);
		}
		return result;
	}
}

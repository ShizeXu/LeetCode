package LeetCode;

public class n067_PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = digits.length;
		if (n == 0)
			return new int[] { 1 };
		int[] res = new int[n];
		int tmp = digits[n - 1] + 1;
		int add = 0;
		res[n - 1] = tmp % 10;
		add = tmp / 10;
		for (int i = n - 2; i >= 0; i--) {
			tmp = digits[i] + add;
			res[i] = tmp % 10;
			add = tmp / 10;
		}
		if (add > 0) {
			int[] newRes = new int[n + 1];
			newRes[0] = 1;
			for (int i = 0; i < n; i++) {
				newRes[i + 1] = res[i];
			}
			return newRes;
		} else {
			return res;
		}
	}
}
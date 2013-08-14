package LeetCode;

public class n070_ClimbingStairs {
	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] res = new int[n];
		res[n - 1] = 1;
		res[n - 2] = 2;
		for (int i = n - 3; i >= 0; i--) {
			res[i] = res[i + 1] + res[i + 2];
		}
		return res[0];
	}
}
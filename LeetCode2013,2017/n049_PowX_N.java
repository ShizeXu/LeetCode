package LeetCode;

public class n049_PowX_N {
	public double pow(double x, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		double res = 1d;
		boolean flag = false; // 可能小于零
		if (n < 0) {
			flag = true;
			n = -n;
		}
		while (n > 0) {
			if ((n ^ (n - 1)) == 1) // n%2==1
				res *= x;
			n >>= 1;
			x *= x;
		}
		return flag ? 1.0 / res : res;
	}
}

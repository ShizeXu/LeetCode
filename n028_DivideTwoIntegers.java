package LeetCode;

public class n028_DivideTwoIntegers {
	public long subDivide(long dividend, long divisor) {
		if (divisor > dividend)
			return 0l;
		long c = divisor;
		int k = 0;
		for (k = 0; dividend >= c; c = (c << 1), k++) {
			if (dividend - c < divisor) {
				return 1l << k;
			}
		}
		long tmp = subDivide(dividend - (c >> 1), divisor);
		if (tmp == Long.MIN_VALUE)
			return Long.MIN_VALUE;
		return (1l << (k - 1)) + tmp;
	}

	public int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (divisor == 0) {
			return 0;
		}
		int flag1 = 1;
		int flag2 = 1;
		long a = (long) dividend;
		long b = (long) divisor;
		if (dividend < 0) {
			flag1 = -1;
			a = 0l - a;
		}
		if (divisor < 0) {
			flag2 = -1;
			b = 0l - b;
		}
		long res = subDivide(a, b);
		if (res == Long.MIN_VALUE) {
			return 0;
		}
		res = res * flag1 * flag2;
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return 0;
		}
		return (int) res;
	}
}
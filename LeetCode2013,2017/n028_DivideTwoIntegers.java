package LeetCode;

public class n028_DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0 || dividend == 0)
			return 0;
		long a = dividend, b = divisor;
		if (a < 0)
			a = -a;
		if (b < 0)
			b = -b;
		long tmpb = b;
		long add = 1;
		while (tmpb <= a) {
			tmpb <<= 1;
			add <<= 1;
		}
		long res = 0;
		do {
			tmpb >>= 1;
			add >>= 1;
			while (a >= tmpb) {
				res += add;
				a -= tmpb;
			}
		} while (a > 0);
		return (int) (((divisor < 0 && dividend > 0) || (divisor > 0 && dividend < 0)) ? -res
				: res);
	}
}

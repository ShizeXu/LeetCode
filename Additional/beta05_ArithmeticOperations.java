package Additional;

// Do 4 types of arithmetic operations without using "+_*/" 
public class beta05_ArithmeticOperations {
	int add(int a, int b) {
		if (b == 0)
			return a;
		return add((a ^ b), ((a & b) << 1));
	}

	int sub(int a, int b) {
		b = add(~b, 1); // Complementer
		return add(a, b);
	}

	int multiply(int a, int b) {
		boolean negative = false; // Sign
		if (a < 0) {
			negative = !negative;
			a = sub(0, a);
		}
		if (b < 0) {
			negative = !negative;
			b = sub(0, b);
		}
		int res = 0;
		while (b != 0) {
			if ((b & 1) == 1) {
				res = add(res, a);
			}
			a <<= 1;
			b >>= 1; // 算术移位
		}
		return negative ? sub(0, res) : res;
	}

	int divide(int a, int b) throws Exception {
		if (b == 0)
			throw new Exception("Divisor shouldn't be zero!");
		boolean negative = false; // Sign
		if (a < 0) {
			negative = !negative;
			a = sub(0, a);
		}
		if (b < 0) {
			negative = !negative;
			b = sub(0, b);
		}
		int MAX = Integer.MAX_VALUE >> 1;
		int tmp = b;
		while (tmp <= MAX && (tmp << 1) <= a) {
			tmp <<= 1;
		}
		int res = 0;
		while (tmp >= b) {
			res <<= 1;
			if (a >= tmp) {
				res |= 1;
				a = sub(a, tmp);
			}
			tmp >>= 1;
		}
		return negative ? sub(0, res) : res;
	}
}

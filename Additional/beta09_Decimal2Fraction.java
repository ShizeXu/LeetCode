package Additional;

// Transform a double value to fraction with minimal denominator
public class beta09_Decimal2Fraction {
	class Fraction {
		int numerator;
		int denominator;

		Fraction(int a, int b) {
			numerator = a;
			denominator = b;
		}
	}

	Fraction findFrction(double x) {
		boolean negative = false;
		if (x < 0) {
			negative = true;
			x = -x;
		}
		double max = 1d;
		double tmp = x;
		while ((long) tmp != tmp) { // still has decimal part
			max *= 10;
			tmp = x * max;
		}
		// denominator minimization via iterative division algorithm
		long i = (long) tmp, j = (long) max;
		while (i > 0 && j > 0) {
			if (i >= j)
				i %= j;
			else
				j %= i;
		}
		long factor = Math.max(i, j);
		return new Fraction((negative ? -1 : 1) * (int) (tmp / factor),
				(int) (max / factor));
	}
}

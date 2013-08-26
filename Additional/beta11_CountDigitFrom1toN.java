package Additional;

public class beta11_CountDigitFrom1toN {
	int count(int n, int digit) {
		int res = 0;
		int max = 0; // max counts per digits
		int more = 1; // additional counts in current length
		int pre = 0; // from lower digits to higher digits, the passed 'n'
		while (n > 0) {
			int x = n % 10;
			res += x * max;
			if (x > digit) {
				res += more;
			} else if (x == digit) {
				res += pre + 1;
			}
			max = max * 10 + more;
			pre += more * x;
			more *= 10;
			n /= 10;
		}
		if (digit == 0) { // special case
			more /= 10;
			while (more > 0) {
				res -= more;
				more /= 10;
			}
		}
		return res;
	}
}
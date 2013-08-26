package Additional;

public class beta06_PerfectSquare {
	/**
	 * Given positive B, find maximal A, s.t. A*(A+B) is perfect square number
	 * 
	 * @param int b
	 * @return maximal integer a
	 * 
	 * (a+b/2)^2 - b^2/4 = c^2
	 * 则 (a + b/2 + c) * (a + b/2 - c) = b^2/4
	 * 分b为奇数、4的倍数、2的倍数讨论，使a最大，也是使c最大。
	 * 1. 每项必为分数；
	 * 2. 两项之差为2c，而奇数乘奇数是不会为偶数的，因此需均为偶数；
	 * 3. 为原始解 1；
	 * 因此等式右项的取值分别为1/2，2，1。
	 */
	int findMin(int b) {
		int a = 0;
		if (b % 2 == 0) {
			if (b % 4 == 0) // case 2
				a = (b - 4) * (b - 4) / 16;
			else // case 3
				a = (b - 2) * (b - 2) / 8;
		} else // case 1
			a = (b - 1) * (b - 1) / 4;
		return a;
	}
}

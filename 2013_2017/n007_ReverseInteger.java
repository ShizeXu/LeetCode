package LeetCode;

public class n007_ReverseInteger {
	public int reverse(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return subRev(0, x);
	}

	int subRev(int pre, int x) {
		if (x == 0)
			return pre;
		return subRev(pre * 10 + x % 10, x / 10);
	}
}

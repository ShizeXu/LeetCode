package LeetCode;

public class n009_PalindromeNumber {
	public boolean isPalindrome(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (x < 0)
			return false;
		int max = 1;
		while (x / max > 9) {
			max = max * 10;
		}
		while (x > 0) {
			if (x / max != x % 10) {
				return false;
			}
			x = x % max;
			x = x / 10;
			max = max / 100;
		}
		return true;
	}
}

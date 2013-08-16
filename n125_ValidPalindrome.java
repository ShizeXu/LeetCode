package LeetCode;

public class n125_ValidPalindrome {
	public boolean isPalindrome(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		s = s.toLowerCase();
		int n = s.length();
		int l = 0, r = n - 1;
		while (l < r) {
			while (l < r && !((s.charAt(l) <= 'z' && s.charAt(l) >= 'a') || (s
					.charAt(l) <= '9' && s.charAt(l) >= '0'))) {
				l++;
			}
			while (r > l && !((s.charAt(r) <= 'z' && s.charAt(r) >= 'a') || (s
					.charAt(r) <= '9' && s.charAt(r) >= '0'))) {
				r--;
			}
			if (l >= r)
				break;
			if (s.charAt(l++) != s.charAt(r--))
				return false;
		}
		return true;
	}
}

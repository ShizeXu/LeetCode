package LeetCode;

public class n069_SqrtX {
	public int sqrt(int x) {
		// Start typing your Java solution below
		// DO NOT write main() function
		double a = x / 2.0;
		double tmp = x / a; // to avoid overflow
		while (Math.abs(a - tmp) > 0.01) {
			a += (tmp + a) / 2.0;
			tmp = x / a;
		}
		return (int) a;
	}
}

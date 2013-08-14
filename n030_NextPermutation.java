package LeetCode;

public class n030_NextPermutation {
	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		if (n < 2)
			return;
		int i = n - 1;
		while (i > 0 && num[i] <= num[i - 1])
			i--;
		int j = n - 1;
		int t;
		if (i > 0) {
			while (num[j] <= num[i - 1])
				j--;
			t = num[j];
			num[j] = num[i - 1];
			num[i - 1] = t;
		}
		j = n - 1;
		while (i < j) {
			t = num[j];
			num[j] = num[i];
			num[i] = t;
			i++;
			j--;
		}
	}
}
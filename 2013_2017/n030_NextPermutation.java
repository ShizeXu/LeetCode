package LeetCode;

public class n030_NextPermutation {
	void swap(int[] num, int x, int y) {
		int tmp = num[x];
		num[x] = num[y];
		num[y] = tmp;
	}

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
		if (i > 0) {
			while (num[j] <= num[i - 1])
				j--;
			swap(num, j, i - 1);
		}
		j = n - 1;
		while (i < j) {
			swap(num, i++, j--);
		}
	}
}

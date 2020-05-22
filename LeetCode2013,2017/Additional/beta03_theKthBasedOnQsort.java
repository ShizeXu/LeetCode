package Additional;

import java.util.Random;

public class beta03_theKthBasedOnQsort {
	public int rank(int[] num, int l, int r, int k) {
		if (l > r)
			return -1;
		int rand = l + new Random().nextInt(r - l + 1);
		swap(num, l, rand);
		int begin = l + 1, end = r;
		while (begin <= end) {
			while (begin <= end && num[begin] <= num[l]) {
				begin++;
			}
			while (begin <= end && num[l] < num[end]) {
				end--;
			}
			if (begin > end)
				break;
			swap(num, begin++, end--);
		}
		swap(num, l, end);
		// decide which side to search
		if (end == k) // found
			return num[end];
		if (end > k) // left
			return rank(num, l, end - 1, k);
		return rank(num, end + 1, r, k); // right
	}

	void swap(int[] num, int x, int y) {
		int tmp = num[x];
		num[x] = num[y];
		num[y] = tmp;
	}
}

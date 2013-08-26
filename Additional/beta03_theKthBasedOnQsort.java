package Additional;

import java.util.Random;

public class beta03_theKthBasedOnQsort {
	public int rank(int[] num, int l, int r, int k) {
		if (l > r)
			return -1;
		int begin = l, end = r;

		Random rand = new Random();
		int pivot = num[begin + rand.nextInt(end - begin + 1)];
		int first = -1;
		while (true) {
			while (begin <= end && num[begin] <= pivot) {
				if (num[begin] < pivot && first != -1) { // shift the pivots
					swap(num, begin, first++);
					if (num[first] != pivot)
						first = begin;
				} else if (num[begin] == pivot && first == -1)
					first = begin;
				begin++;
			}
			while (begin <= end && pivot < num[end]) {
				end--;
			}
			if (begin > end)
				break;
			swap(num, begin, end);
			if (num[begin] < pivot && first != -1) { // shift the pivots
				swap(num, begin, first++);
				if (num[first] != pivot)
					first = begin;
			} else if (num[begin] == pivot && first == -1)
				first = begin;
		}

		// decide which side to search
		if (first <= k && begin > k) // found
			return pivot;
		if (first > k) // left
			return rank(num, l, first - 1, k);
		return rank(num, begin, r, k); // right
	}

	void swap(int[] num, int x, int y) {
		int tmp = num[x];
		num[x] = num[y];
		num[y] = tmp;
	}
}

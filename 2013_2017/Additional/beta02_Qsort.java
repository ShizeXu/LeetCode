package Additional;

import java.util.Random;

// Could have duplicate elements
public class beta02_Qsort {
	public void qsort(int[] num, int l, int r) {
		if (l >= r)
			return;
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

		qsort(num, l, first - 1);
		qsort(num, first + 1, r);
	}

	void swap(int[] num, int x, int y) {
		int tmp = num[x];
		num[x] = num[y];
		num[y] = tmp;
	}
}

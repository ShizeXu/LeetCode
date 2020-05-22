package Additional;

public class beta15_CrossMergeArray<T> {
	// merge a1,a2,...,an,b1,b2,...,bn to a1,b1,a2,b2,...,an,bn.
	void crossMerge(T[] arr) {
		rotateNinsert(arr, 0, arr.length - 1);
	}

	// find the longest 2^n sequence
	void rotateNinsert(T[] arr, int begin, int end) {
		if (begin + 1 >= end)
			return;
		int n = 4;
		while (end - begin + 1 >= n)
			n *= 2;
		n /= 4;
		int mid = begin + (end - begin) / 2;
		// rotate
		changeSegment(arr, begin + n, mid, mid + n);
		// insert
		loopInsert(arr, begin, begin + 2 * n - 1, n);
		
		// remaining task
		rotateNinsert(arr, begin + 2 * n, end);
	}

	void changeSegment(T[] arr, int begin, int mid, int end) {
		if (begin > mid)
			return;
		int k = begin + (mid - begin) / 2;
		for (int i = begin; i <= k; i++) {
			swap(arr, i, mid + begin - i);
		}
		k = mid + 1 + (end - mid - 1) / 2;
		for (int i = mid + 1; i <= k; i++) {
			swap(arr, i, end + mid + 1 - i);
		}
		k = begin + (end - begin) / 2;
		for (int i = begin; i <= k; i++) {
			swap(arr, i, end + begin - i);
		}
	}

	// Key method
	void loopInsert(T[] arr, int begin, int end, int n) {
		int i = 1;
		int m = 2 * n - 1;
		while (i < n) {
			int j = (i * 2) % m;
			while (j != i) {
				swap(arr, begin + j, begin + i); // Use arr[begin+i] as temporary space
				j = (2 * j) % m;
			}
			i += 2;
		}
	}

	void swap(T[] arr, int i, int j) {
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

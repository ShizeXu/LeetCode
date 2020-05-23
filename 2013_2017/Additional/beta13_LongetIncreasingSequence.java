package Additional;

import java.util.ArrayList;

public class beta13_LongetIncreasingSequence {
	int[] LIS(int[] num) {
		ArrayList<Integer> trace = new ArrayList<Integer>(); // for back-tracing
		ArrayList<Integer> lis = new ArrayList<Integer>(); // recording the current optimal LIS
		trace.add(-1);
		lis.add(0);
		for (int i = 1; i < num.length; i++) {
			int l = 0, r = lis.size() - 1;
			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (num[lis.get(mid)] < num[i])
					l = mid + 1;
				else
					r = mid - 1;
			}
			trace.add(r >= 0 ? lis.get(r) : -1);
			if (r == lis.size() - 1) { // find a longer sequence
				lis.add(i);
			} else if (num[lis.get(r + 1)] > num[i]) { // decrease previous value
				lis.set(r + 1, i);
			}
		}
		int[] res = new int[lis.size()];
		int i = lis.size();
		int tmp = lis.get(i - 1);
		while ((--i) >= 0) {
			res[i] = num[tmp];
			tmp = trace.get(tmp);
		}
		return res;
	}
}

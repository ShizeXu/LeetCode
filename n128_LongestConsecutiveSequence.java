package LeetCode;

import java.util.HashMap;

public class n128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		if (n < 2)
			return n;
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		int max = 1;
		for (int i = 0; i < n; i++) {
			int tmp = num[i];
			if (res.containsKey(tmp))
				continue;
			if (!res.containsKey(tmp - 1) && !res.containsKey(tmp + 1))
				res.put(tmp, 1);
			else if (res.containsKey(tmp - 1) && res.containsKey(tmp + 1)) {
				int val1 = res.get(tmp - 1), val2 = res.get(tmp + 1);
				int len = val1 + val2 + 1;
				res.put(tmp, 0);
				res.put(tmp - val1, len);
				res.put(tmp + val2, len);
				max = Math.max(max, len);
			} else if (res.containsKey(tmp - 1)) {
				int val = res.get(tmp - 1);
				res.put(tmp, val + 1);
				res.put(tmp - val, val + 1);
				max = Math.max(max, val + 1);
			} else {
				int val = res.get(tmp + 1);
				res.put(tmp, val + 1);
				res.put(tmp + val, val + 1);
				max = Math.max(max, val + 1);
			}
		}
		return max;
	}
}

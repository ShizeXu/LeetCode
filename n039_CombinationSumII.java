package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n039_CombinationSumII {
	public boolean subCombine(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int[] num, int[] cnt, int n, int t,
			int index) {
		if (t == 0)
			return true;
		for (int i = index; i < n; i++) {
			int val = num[i];
			if (val <= t) {
				if (cnt[i] > 0) {
					res.add(val);
					cnt[i]--;
					if (subCombine(resArr, res, num, cnt, n, t - val, i))
						resArr.add((ArrayList<Integer>) res.clone());
					res.remove(res.size() - 1);
					cnt[i]++;
				}
			} else {
				break;
			}
		}
		return false;
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		Arrays.sort(num);
		// ШЅжи
		int prev = -1, k = -1;
		int[] cnt = new int[n];
		for (int i = 0; i < n; i++) {
			if (num[i] != prev) {
				cnt[++k] = 1;
				num[k] = num[i];
				prev = num[i];
			} else
				cnt[k]++;
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		subCombine(resArr, res, num, cnt, k + 1, target, 0);
		return resArr;
	}
}
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n038_CombinationSum {
	public boolean subCombine(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int[] candidates, int t, int index) {
		if (t == 0)
			return true;
		int n = candidates.length;
		for (int i = index; i < n; i++) {
			int val = candidates[i];
			if (val <= t) {
				res.add(val);
				if (subCombine(resArr, res, candidates, t - val, i))
					resArr.add((ArrayList<Integer>) res.clone());
				res.remove(res.size() - 1);
			} else {
				break; // ºÙ÷¶
			}
		}
		return false;
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(candidates);

		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		subCombine(resArr, res, candidates, target, 0);
		return resArr;
	}
}
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n038_CombinationSum {
	public void subCombine(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int[] candidates, int t, int index) {
		if (t == 0) {
			resArr.add(new ArrayList<Integer>(res));
			return;
		}
		int n = candidates.length;
		if (index == n) // Fail
			return;
		if (candidates[index] <= t) {
			res.add(candidates[index]);
			subCombine(resArr, res, candidates, t - candidates[index], index);
			res.remove(res.size() - 1);
		} else {
			return; // ¼ôÖ¦
		}
		subCombine(resArr, res, candidates, t, index + 1);
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
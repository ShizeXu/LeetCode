package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n039_CombinationSumII {
	public void subCombine(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, ArrayList<Pair> num, int t, int index) {
		if (t == 0) {
			resArr.add(new ArrayList<Integer>(res));
			return;
		}
		int n = num.size();
		if (index == n)
			return; // Fail
		Pair p = num.get(index);
		if (p.val <= t) {
			if (p.cnt > 0) {
				res.add(p.val);
				p.cnt--;
				subCombine(resArr, res, num, t - p.val, index);
				res.remove(res.size() - 1);
				p.cnt++;
			}
		} else {
			return;
		}
		subCombine(resArr, res, num, t, index + 1);
	}

	class Pair {
		int val;
		int cnt;

		Pair(int v, int c) {
			val = v;
			cnt = c;
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		Arrays.sort(num);
		// 去重
		int prev = Integer.MAX_VALUE;
		ArrayList<Pair> newNum = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			if (num[i] != prev) {
				newNum.add(new Pair(num[i], 1));
				prev = num[i];
			} else
				newNum.get(newNum.size() - 1).cnt++;
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		subCombine(resArr, res, newNum, target, 0);
		return resArr;
	}
}

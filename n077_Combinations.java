package LeetCode;

import java.util.ArrayList;

public class n077_Combinations {
	public void subCombine(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int start, int n, int k) {
		if (k == 0) {
			resArr.add((ArrayList<Integer>) res.clone());
			return;
		}
		if (k + start - 1 > n)
			return;
		subCombine(resArr, res, start + 1, n, k); // 不取
		res.add(start);
		subCombine(resArr, res, start + 1, n, k - 1); // 取
		res.remove((Integer) start);
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		if (k < 1 || n < 1)
			return resArr;
		ArrayList<Integer> res = new ArrayList<Integer>();
		subCombine(resArr, res, 1, n, k);
		return resArr;
	}
}

package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class n078_Subsets {
	public void sets(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int i, int[] S) {
		int n = S.length;
		if (i == n) {
			resArr.add((ArrayList<Integer>) res.clone());
			return;
		}
		sets(resArr, res, i + 1, S); // not add
		res.add(S[i]);
		sets(resArr, res, i + 1, S); // add
		res.remove((Integer) S[i]);
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		Arrays.sort(S);
		sets(resArr, res, 0, S);
		return resArr;
	}
}
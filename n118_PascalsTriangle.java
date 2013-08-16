package LeetCode;

import java.util.ArrayList;

public class n118_PascalsTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (numRows == 0)
			return resArr;
		res.add(1);
		resArr.add((ArrayList<Integer>) res.clone());
		for (int i = 1; i < numRows; i++) {
			res.clear();
			int pre = 0, tmp = 0;
			for (int j = 0; j < i; j++) {
				tmp = resArr.get(i - 1).get(j);
				res.add(pre + tmp);
				pre = tmp;
			}
			res.add(1);
			resArr.add((ArrayList<Integer>) res.clone());
		}
		return resArr;
	}
}

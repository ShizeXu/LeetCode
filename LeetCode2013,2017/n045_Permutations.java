package LeetCode;

import java.util.ArrayList;

public class n045_Permutations {
	public ArrayList<ArrayList<Integer>> subPermute(int[] num, int index) {
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n < 1 || index == n) {
			resArr.add(res);
			return resArr;
		}
		ArrayList<ArrayList<Integer>> tmpArr = subPermute(num, index + 1);
		for (int i = 0; i < tmpArr.size(); i++) {
			for (int j = 0; j <= tmpArr.get(i).size(); j++) {
				res = (ArrayList<Integer>) tmpArr.get(i).clone();
				res.add(j, num[index]);
				resArr.add((ArrayList<Integer>) res.clone());
			}
		}
		return resArr;
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return subPermute(num, 0);
	}
}

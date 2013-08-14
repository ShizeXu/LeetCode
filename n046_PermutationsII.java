package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class n046_PermutationsII {
	// 试着换一种递归
	public void perm(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int[] num, int[] cnt) {
		int n = num.length;
		int i = 0;
		for (i = 0; i < n; i++) {
			if (cnt[i] > 0)
				break;
		}
		if (i == n) {
			resArr.add((ArrayList<Integer>) res.clone());
			return;
		}
		for (; i < n; i++) {
			if (cnt[i] > 0) { // 扩展的条件
				res.add(num[i]);
				cnt[i]--;
				perm(resArr, res, num, cnt);
				res.remove(res.size() - 1);
				cnt[i]++;
			}
		}
		return;
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		int i = 0;
		for (i = 0; i < n; i++) {
			if (cnt.containsKey(num[i]))
				cnt.put(num[i], cnt.get(num[i]) + 1);
			else
				cnt.put(num[i], 1);
		}
		int[] newNum = new int[cnt.size()];
		int[] newCnt = new int[cnt.size()];
		i = 0;
		for (int t : cnt.keySet()) {
			newNum[i] = t;
			newCnt[i++] = cnt.get(t);
		}
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		perm(resArr, res, newNum, newCnt);
		return resArr;
	}
}
package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class n091_SubsetsII {
	public void subset(ArrayList<ArrayList<Integer>> resArr,
			ArrayList<Integer> res, int[] num, int[] cnt, int n, int i) {
		if (i == n) {
			resArr.add((ArrayList<Integer>) res.clone());
			return;
		}
		if (cnt[i] > 0) { // 选1到多个
			cnt[i]--;
			res.add(num[i]);
			subset(resArr, res, num, cnt, n, i);
			res.remove((Integer) num[i]);
			cnt[i]++;
		}
		subset(resArr, res, num, cnt, n, i + 1); // 不选
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		if (n == 0)
			return resArr;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			tmp.add(num[i]);
		Collections.sort(tmp);
		int[] cnt = new int[n];
		int k = 0;
		int pre = tmp.get(0);
		num[0] = tmp.get(0);
		for (int i = 0; i < n; i++) {
			if (tmp.get(i) != pre) {
				k++;
				num[k] = tmp.get(i);
				pre = num[k];
				cnt[k] = 1;
			} else {
				cnt[k]++;
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		subset(resArr, res, num, cnt, k + 1, 0);
		return resArr;
	}
}

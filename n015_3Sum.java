package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class n015_3Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		Arrays.sort(num);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (int i = 0; i < n - 2; i++) {
			int expect = 0 - num[i];
			int l = i + 1, r = n - 1;
			while (l < r) {
				if (num[l] + num[r] > expect) {
					r--;
				} else if (num[l] + num[r] < expect) {
					l++;
				} else {
					map.put((String.valueOf(num[i]) + "|"
							+ String.valueOf(num[l])
							+ "|" + String.valueOf(num[r])), true);
					r--;
					l++;
				}
			}
		}
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (String s : map.keySet()) {
			String[] arr = s.split("\\|");
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			tmp.add(Integer.parseInt(arr[0]));
			tmp.add(Integer.parseInt(arr[1]));
			tmp.add(Integer.parseInt(arr[2]));
			array.add(tmp);
		}
		return array;
	}

	// 不用map的版本
	public ArrayList<ArrayList<Integer>> threeSumNew(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		Arrays.sort(num);
		for (int i = 0; i < n - 2; i = next(num, i, n - 2, true)) {
			int t = 0 - num[i];
			int l = i + 1, r = n - 1;
			while (l < r) {
				if (num[l] + num[r] < t) {
					l = next(num, l, r, true);
				} else if (num[l] + num[r] > t) {
					r = next(num, l, r, false);
				} else {
					ArrayList<Integer> res = new ArrayList<Integer>();
					res.add(num[i]);
					res.add(num[l]);
					res.add(num[r]);
					resArr.add(res);
					l = next(num, l, r, true);
					r = next(num, l, r, false);
				}
			}
		}
		return resArr;
	}

	int next(int[] num, int l, int r, boolean isLeft) { // 找到不重复的下一个数
		if (isLeft) {
			int i = l + 1;
			while (i < r && num[i] == num[l]) {
				i++;
			}
			return i;
		} else {
			int i = r - 1;
			while (i > l && num[i] == num[r]) {
				i--;
			}
			return i;
		}
	}
}

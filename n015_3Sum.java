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
}

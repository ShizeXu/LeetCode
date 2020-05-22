package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class n017_4Sum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = num.length;
		Arrays.sort(num);
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				int expect = target - num[i] - num[j];
				int l = j + 1;
				int r = n - 1;
				while (l < r) {
					int tmp = num[l] + num[r];
					if (tmp == expect) {
						set.add(String.valueOf(num[i]) + "|"
								+ String.valueOf(num[j])
								+ "|"
								+ String.valueOf(num[l])
								+ "|"
								+ String.valueOf(num[r]));
						l++;
						r--;
					} else if (tmp < expect) {
						l++;
					} else {
						r--;
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
		for (String s : set) {
			String[] arr = s.split("\\|");
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int i = 0; i < 4; i++) {
				tmp.add(Integer.parseInt(arr[i]));
			}
			array.add(tmp);
		}
		return array;
	}
}

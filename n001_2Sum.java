package LeetCode;

import java.util.HashMap;

public class n001_2Sum {
	public int[] twoSum(int[] numbers, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
		int n = numbers.length;
		int[] res = new int[2];
		for (int i = 0; i < n; i++) {
			int tar = target - numbers[i];
			if (mymap.containsKey(tar)) {
				res[1] = i + 1;
				res[0] = mymap.get(tar);
				return res;
			}
			mymap.put(numbers[i], i + 1);
		}
		return null;
	}
}
package LeetCode;

import java.util.ArrayList;

public class n120_Triangle {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = triangle.size();
		if (n == 0)
			return 0;
		ArrayList<Integer> pre = new ArrayList<Integer>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			pre.add(triangle.get(n - 1).get(i)); // 对最后一层初始化
		for (int i = n - 2; i >= 0; i--) {
			tmp.clear();
			for (int j = 0; j <= i; j++) {
				tmp.add(triangle.get(i).get(j) + Math.min(pre.get(j),
						pre.get(j + 1)));
			}
			pre = (ArrayList<Integer>) tmp.clone();
		}
		return pre.get(0);
	}
}
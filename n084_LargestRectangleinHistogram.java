package LeetCode;

import java.util.Stack;

public class n084_LargestRectangleinHistogram {
	class Pair {
		int index;
		int preIndex;

		Pair(int i, int p) {
			index = i;
			preIndex = p;
		}
	}

	// 分三种情况，比前面大的直接压栈，一样的话就忽略，小的话就计算前面的柱能够撑得最大面积。
	// 同时记录下以当前坐标为高所能够到的最早的坐标，以便下次计算。
	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Pair> sta = new Stack<Pair>();
		if (height.length == 0)
			return 0;
		int res = 0;
		int i = 0;
		for (; i < height.length; i++) {
			int preH = sta.isEmpty() ? -1 : height[sta.peek().index];
			if (height[i] > preH) // 情况1
				sta.push(new Pair(i, i));
			else if (height[i] < preH) { // 情况3
				int last = 0;
				do {
					last = sta.pop().preIndex;
					res = Math.max((i - last) * preH, res);
				} while (!sta.isEmpty() && (preH = height[sta.peek().index]) >= height[i]);
				sta.push(new Pair(i, last));
			}
		}
		while (!sta.isEmpty()) {
			Pair cur = sta.pop();
			res = Math.max((i - cur.preIndex) * height[cur.index], res);
		}
		return res;
	}
}
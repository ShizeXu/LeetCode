package LeetCode;

import java.util.ArrayList;

public class n119_PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		if (rowIndex == 0)
			return pre;
		ArrayList<Integer> tmp = new ArrayList<Integer>();

		for (int i = 1; i <= rowIndex; i++) {
			tmp.clear();
			int tmpVal = 0, preVal = 0;
			for (int j = 0; j < i; j++) {
				tmpVal = pre.get(j);
				tmp.add(tmpVal + preVal);
				preVal = tmpVal;
			}
			tmp.add(1);
			pre = (ArrayList<Integer>) tmp.clone();
		}
		return pre;
	}
}

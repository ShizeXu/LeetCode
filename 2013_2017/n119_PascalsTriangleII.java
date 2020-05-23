package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n119_PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		for (int i = 1; i <= rowIndex; i++) {
			int tmpVal = 0, preVal = 0;
			for (int j = 0; j < i; j++) {
				tmpVal = q.poll();
				q.offer(tmpVal + preVal);
				preVal = tmpVal;
			}
			q.offer(1);
		}
		return new ArrayList<Integer>(q);
	}
}

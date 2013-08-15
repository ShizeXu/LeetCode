package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class n055_MergeIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	class mycmp implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return (o1.start < o2.start ? -1 : (o1.start == o2.start ? 0 : 1));
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Collections.sort(intervals, new mycmp()); // 按起始坐标排序，总体O(nlgn)
		int n = intervals.size();
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (n < 1)
			return res;
		int r = intervals.get(0).end;
		int l = intervals.get(0).start;
		for (int i = 1; i < n; i++) {
			int tmpL = intervals.get(i).start;
			int tmpR = intervals.get(i).end;
			if (r < tmpL) {
				res.add(new Interval(l, r));
				l = tmpL;
				r = tmpR;
			} else {
				if (tmpR > r)
					r = tmpR;
			}
		}
		res.add(new Interval(l, r));
		return res;
	}
}
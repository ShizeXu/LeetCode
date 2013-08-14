package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class n126_WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = start.length();
		if (m == 0 || start.equals(end))
			return 1;
		int n = dict.size();
		if (n < 1)
			return 0;
		Queue<String> pre = new LinkedList<String>();
		pre.add(start);
		int res = 1;
		while (pre.size() > 0) {
			int size = pre.size();
			for (int k = 0; k < size; k++) {
				StringBuffer sb = new StringBuffer(pre.poll());
				for (int i = 0; i < m; i++) {
					for (char j = 'a'; j <= 'z'; j++) { // 这样对于大词典还能快一些
						if (j == sb.charAt(i))
							continue;
						char x = sb.charAt(i);
						sb.setCharAt(i, j);
						String str = sb.toString();
						if (str.equals(end))
							return res + 1;
						if (dict.contains(str)) {
							pre.offer(str);
							dict.remove(str);
						}
						sb.setCharAt(i, x);
					}
				}
			}
			res++;
		}
		return 0;
	}
}
package LeetCode;

import java.util.ArrayList;

public class n022_MergekSortedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = lists.size();
		if (n == 0)
			return null;
		ListNode head = null;
		ListNode cur = head;
		double min = Integer.MAX_VALUE + 1.0;
		int mini = -2;
		while (true) {
			min = Integer.MAX_VALUE + 1.0;
			mini = -1;
			for (int i = 0; i < n; i++) {
				ListNode x = lists.get(i);
				if (x != null) {
					int tmp = x.val;
					if (tmp < min) {
						min = tmp;
						mini = i;
					}
				}
			}
			if (mini > -1) {
				if (head == null) {
					head = new ListNode((int) min);
					cur = head;
				} else {
					cur.next = new ListNode((int) min);
					cur = cur.next;
				}
				ListNode l = lists.get(mini);
				lists.set(mini, l.next);
			} else
				break;
		}
		return head;
	}
}
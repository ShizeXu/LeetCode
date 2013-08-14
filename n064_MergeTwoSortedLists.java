package LeetCode;

public class n064_MergeTwoSortedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode res = new ListNode(0);
		ListNode cur = res;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 == null) {
			cur.next = l2;
		} else {
			cur.next = l1;
		}
		return res.next;
	}
}
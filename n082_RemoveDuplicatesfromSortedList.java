package LeetCode;

public class n082_RemoveDuplicatesfromSortedList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (head == null || head.next == null)
			return head;
		ListNode prev = head;
		ListNode cur = prev.next;
		while (cur != null) {
			if (cur.val == prev.val) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
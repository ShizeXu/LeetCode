package LeetCode;

public class n019_RemoveNthNodeFromEndofList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n < 1 || head == null)
			return null;
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode cur = head, pre = newHead;
		while (n > 0 && cur != null) {
			cur = cur.next;
		}
		if (n > 0)
			return null;
		while (cur != null) {
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = pre.next.next;
		return newHead.next;
	}
}
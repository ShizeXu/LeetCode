package LeetCode;

public class n023_SwapNodesinPairs {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode pre = root;
		while (head != null && head.next != null) {
			pre.next = head.next;
			head.next = head.next.next;
			pre.next.next = head;
			pre = head;
			head = head.next;
		}
		return root.next;
	}
}

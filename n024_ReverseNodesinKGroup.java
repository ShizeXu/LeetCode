package LeetCode;

public class n024_ReverseNodesinKGroup {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (k <= 1 || head == null)
			return head;
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode pre = root;
		ListNode cur = head;
		while (true) {
			ListNode tmp = cur;
			int i = 0;
			// whether can rotate
			for (i = 0; i < k; i++) {
				if (tmp == null) {
					break;
				}
				tmp = tmp.next;
			}
			if (i < k)
				break;
			// rotate
			ListNode remain = cur;
			tmp = cur.next;
			ListNode suf = null;
			for (i = 0; i < k - 1; i++) {
				suf = tmp.next;
				tmp.next = cur;
				cur = tmp;
				tmp = suf;
			}
			pre.next = cur;
			remain.next = suf;
			pre = remain;
			cur = suf;
		}
		return root.next;
	}
}

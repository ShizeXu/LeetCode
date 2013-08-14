package LeetCode;

public class n092_ReverseLinkedListII {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (m == n)
			return head;
		int k = n - m;
		m--;
		ListNode n0 = new ListNode(0);
		n0.next = head;
		ListNode n1 = n0;
		while (m > 0) {
			n1 = n1.next;
			m--;
		}
		ListNode n2 = n1.next;
		ListNode n3 = n2;
		ListNode n4 = n2.next;
		ListNode n5 = n4;
		while (k > 0) {
			n5 = n5.next;
			n4.next = n3;
			n3 = n4;
			n4 = n5;
			k--;
		}
		n1.next = n3;
		n2.next = n4;
		return n0.next;
	}
}
package LeetCode;

public class n004_AddTwoNumbers {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ListNode l = new ListNode(0);
		ListNode cur = l;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int a, b;
			if (l1 == null) {
				a = 0;
			} else {
				a = l1.val;
				l1 = l1.next;
			}
			if (l2 == null) {
				b = 0;
			} else {
				b = l2.val;
				l2 = l2.next;
			}
			int tmp = carry + a + b;
			carry = tmp / 10;
			cur.next = new ListNode(tmp % 10);
			cur = cur.next;
		}
		if (carry > 0)
			cur.next = new ListNode(carry);
		return l.next;
	}
}

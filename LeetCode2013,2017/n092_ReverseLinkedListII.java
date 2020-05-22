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
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode cur = head, pre = newHead;
		int k = n - m;
		while (m > 1) {
			pre = cur;
			cur = cur.next;
			m--;
		}
		ListNode tmp = cur.next, preTmp = cur, next = tmp;
		while (k > 0) {
			k--;
			next = tmp.next;
			tmp.next = preTmp;
			preTmp = tmp;
			tmp = next;
		}
		cur.next = next;
		pre.next = preTmp;
		return newHead.next;
	}
}

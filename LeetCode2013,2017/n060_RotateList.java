package LeetCode;

public class n060_RotateList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode rotateRight(ListNode head, int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0 || head == null || head.next == null)
			return head;
		ListNode firstNode = head;
		ListNode secNode = head;
		while (n > 0) {
			n--;
			firstNode = firstNode.next;
			if (firstNode == null)
				firstNode = head; // 循环到头结点
		}
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			secNode = secNode.next;
		}
		firstNode.next = head; // 三个操作
		head = secNode.next;
		secNode.next = null;
		return head;
	}
}

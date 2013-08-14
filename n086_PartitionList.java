package LeetCode;

public class n086_PartitionList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode partition(ListNode head, int x) {
		// Start typing your Java solution below
		// DO NOT write main() function

		ListNode small1 = null, small2 = null, big1 = null, big2 = null;
		while (head != null) {
			ListNode next = head.next; // 记得先备份
			head.next = null; // 在这里就置空了
			if (head.val < x) {
				if (small1 == null) {
					small1 = small2 = head;
				} else {
					small2.next = head;
					small2 = head;
				}
			} else {
				if (big1 == null) {
					big1 = big2 = head;
				} else {
					big2.next = head;
					big2 = head;
				}
			}
			head = next; // 重新赋值
		}
		if (small1 == null)
			return big1;
		small2.next = big1;
		return small1;
	}
}
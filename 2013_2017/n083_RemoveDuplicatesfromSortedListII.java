package LeetCode;

public class n083_RemoveDuplicatesfromSortedListII {
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
		ListNode prev = new ListNode(0); // 当前的前驱节点
		ListNode root = prev; // 整体的前驱节点
		int preVal = head.val;
		ListNode cur = head;
		boolean dup = false;
		while (cur.next != null) {
			if (cur.next.val == preVal) {
				dup = true;
			} else {
				if (!dup) { // 不重复的话就把前驱结点移到当前节点，否则忽略
					prev.next = cur;
					prev = prev.next;
				}
				preVal = cur.next.val;
				dup = false;
			}
			cur = cur.next;
		}
		prev.next = dup ? null : cur; // 处理最后一个节点
		return root.next;
	}
}

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
				cur = cur.next;
			} else {
				if (!dup) { // 不重复的话就把前驱结点移到当前节点，否则忽略
					prev.next = cur;
					prev = prev.next;
				}
				preVal = cur.next.val;
				cur = cur.next;
				dup = false;
			}
		}
		if (dup)
			prev.next = null; // 处理最后一个节点
		else
			prev.next = cur;
		return root.next;
	}
}
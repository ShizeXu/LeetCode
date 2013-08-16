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
		ListNode prev = new ListNode(0); // ��ǰ��ǰ���ڵ�
		ListNode root = prev; // �����ǰ���ڵ�
		int preVal = head.val;
		ListNode cur = head;
		boolean dup = false;
		while (cur.next != null) {
			if (cur.next.val == preVal) {
				dup = true;
			} else {
				if (!dup) { // ���ظ��Ļ��Ͱ�ǰ������Ƶ���ǰ�ڵ㣬�������
					prev.next = cur;
					prev = prev.next;
				}
				preVal = cur.next.val;
				dup = false;
			}
			cur = cur.next;
		}
		prev.next = dup ? null : cur; // �������һ���ڵ�
		return root.next;
	}
}
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
				cur = cur.next;
			} else {
				if (!dup) { // ���ظ��Ļ��Ͱ�ǰ������Ƶ���ǰ�ڵ㣬�������
					prev.next = cur;
					prev = prev.next;
				}
				preVal = cur.next.val;
				cur = cur.next;
				dup = false;
			}
		}
		if (dup)
			prev.next = null; // �������һ���ڵ�
		else
			prev.next = cur;
		return root.next;
	}
}
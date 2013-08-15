package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class n022_MergekSortedLists {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class mycmp implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			return a.val > b.val ? 1 : -1;
		}
	}

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		// Start typing your Java solution below
		// DO NOT write main() function
		PriorityQueue<ListNode> k_heap = new PriorityQueue<ListNode>(16,
				new mycmp());
		ListNode head = new ListNode(0), cur = head;
		for (ListNode node : lists) {
			if (node != null)
				k_heap.offer(node);
		}
		while (!k_heap.isEmpty()) {
			ListNode tmp = k_heap.poll();
			cur.next = tmp;
			cur = cur.next;
			if (tmp.next != null)
				k_heap.offer(tmp.next);
		}
		return head.next;
	}
}
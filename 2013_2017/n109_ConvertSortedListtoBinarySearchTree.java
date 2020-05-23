package LeetCode;

public class n109_ConvertSortedListtoBinarySearchTree {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode build(ListNode head, int end) {
		if (end < 0)
			return null;
		int mid = (end + 1) / 2;
		ListNode cur = head;
		int i = mid;
		while (i > 0) {
			cur = cur.next;
			i--;
		}
		TreeNode root = new TreeNode(cur.val);
		root.left = build(head, mid - 1);
		root.right = build(cur.next, end - 1 - mid); // 截取一半
		return root;
	}

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = 0;
		ListNode tmp = head;
		while (tmp != null) {
			n++;
			tmp = tmp.next;
		}
		return build(head, n - 1);
	}
}

package LeetCode;

public class n117_PopulatingNextRightPointersinEachNodeII {
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		while (root != null) {
			TreeLinkNode next = null;
			TreeLinkNode pre = null;
			while (root != null) {
				if (root.left != null) {
					if (next == null)
						next = root.left;
					if (pre != null)
						pre.next = root.left;
					pre = root.left;
				}
				if (root.right != null) {
					if (next == null)
						next = root.right;
					if (pre != null)
						pre.next = root.right;
					pre = root.right;
				}
				root = root.next;
			}
			root = next;
		}
	}
}

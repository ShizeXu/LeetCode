package LeetCode;

public class n116_PopulatingNextRightPointersinEachNode {
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
		TreeLinkNode next = root.left;
		while (next != null) {
			while (true) {
				root.left.next = root.right;
				if (root.next == null) { // 本层的子节点处理完毕
					root.right.next = null;
					break;
				}
				root.right.next = root.next.left;
				root = root.next;
			}
			root = next; // 父节点下移一层
			next = next.left; // 子节点也下移一层
		}
	}
}

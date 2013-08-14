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
				if (root.next == null) { // ������ӽڵ㴦�����
					root.right.next = null;
					break;
				}
				root.right.next = root.next.left;
				root = root.next;
			}
			root = next; // ���ڵ�����һ��
			next = next.left; // �ӽڵ�Ҳ����һ��
		}
	}
}

package LeetCode;

public class n099_RecoverBinarySearchTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Ref { // ������װ���õ���
		TreeNode ref = null;
	}

	public void find(TreeNode root, Ref pre, Ref first, Ref second) {
		if (root == null)
			return;
		find(root.left, pre, first, second); // ����������
		if (pre.ref != null && pre.ref.val > root.val) { // ��ǰ��ֵ�뵱ǰֵ�Ƚ�
			if (first.ref == null)
				first.ref = pre.ref;
			second.ref = root;
		}
		pre.ref = root;
		find(root.right, pre, first, second); // ����������
	}

	public void recoverTree(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null)
			return;
		Ref pre = new Ref(), first = new Ref(), second = new Ref();
		find(root, pre, first, second);
		if (first.ref != null && second.ref != null) {
			int tmp = first.ref.val;
			first.ref.val = second.ref.val;
			second.ref.val = tmp;
		}
	}
}
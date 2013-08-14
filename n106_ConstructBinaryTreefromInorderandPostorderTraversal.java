package LeetCode;

public class n106_ConstructBinaryTreefromInorderandPostorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode findRoot(int[] inorder, int[] postorder, int i1, int i2,
			int p1, int p2) {
		if (p1 > p2)
			return null;
		TreeNode root = new TreeNode(postorder[p2]);
		if (p1 == p2)
			return root;
		int rootVal = postorder[p2];
		int i = i1;
		for (i = i1; i <= i2; i++) {
			if (inorder[i] == rootVal)
				break; // 找到根节点在中序中的位置 i
		}
		root.left = findRoot(inorder, postorder, i1, i - 1, p1, p1 + i - i1 - 1);
		root.right = findRoot(inorder, postorder, i + 1, i2, p2 - i2 + i,
				p2 - 1);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = inorder.length;
		return findRoot(inorder, postorder, 0, n - 1, 0, n - 1);
	}
}
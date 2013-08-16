package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n102_BinaryTreeLevelOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return resArr;
		Queue<TreeNode> pre = new LinkedList<TreeNode>();
		ArrayList<Integer> valArr = new ArrayList<Integer>();
		pre.add(root);

		while (pre.size() > 0) {
			int n = pre.size();
			for (int i = 0; i < n; i++) {
				TreeNode tmpNode = pre.poll();
				valArr.add(tmpNode.val);
				if (tmpNode.left != null)
					pre.offer(tmpNode.left);
				if (tmpNode.right != null)
					pre.offer(tmpNode.right);
			}
			resArr.add((ArrayList<Integer>) valArr.clone());
			valArr.clear();
		}
		return resArr;
	}
}

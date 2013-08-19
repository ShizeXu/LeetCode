package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class n107_BinaryTreeLevelOrderTraversalII {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 也可用递归，但是代价一样
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return resArr;
		Queue<TreeNode> pre = new LinkedList<TreeNode>();
		ArrayList<Integer> valArr = new ArrayList<Integer>();
		pre.offer(root);
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
		ArrayList<ArrayList<Integer>> realArr = new ArrayList<ArrayList<Integer>>();
		for (int i = resArr.size() - 1; i >= 0; i--) {
			realArr.add(resArr.get(i));
		}
		return realArr;
	}
}

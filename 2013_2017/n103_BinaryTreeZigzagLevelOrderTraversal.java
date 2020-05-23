package LeetCode;

import java.util.ArrayList;

public class n103_BinaryTreeZigzagLevelOrderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> resArr = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return resArr;
		ArrayList<TreeNode> tmp = new ArrayList<TreeNode>();
		ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
		ArrayList<Integer> valArr = new ArrayList<Integer>();
		pre.add(root);
		boolean flag = true;
		while (pre.size() > 0) {
			for (int i = pre.size() - 1; i >= 0; i--) { // 逆序
				TreeNode tmpNode = pre.get(i);
				valArr.add(tmpNode.val);
				if (flag) { // 区分添加顺序
					if (tmpNode.left != null)
						tmp.add(tmpNode.left);
					if (tmpNode.right != null)
						tmp.add(tmpNode.right);
				} else {
					if (tmpNode.right != null)
						tmp.add(tmpNode.right);
					if (tmpNode.left != null)
						tmp.add(tmpNode.left);
				}
			}
			resArr.add((ArrayList<Integer>) valArr.clone());
			valArr.clear();
			pre = (ArrayList<TreeNode>) tmp.clone();
			tmp.clear();
			flag = !flag;
		}
		return resArr;
	}
}

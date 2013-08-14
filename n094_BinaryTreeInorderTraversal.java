package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class n094_BinaryTreeInorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> sta = new Stack<TreeNode>();
		while (root != null || sta.size() > 0) {
			while (root != null) {
				sta.push(root);
				root = root.left;
			}
			root = sta.pop();
			res.add(root.val); // ����Ļ��Ͱ�����Ƶ�pushǰ������Ļ���Ҫ����flag��ʾ��ǰ�ڵ��Ƿ������������
			root = root.right;
		}
		return res;
	}
}
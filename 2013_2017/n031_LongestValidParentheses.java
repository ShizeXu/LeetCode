package LeetCode;

import java.util.Stack;

public class n031_LongestValidParentheses {
	class Item {
		int index;
		char c;

		Item(char x, int i) {
			index = i;
			c = x;
		}
	}

	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Item> sta = new Stack<Item>();
		int n = s.length();
		int max = 0;
		sta.push(new Item(')', -1));
		for (int i = 0; i < n; i++) {
			char x = s.charAt(i);
			if (x == '(')
				sta.push(new Item('(', i));
			else {
				if (sta.peek().c == '(') {
					sta.pop();
					if (i - sta.peek().index > max)
						max = i - sta.peek().index;
				} else
					sta.push(new Item(x, i));
			}
		}
		return max;
	}
}

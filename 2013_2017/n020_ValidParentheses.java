package LeetCode;

import java.util.Stack;

public class n020_ValidParentheses {
	public boolean isValid(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Character> sta = new Stack<Character>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char tmp = s.charAt(i);
			switch (tmp) {
			case '{':
				sta.push(tmp);
				break;
			case '[':
				sta.push(tmp);
				break;
			case '(':
				sta.push(tmp);
				break;
			case '}':
				if (sta.isEmpty() || sta.pop() != '{')
					return false;
				break;
			case ']':
				if (sta.isEmpty() || sta.pop() != '[')
					return false;
				break;
			case ')':
				if (sta.isEmpty() || sta.pop() != '(')
					return false;
				break;
			default:
				return false;
			}
		}
		return sta.isEmpty();
	}
}

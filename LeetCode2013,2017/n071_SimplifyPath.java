package LeetCode;

import java.util.Stack;

public class n071_SimplifyPath {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String[] arr = path.split("/", -1);
		int n = arr.length;
		if (n < 2)
			return path;
		Stack<String> pathName = new Stack<String>();
		for (int i = 0; i < n; i++) {
			String tmp = arr[i].trim();
			if (tmp.equals("") || tmp.equals("."))
				continue; // 过
			if (tmp.equals("..")) { // 出栈
				if (pathName.size() == 0)
					continue;
				pathName.pop();
			} else
				pathName.push(tmp); // 压栈
		}
		String res = "";
		while (pathName.size() > 0) {
			res = "/" + pathName.pop() + res;
		}
		return (res.equals("") ? "/" : res);
	}
}

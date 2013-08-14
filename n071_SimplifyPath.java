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
				continue; // ¹ý
			if (tmp.equals("..")) { // ³öÕ»
				if (pathName.size() == 0)
					continue;
				pathName.pop();
			} else
				pathName.push(tmp); // Ñ¹Õ»
		}
		String res = "";
		while (pathName.size() > 0) {
			res = "/" + pathName.pop() + res;
		}
		return (res.equals("") ? "/" : res);
	}
}
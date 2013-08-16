package LeetCode;

public class n057_LengthofLastWord {
	public int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		String[] arr = s.trim().split(" ");
		if (arr.length < 1)
			return 0;
		return arr[arr.length - 1].length();
	}
}

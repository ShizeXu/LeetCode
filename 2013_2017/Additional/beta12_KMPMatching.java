package Additional;

public class beta12_KMPMatching {
	// O(n)
	int kmpMatch(String a, String b) {
		if (a == null || a == null || b.equals(""))
			return -1;
		int[] next = getNext(b);
		int i = 0, j = 0;
		while (i < a.length()) {
			while (j >= 0 && a.charAt(i) != b.charAt(j))
				j = next[j]; // 递减，因此递减次数不会超过i的递增次数(m)，因此总代价也是2*m = O(m)
			i++;
			j++; // 与i一起递增，O(m)
			if (j == b.length())
				return i - j;
		}
		return -1;
	}

	int[] getNext(String a) {
		int[] next = new int[a.length()];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < a.length() - 1) {
			while (j >= 0 && a.charAt(i) != a.charAt(j))
				j = next[j]; // 递减，O(n)
			next[i++] = j++; // 与i一起递增，O(n)
		}
		return next;
	}
}
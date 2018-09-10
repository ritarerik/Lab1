import java.util.Vector;

// Knuth–Morris–Pratt algorithm

public class KMP {

	public static Vector<Integer> run(String S,  String T) {
		
		int prefixes[] = prefixFunction(T + "¶" + S);		
		Vector<Integer> res = new Vector<>();
		
		for (int i = 0; i < prefixes.length; i++) {			
			if (prefixes[i] == T.length()) {
				res.add(i - 2 * T.length());
			}			
		}
		
		if (res.isEmpty()) res.add(-1);
		
		return res;
		
	}
	
	public static int[] prefixFunction(String S) {
		
		int res[] = new int[S.length()];
		for (int i : res) {
			i = 0;
		}
		
		for (int i = 1; i < S.length(); i++) {
			
			int j = res[i - 1];
			while (j > 0 && S.charAt(i) != S.charAt(j)) {
				j = res[j - 1];
			}
			if (S.charAt(i) == S.charAt(j)) j++;
			res[i] = j;
			
		}		
		
		return res;
		
	}
	
}

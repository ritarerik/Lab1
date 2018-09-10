import java.util.Vector;

// Knuth–Morris–Pratt algorithm

public class KMP {

	public static String run(String S) {
		
		int res[] = prefixFunction(S);
		
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
		return "KMP";
		
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

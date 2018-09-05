import java.util.Vector;

// Rabin–Karp algorithm

public class RK {

	public static Vector<Integer> run(String S, String T) {
		
		Vector<Integer> res = new Vector<>();
		
		int len = T.length();
		
		String text = S.substring(0, len);
		
		int subHash = getHash(T);
		int textHash = getHash(text);
		
		for (int i = 0; i < S.length() - len; i++) {
			
			if (subHash == textHash) {
				
				// ïîñèìâîëüíîå ñðàâíåíèå
				boolean equal = true;
				for (int j = 0; j < len; j++) {					
					if (T.charAt(j) != text.charAt(j)) {
						equal = false;
						break;
					} 					
				}
				
				if (equal) {
					res.add(i);
				}
				
			}
			
		}
		
		return res;
		
	}
	
	private static int getHash(String s) {
		
		int n = 0;		
		int q = 1;
		
		for (int i = 0; i < s.length(); i++) {			
			n += ((int) s.charAt(i)) + Math.pow(2, s.length() - i - 1);			
		}
		
		return n % q;
		
	}
	
}

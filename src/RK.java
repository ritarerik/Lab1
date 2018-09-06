import java.util.Vector;

// RabinЦKarp algorithm

public class RK {

	public static Vector<Integer> run(String S, String T) {
		
		Vector<Integer> res = new Vector<>();
		
		int len = T.length();
		
		String text = "";
		int textHash = 0;
		int subHash = getHash(S, T, 0, 0);		
		
		for (int i = -1; i < S.length() - len; i++) {
			
			text = S.substring(i + 1, i + len + 1);
			textHash = getHash(S, text, textHash, i + len);
			
			if (subHash == textHash) {				
				boolean equal = true;
				if (!T.equals(text)) {
					equal = false;
					break;
				}				
				if (equal) res.add(i + 1);				
			}

		}
		
		return res;
		
	}
	
	private static int getHash(String S, String sub, int prevHash, int index) {
		
		int q = 65713; // простое число		
		int hash = 0;		
		
		if (prevHash == 0) { // вычисл€ем первый хэш
			
			for (int i = 0; i < sub.length(); i++) {			
				hash += (((int) sub.charAt(i)) * Math.pow(2, sub.length() - i - 1)) % q;			
			}
			
		} else { // вычисл€ем последующие окна
			
			hash = prevHash - (int)sub.charAt(0)%q + (int)S.charAt(index)%q;
			
		}
		
		return hash;
		
	}
	
}

import java.util.Vector;

// RabinЦKarp algorithm

public class RK {

	public static Vector<Integer> run(String S, String T) {
		
		Vector<Integer> res = new Vector<>();
		
		int len = T.length();
		
		String text = "";
		int textHash = 0;
		int subHash = getHash(S, T, 0, 0, 0);		
		
		for (int i = -1; i < S.length() - len; i++) {
			
			text = S.substring(i + 1, i + len + 1);
			textHash = getHash(S, text, textHash, i, i + len);
			
			if (subHash == textHash) {				
				boolean equal = true;
				if (!T.equals(text)) {
					equal = false;
					break;
				}				
				if (equal) res.add(i + 1);				
			}

		}
		
		if (res.isEmpty()) res.add(-1);
		
		return res;
		
	}
	
	private static int getHash(String S, String sub, int prevHash, int i_1, int i_2) {
		
		int d = 52;
		int q = 65713; // простое число	( 65713	)
		int hash = 0;		
		
//		if (prevHash == 0) { // вычисл€ем первый хэш
			
			for (int i = 0; i < sub.length(); i++) {			
				hash += (((int) sub.charAt(i)) * Math.pow(2, sub.length() - i - 1)) % q;			
			}
			
//		} else { // вычисл€ем последующие окна
//			
//			char c = S.charAt(i_1);
//			char c_ = S.charAt(i_2);
//			//hash = prevHash - (int)S.charAt(i_1) + (int)S.charAt(i_2);
//			
//			hash = (int)((prevHash - (int)S.charAt(i_1)) + (int)S.charAt(i_2) * Math.pow(2, sub.length() - 1)) % q;
//			
//		}
		
		return hash;
		
	}
	
}

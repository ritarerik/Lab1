import java.util.Vector;

// KnuthЦMorrisЦPratt algorithm

public class KMP {

	public static Vector<Integer> run(String S,  String T) {
		
		// "склеивание" искомой подстроки, разделител€ и исходной строки
		// и вычисление префикс-функции дл€ полученной строки 
		int pref[] = prefixFunction(T + "ґ" + S);		
		Vector<Integer> res = new Vector<>();
		
		for (int i = 0; i < pref.length; i++) {
			// если длина максимального префикса равна длине искомой подстроки, то
			// добавление позиции начала суффикса в массив
			if (pref[i] == T.length()) res.add(i - 2 * T.length()); 
		}
		
		// если совпадений не найдено, то возращение позиции -1
		if (res.isEmpty()) res.add(-1);
		
		return res;
		
	}
	
	// вычисление префикс-функции -- длина максимального префикса строки, 
	// который одновременно €вл€етс€ суффиксом
	public static int[] prefixFunction(String S) {
		
		int res[] = new int[S.length()];
		//for (int i : res) i = 0; // заполнение нул€ми
		
		for (int i = 1; i < S.length(); i++) {
			
			// текуща€ длина префикса, который надо продолжить
			int j = res[i - 1];
			
			// пока нельз€ продолжить текущий префикс --
			// уменьшаем его длину до следующей возможной
			while ((j > 0) && (S.charAt(i) != S.charAt(j))) j = res[j - 1];
			
			// теперь j -- максимальна€ длина префикса, который можно продолжить,
			// или 0, если такого не существует
			if (S.charAt(i) == S.charAt(j)) j++;
			
			// заносим в результирующий массив j
			res[i] = j;
			
		}	
		
		return res;
		
	
	}
	
}

import java.util.Vector;

// Knuth�Morris�Pratt algorithm

public class KMP {

	public static Vector<Integer> run(String S,  String T) {
		
		// "����������" ������� ���������, ����������� � �������� ������
		// � ���������� �������-������� ��� ���������� ������ 
		int pref[] = prefixFunction(T + "�" + S);		
		Vector<Integer> res = new Vector<>();
		
		for (int i = 0; i < pref.length; i++) {
			// ���� ����� ������������� �������� ����� ����� ������� ���������, ��
			// ���������� ������� ������ �������� � ������
			if (pref[i] == T.length()) res.add(i - 2 * T.length()); 
		}
		
		// ���� ���������� �� �������, �� ���������� ������� -1
		if (res.isEmpty()) res.add(-1);
		
		return res;
		
	}
	
	// ���������� �������-������� -- ����� ������������� �������� ������, 
	// ������� ������������ �������� ���������
	public static int[] prefixFunction(String S) {
		
		int res[] = new int[S.length()];
		//for (int i : res) i = 0; // ���������� ������
		
		for (int i = 1; i < S.length(); i++) {
			
			// ������� ����� ��������, ������� ���� ����������
			int j = res[i - 1];
			
			// ���� ������ ���������� ������� ������� --
			// ��������� ��� ����� �� ��������� ���������
			while ((j > 0) && (S.charAt(i) != S.charAt(j))) j = res[j - 1];
			
			// ������ j -- ������������ ����� ��������, ������� ����� ����������,
			// ��� 0, ���� ������ �� ����������
			if (S.charAt(i) == S.charAt(j)) j++;
			
			// ������� � �������������� ������ j
			res[i] = j;
			
		}	
		
		return res;
		
	
	}
	
}

import java.util.Scanner;
import java.util.Vector;

public class MainClass {
	
	
	public static void main(String args[])
	{
		
		boolean exit = false;		
		while (!exit) {
			
			System.out.println("> Z-������� > 1");
			System.out.println("> �������� ����� � ������� � ������ > 2");
			System.out.println("> �������� ������ � ����� > 3");
			System.out.println("> ______________________________________");
			System.out.println("> ����� > 4");
			
			//-----------------------------------------------------------//
			Scanner in = new Scanner(System.in);			
			System.out.print("\n>> ");
			
			//-----------------------------------------------------------//
	        
			int num = 0;
			String res = "";
			try {
				num = in.nextInt();		        
	        } catch (Exception e) {
	        	continue;
	        }
			
	        //-----------------------------------------------------------//
			System.out.print("\n>> ������ > ");
			in = new Scanner(System.in);
	        String S = in.nextLine().toLowerCase();
	        String T = "";
	        Vector<Integer> V = new Vector<>();
	        
	        //-----------------------------------------------------------//
	        switch(num) {     
	        	case 1:
		        	
		        	int[] Z =  ZFunction.run(S);
		        				        
		        	res += "[";
			        for (int i = 0; i < Z.length; i++) {			        	
			        	res += Z[i];			        			
			        	if (i < Z.length - 1) res += ", "; 
			        }
			        res += "]\n\n";
			        
			        break;
		        	
		        //-----------------------------------------------------------//	
		        case 2:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> ��������� > ");				
			        T = in.nextLine().toLowerCase();
			        
			        if (S.contains("�")) {
			        	System.out.println(">> ������ �������� ����������� ������ �");
			        } else if (T.contains("�")) {
			        	System.out.println(">> ��������� �������� ����������� ������ �");
			        } else {
				        V = new Vector<>();
				        V = KMP.run(S, T);
				        res += "[";
				        for (int i = 0; i < V.size(); i++) {
				        	if (V.get(i) != -1) {			        	
					        	res += V.get(i);			        			
					        	if (i < V.size() - 1) res += ", "; 
				        	} else res += " ���������� �� ������� ";
				        }				        
				        res += "]\n\n";				        
			        }
			        
			        break;
		        	
		       	//-----------------------------------------------------------//	
		        case 3:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> ��������� > ");				
			        T = in.nextLine().toLowerCase();
		        	
		        	V = new Vector<>();
			        V = RK.run(S, T);
			        res += "[";
			        for (int i = 0; i < V.size(); i++) {
			        	if (V.get(i) != -1) {			        	
				        	res += V.get(i);			        			
				        	if (i < V.size() - 1) res += ", "; 
			        	} else res += " ���������� �� ������� ";
			        }
			        
			        res += "]\n\n";
			        break;
		        	
		        default:
		        	exit = true;
		        	break;
	        	
	        }
	        
	        //-----------------------------------------------------------//
        	System.out.print("\n> ��������� > ");
	        System.out.println(res);
	        
		}
		
		
		
	}
	
}

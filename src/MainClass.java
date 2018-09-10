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
	        in = new Scanner(System.in);				
			System.out.print("\n>> ������ > ");				
	        String S = in.nextLine().toLowerCase();
	        
	        //-----------------------------------------------------------//
	        switch(num) {     
	        	case 1:
		        	
		        	int[] Z =  ZFunction.run(S);
		        				        
		        	res += "[";
			        for (int i = 0; i < Z.length; i++) {			        	
			        	res += Z[i];			        			
			        	if (i < Z.length - 1) {
			        		res += ", "; 
			        	}			        	
			        }
			        res += "]\n\n";
		        	
		        	break;
		        	
		        //-----------------------------------------------------------//	
		        case 2:
		        	
		        	res = "\n" + KMP.run(S) + "\n";
		        	break;
		        	
		       	//-----------------------------------------------------------//	
		        case 3:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> ��������� > ");				
			        String T = in.nextLine().toLowerCase();
		        	
		        	Vector<Integer> H = new Vector<>();
			        H = RK.run(S, T);
			        res += "[";
			        for (int i = 0; i < H.size(); i++) {
			        	
			        	if (H.get(i) != -1) {			        	
				        	res += H.get(i);			        			
				        	if (i < H.size() - 1) {
				        		res += ", "; 
				        	}
			        	} else {
			        		res += " ���������� �� ������� ";
			        	}			        	
			        	
			        }
			        
			        res += "]\n\n";
		        	break;
		        	
		        default:
		        	exit = true;
		        	break;
	        	
	        }
	        
	        //-----------------------------------------------------------//
        	System.out.print("\n>> ��������� > ");
	        System.out.println(res);
	        
		}
		
		
		
	}
	
}

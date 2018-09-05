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
			
			Scanner in = new Scanner(System.in);
			
			System.out.print("\n>> ");
			
	        int num = in.nextInt();
	        String res = "";
	        
	        switch(num) {	        
	        
		        case 1:
		        	
		        	in = new Scanner(System.in);				
					System.out.print("\n>> ������ > ");				
			        String S = in.nextLine();	        	
		        	
		        	int[] Z =  ZFunction.run(S);
		        	
		        	System.out.print("\n>> ��������� > ");			        
		        	res += "[";
			        for (int i = 0; i < Z.length; i++) {			        	
			        	res += Z[i];			        			
			        	if (i < Z.length - 1) {
			        		res += ", "; 
			        	}			        	
			        }
			        res += "]\n\n";
		        	
		        	break;
		        	
		        case 2:
		        	
		        	res = "\n" + KMP.run() + "\n";
		        	break;
		        	
		        case 3:
		        	
		        	res = "\n" + RK.run() + "\n";
		        	break;
		        	
		        default:
		        	exit = true;
		        	break;
	        	
	        }
	        
	        System.out.println(res);
	        
		}
		
		
		
	}
	
}

import java.util.Scanner;

public class MainClass {
	
	
	public static void main(String args[])
	{
		
		boolean exit = false;
		
		while (!exit) {
			
			System.out.println("> Z-функция > 1");
			System.out.println("> Алгоритм Кнута — Морриса — Пратта > 2");
			System.out.println("> Алгоритм Рабина — Карпа > 3");
			System.out.println("> ______________________________________");
			System.out.println("> Выход > 4");
			
			Scanner in = new Scanner(System.in);
			
			System.out.print("\n>> ");
			
	        int num = in.nextInt();
	        String res = "";
	        
	        switch(num) {	        
	        case 1:
	        	
	        	res = "\n" + ZFunction.run() + "\n";
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

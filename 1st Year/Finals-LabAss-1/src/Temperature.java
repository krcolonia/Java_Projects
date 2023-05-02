import java.text.DecimalFormat;
import java.util.Scanner;

public class Temperature {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###,###,##0.0");
		
		double f, c, fFormula, cFormula;
		boolean isDone=true;
		char choiceTaken;
		
		do{
			f=0;
			c=0;
			
			System.out.println("Main Menu");
			System.out.println("a. Celsius to Farenheit");
			System.out.println("b. Farenheit to Celsius");
			System.out.println("c. Exit");
			
			System.out.print("\nChoose option [a, b, c]: ");
			choiceTaken = input.next().charAt(0);
			choiceTaken = Character.toUpperCase(choiceTaken);
			
			switch(choiceTaken) {
			case 'A' : System.out.println("\nCelsius - Farenheit Conversion");
						System.out.print("Enter Celsius: ");
						c = input.nextDouble();
						fFormula = (9.0/5.0 * c) + 32.0;
						System.out.println("Farenheit equivalent is " + df.format(fFormula) + "\n");
						break;
						
			case 'B' : System.out.println("\nFarenheit - Celsius Conversion");
						System.out.print("Enter Farenheit: ");
						f = input.nextDouble();
						cFormula = (f - 32.0) * 5.0/9.0;
						System.out.println("Farenheit equivalent is " + df.format(cFormula) + "\n");
						break;
						
			case 'C' : System.out.println("\nEnd of program. Good bye!");
						isDone=false;
						break;
			default : System.out.println("\nError: Invalid Output. Ending Program. Good bye!");
						isDone=false;
			}
		}while(isDone);
		
		input.close();
	}

}

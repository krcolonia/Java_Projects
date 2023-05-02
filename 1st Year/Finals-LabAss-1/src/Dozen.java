import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Dozen {

	public static void main(String[] args) {
		/* Imported Utilities */
		DecimalFormat df = new DecimalFormat("###");
		df.setRoundingMode(RoundingMode.DOWN);
		Scanner input = new Scanner(System.in);
		
		/* Variables */
		double eggsInput, dozen, remainder;
		
		/* Input */
		System.out.print("Enter number of eggs: ");
		eggsInput = input.nextDouble();
		
		dozen=determineDozen(eggsInput);
		remainder=showLessDozen(eggsInput);
		
		/* Prints output to Console */
		System.out.println();
		System.out.println("Number of Dozen: " + df.format(dozen));
		System.out.println("Eggs less than a dozen: " + df.format(remainder));
		
		input.close();
	}
	
	public static double determineDozen(double dozen) {
		return dozen/12; //determines number of dozens
	}
	
	public static double showLessDozen(double remainder) {
		return remainder%12; //computes left over eggs less than 12
	}
	
}

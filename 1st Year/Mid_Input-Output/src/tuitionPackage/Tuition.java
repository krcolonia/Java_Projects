package tuitionPackage;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Tuition {

	public static void main(String[] args) {
		
		/* Imported Utilities */
		Scanner input = new Scanner(System.in);
		DecimalFormat dformat = new DecimalFormat("###,###,###.00 dollars");
		
		/* Variables */
		String nameOfStudent;
		double numberOfUnits, pricePerUnit;
		
		/* Input-Output */
		System.out.print("Enter name of student: ");
		nameOfStudent = input.nextLine();
		
		System.out.print("Enter number of units enrolled: ");
		numberOfUnits = input.nextDouble();
		
		System.out.print("Enter price per unit: ");
		pricePerUnit = input.nextDouble();
		
		double computedPrice = numberOfUnits*pricePerUnit;
		
		System.out.println("\nComputed Tuition Fee: " + dformat.format(computedPrice));
		System.out.println(nameOfStudent + ", you could avail the following payment mode:");
		
		
		/* Payment Methods */
		System.out.println("\nPayment Mode:");
		
		/* Cash Payment Method*/
		double cpDiscount = computedPrice*0.10, cpPrice = computedPrice-cpDiscount;
		System.out.println("Cash Payment: " + dformat.format(cpPrice));
		
		/* 2-Installment Payment Method */
		double twoInstallPenalty = computedPrice*0.05, twoInstallPrice = computedPrice + twoInstallPenalty;
		System.out.println("2-Installment: " + dformat.format(twoInstallPrice));
		
		/* 3-Installment Payment Method */
		double threeInstallPenalty = computedPrice*0.10, threeInstallPrice = computedPrice + threeInstallPenalty;
		System.out.println("3-Installment: " + dformat.format(threeInstallPrice));
		
		/*
		 * Program made by Kurt Robin P. Colonia
		 * 1st Year, Bachelor in Science in Information Technology
		 * Requirement for the course "Fundamentals of Programming"
		 */
		
		}

}

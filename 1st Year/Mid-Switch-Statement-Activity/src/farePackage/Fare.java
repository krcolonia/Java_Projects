package farePackage;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Fare {

	public static void main(String[] args) {
		/* Imported Utilities */
		Scanner input=new Scanner(System.in);
		DecimalFormat priceFormat=new DecimalFormat("###,###,##0.00");
		
		/* Variables */
		double farePrice=0, fareDiscountRate=0, fareDiscount=0, fareClassRate=0, fareNetPrice=0;
		char passengerCode, businessClass;
		
		/* Inputs for Program */
		System.out.print("Enter fare: ");
		farePrice=input.nextDouble();
		
		System.out.print("Passenger Type "+
						"[O: Ordinary, S: Student, C: Senior Citizen]: ");
		passengerCode=input.next().charAt(0);
		passengerCode=Character.toUpperCase(passengerCode);
		
		System.out.print("Travelling in Business Class? "+
						"[Y/N]: ");
		businessClass=input.next().charAt(0);
		businessClass=Character.toUpperCase(businessClass);
		
		/* Switch-Case Statement for the Passenger Type Discount Rate and Business Class Rate */
		switch(passengerCode)
		{
				case 'O': 
							fareDiscountRate=0.0;
							switch(businessClass)
							{
									case 'Y': fareClassRate=1000;
												break;
									default: fareClassRate=0;
							}
							break;
				case 'S': 
							fareDiscountRate=0.05;
							switch(businessClass)
							{
									case 'Y': fareClassRate=700;
												break;
									default: fareClassRate=0;
							}
							break;
				case 'C': 
							fareDiscountRate=0.10;
							switch(businessClass)
							{
									case 'Y': fareClassRate=500;
												break;
									default: fareClassRate=0;
							}
							break;
				default:
							farePrice=0;
							fareDiscountRate=0;
							fareClassRate=0;
		}
		
		/* Computations */
		fareDiscount=farePrice*fareDiscountRate;
		fareNetPrice=farePrice-fareDiscount+fareClassRate;
		
		/* Outputs, Business class charge only shows when you type "Y" */
		System.out.println("\nDiscount is: " + priceFormat.format(fareDiscount));
		if(fareClassRate>0)
		{
			System.out.println("Business class charge: " + priceFormat.format(fareClassRate));
		}
		System.out.println("New Fare: " + priceFormat.format(fareNetPrice));
		
		
		/* Program coded by Kurt Robin P. Colonia
		 * 1st year, Bachelor in Science in Information Technology
		 */
	}

}

package practicalExam;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Cellphone {

	public static void main(String[] args) {
		/* Imported Utilities */
		Scanner input = new Scanner(System.in);
		DecimalFormat dformat = new DecimalFormat("$###,###,##0.00");
		
		/* Initialized Variables */
		String prod1, prod2, prod3;
		char model1, model2, model3, itemInput;
		double price1=0.0, price2=0.0, price3=0.0, payMode1=0.0, payMode2=0.0, payMode3=0.0, payMode4=0.0, totalAmount=0.0, monthlyAmortization=0.0;
		int cashDiscount=0, interest3=0, interest6=0, interest12=0, modeOfPay=0;
		
		/* Product Inputs */
		System.out.println("Sales Input:\n");
		
		System.out.print("Enter Product 1:\t");
		prod1 = input.nextLine();
		model1 = prod1.charAt(0);
		model1 = Character.toUpperCase(model1);
		System.out.print("Enter Price:\t\t$");
		price1 = input.nextDouble();
		
		System.out.println("");
		input.nextLine(); // Added to prevent the next String input from being skipped.
		
		System.out.print("Enter Product 2:\t");
		prod2 = input.nextLine();
		model2 = prod2.charAt(0);
		model2 = Character.toUpperCase(model2);
		System.out.print("Enter Price:\t\t$");
		price2 = input.nextDouble();

		System.out.println("");
		input.nextLine(); // Again, added to prevent the next String input from being skipped.
		
		System.out.print("Enter Product 3:\t");
		prod3 = input.nextLine();
		model3 = prod3.charAt(0);
		model3 = Character.toUpperCase(model3);
		System.out.print("Enter Price:\t\t$");
		price3 = input.nextDouble();
		
		/* Mode of Payment Input */
		System.out.println("\n\nInput Mode of Payment Terms\n");
		
		System.out.print("Cash Discount:\t\t");
		cashDiscount = input.nextInt();
		System.out.println("\tYou input " + cashDiscount + "% Discount for Cash\n");
		
		System.out.print("3 Months Installment:\t");
		interest3 = input.nextInt();
		System.out.println("\tYou input " + interest3 + "% Interest for 3 Months Installment\n");
		
		System.out.print("6 Months Installment:\t");
		interest6 = input.nextInt();
		System.out.println("\tYou input " + interest6 + "% Interest for 6 Months Installment\n");
		
		System.out.print("12 Months Installment:\t");
		interest12 = input.nextInt();
		System.out.println("\tYou input " + interest12 + "% Interest for 12 Months Installment\n");
		
		/* Main Menu */
		System.out.println("\nMain Menu\n");
		
		System.out.print("Press " + model1);
		model1 = Character.toLowerCase(model1);
		System.out.println("/" + model1 + ": " + prod1 + "\t\t" + dformat.format(price1));
		
		System.out.print("Press " + model2);
		model2 = Character.toLowerCase(model2);
		System.out.println("/" + model2 + ": " + prod2 + "\t" + dformat.format(price2));
		
		System.out.print("Press " + model3);
		model3 = Character.toLowerCase(model3);
		System.out.println("/" + model3 + ": " + prod3 + "\t" + dformat.format(price3));
		
		
		System.out.println("");
		input.nextLine();
		
		System.out.print("Enter Item:\t");
		itemInput = input.next().charAt(0);
		itemInput = Character.toUpperCase(itemInput);
		
		switch(itemInput) {
			case 'I': System.out.println("Your Item is " + prod1);
					System.out.println("Price:\t\t" + dformat.format(price1));
					
					System.out.println("\n\nSelect Mode of Payment\n");
					
					System.out.println("Press 1: Cash\t\t\t" + cashDiscount + "% Discount");
					System.out.println("Press 2: 3 Months Installment\t" + interest3 + "% Interest");
					System.out.println("Press 3: 6 Months Installment\t" + interest6 + "% Interest");
					System.out.println("Press 4: 12 Months Installment\t" + interest12 + "% Interest");
					
					System.out.println("");
					
					System.out.print("Enter Mode of Payment:\t\t");
					modeOfPay = input.nextInt();
					switch(modeOfPay)
					{
					case 1: payMode1 = price1 * (cashDiscount/100.00);
							totalAmount = price1 - payMode1;
							System.out.println("Mode of Payment:\t\t" + "Cash");
							System.out.println("Item:\t\t\t\t" + prod1);
							System.out.println("Price:\t\t\t\t" + dformat.format(price1));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode1));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 2: payMode2 = price1 * (interest3/100.00);
							totalAmount = price1 + payMode2;
							monthlyAmortization = totalAmount/3.0;
							System.out.println("Mode of Payment:\t\t" + "3 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod1);
							System.out.println("Price:\t\t\t\t" + dformat.format(price1));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode2));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 3: payMode3 = price1 * (interest6/100.00);
							totalAmount = price1 + payMode3;
							monthlyAmortization = totalAmount/6.0;
							System.out.println("Mode of Payment:\t\t" + "6 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod1);
							System.out.println("Price:\t\t\t\t" + dformat.format(price1));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode3));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 4: payMode4 = price1 * (interest12/100.00);
							totalAmount = price1 + payMode4;
							monthlyAmortization = totalAmount/12.0;
							System.out.println("Mode of Payment:\t\t" + "12 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod1);
							System.out.println("Price:\t\t\t\t" + dformat.format(price1));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode4));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					default: System.out.println("Invalid Option");
					}
					break;
					
			case 'S': System.out.println("Your Item is " + prod2);
					System.out.println("Price:\t\t" + dformat.format(price2));
					
					System.out.println("\n\nSelect Mode of Payment\n");
					
					System.out.println("Press 1: Cash\t\t\t" + cashDiscount + "% Discount");
					System.out.println("Press 2: 3 Months Installment\t" + interest3 + "% Interest");
					System.out.println("Press 3: 6 Months Installment\t" + interest6 + "% Interest");
					System.out.println("Press 4: 12 Months Installment\t" + interest12 + "% Interest");
					
					System.out.println("");
					
					System.out.print("Enter Mode of Payment:\t\t");
					modeOfPay = input.nextInt();
					switch(modeOfPay)
					{
					case 1: payMode1 = price2 * (cashDiscount/100.00);
							totalAmount = price2 - payMode1;
							System.out.println("Mode of Payment:\t\t" + "Cash");
							System.out.println("Item:\t\t\t\t" + prod2);
							System.out.println("Price:\t\t\t\t" + dformat.format(price2));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode1));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 2: payMode2 = price2 * (interest3/100.00);
							totalAmount = price2 + payMode2;
							monthlyAmortization = totalAmount/3.0;
							System.out.println("Mode of Payment:\t\t" + "3 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod2);
							System.out.println("Price:\t\t\t\t" + dformat.format(price2));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode2));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 3: payMode3 = price2 * (interest6/100.00);
							totalAmount = price2 + payMode3;
							monthlyAmortization = totalAmount/6.0;
							System.out.println("Mode of Payment:\t\t" + "6 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod2);
							System.out.println("Price:\t\t\t\t" + dformat.format(price2));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode3));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 4: payMode4 = price2 * (interest12/100.00);
							totalAmount = price2 + payMode4;
							monthlyAmortization = totalAmount/12.0;
							System.out.println("Mode of Payment:\t\t" + "12 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod2);
							System.out.println("Price:\t\t\t\t" + dformat.format(price2));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode4));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					default: System.out.println("Invalid Option");
					}
					break;
					
			case 'X': System.out.println("Your Item is " + prod3);
					System.out.println("Price:\t\t" + dformat.format(price3));
					
					System.out.println("\n\nSelect Mode of Payment\n");
					
					System.out.println("Press 1: Cash\t\t\t" + cashDiscount + "% Discount");
					System.out.println("Press 2: 3 Months Installment\t" + interest3 + "% Interest");
					System.out.println("Press 3: 6 Months Installment\t" + interest6 + "% Interest");
					System.out.println("Press 4: 12 Months Installment\t" + interest12 + "% Interest");
					
					System.out.println("");
					
					System.out.print("Enter Mode of Payment:\t\t");
					modeOfPay = input.nextInt();
					switch(modeOfPay)
					{
					case 1: payMode1 = price3 * (cashDiscount/100.00);
							totalAmount = price3 - payMode1;
							System.out.println("Mode of Payment:\t\t" + "Cash");
							System.out.println("Item:\t\t\t\t" + prod3);
							System.out.println("Price:\t\t\t\t" + dformat.format(price3));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode1));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 2: payMode2 = price3 * (interest3/100.00);
							totalAmount = price3 + payMode2;
							monthlyAmortization = totalAmount/3.0;
							System.out.println("Mode of Payment:\t\t" + "3 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod3);
							System.out.println("Price:\t\t\t\t" + dformat.format(price3));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode2));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 3: payMode3 = price3 * (interest6/100.00);
							totalAmount = price3 + payMode3;
							monthlyAmortization = totalAmount/6.0;
							System.out.println("Mode of Payment:\t\t" + "6 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod3);
							System.out.println("Price:\t\t\t\t" + dformat.format(price3));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode3));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					case 4: payMode4 = price3 * (interest12/100.00);
							totalAmount = price3 + payMode4;
							monthlyAmortization = totalAmount/12.0;
							System.out.println("Mode of Payment:\t\t" + "12 Months Installment");
							System.out.println("Item:\t\t\t\t" + prod3);
							System.out.println("Price:\t\t\t\t" + dformat.format(price3));
							System.out.println("Discount/Interest:\t\t" + dformat.format(payMode4));
							System.out.println("Total Amount:\t\t\t" + dformat.format(totalAmount));
							System.out.println("Monthly Amortization:\t\t" + dformat.format(monthlyAmortization));
							break;
					default: System.out.println("Invalid Option");
					}
					break;
					
			default: System.out.println("Invalid Option");
		}
		
		input.close();
		
		/*
		 * Programmed by Kurt Robin Colonia
		 * From 1-BSIT-2
		 * Midterms Laboratory Examination
		 */
	}

}
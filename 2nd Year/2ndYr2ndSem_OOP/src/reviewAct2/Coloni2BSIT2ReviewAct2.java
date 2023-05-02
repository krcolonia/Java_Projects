package reviewAct2;

import java.util.*;

public class Coloni2BSIT2ReviewAct2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean willRun = true;
		boolean willContinue;
		
		ArrayList<String> beverageName = new ArrayList<String>();
	    beverageName.add("Coke");
	    beverageName.add("Royale");
	    beverageName.add("Sprite");
	    beverageName.add("Sarsi");
	    
	    ArrayList<Integer> beveragePrice = new ArrayList<Integer>();
	    beveragePrice.add(20);
	    beveragePrice.add(23);
	    beveragePrice.add(19);
	    beveragePrice.add(25);
	    
	    ArrayList<String> customerReceipt = new ArrayList<String>();
	    
	    Integer sum=0;
	    
	    while(willRun) {
	    	System.out.print("Beverage Available: ");
		    
		    for(int i=0; i<4; i++) {
		    	System.out.print(beverageName.get(i) + " = P" + beveragePrice.get(i));
		    	if(i<beverageName.size()-1)
		    		System.out.print(", ");
		    }
		    
		    System.out.print("\n\nPurchase Beverage: ");
		    String inp = input.nextLine().toUpperCase();
		    
		    switch(inp) {
		    case "COKE":
		    	customerReceipt.add(beverageName.get(0) + "\t\tPhp " + beveragePrice.get(0));
		    	sum += beveragePrice.get(0);
		    	break;
		    case "ROYALE":
		    	customerReceipt.add(beverageName.get(1) + "\t\tPhp " + beveragePrice.get(1));
		    	sum += beveragePrice.get(1);
		    	break;
		    case "SPRITE":
		    	customerReceipt.add(beverageName.get(2) + "\t\tPhp " + beveragePrice.get(2));
		    	sum += beveragePrice.get(2);
		    	break;
		    case "SARSI":
		    	customerReceipt.add(beverageName.get(3) + "\t\tPhp " + beveragePrice.get(3));
		    	sum += beveragePrice.get(3);
		    	break;
		    default:
		    	System.out.println("Invalid Input. Drink not available");
		    }
		    
		    willContinue=true;
		    
		    while(willContinue) {
		    	System.out.print("Do you want to add more? [Yes / No] ");
			    String continueInput = input.nextLine().toUpperCase();
			    
			    switch(continueInput) {
			    case "YES":
			    	willRun = true;
			    	willContinue = false;
			    	break;
			    case "NO":
			    	willRun = false;
			    	willContinue = false;
			    	break;
			    default:
			    	System.out.println("Invalid Input. Please only input Yes or No");
			    	willContinue = true;
			    }
		    }
		    System.out.println("");
	    }
	   
	    System.out.println("Please Pay your Beverage");
	    for(int i = 0; i < customerReceipt.size(); i++) {
	    	System.out.println(customerReceipt.get(i));
	    }
	    System.out.println("Total Amount:\tPhp " + sum);
	    input.close();
	}
}

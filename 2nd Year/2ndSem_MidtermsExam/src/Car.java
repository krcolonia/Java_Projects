public class Car {
	/* Owner Information and Car Year Model */
	public static String ownName;
	public static int ownYrMdl;
	
	/* Car Upgrade Values */
	public static int availAmount;
	public static int availAmountAfter;
	public static int amountAC;
	public static int amountLeatherSeats;
	public static int amountBackWipers;
	public static int amountFogLights;
	
	/* Booleans for Output */
	public static boolean hasACUpgrade;
	public static boolean hasLeatherSeatsUpgrade;
	public static boolean hasBackWipersUpgrade;
	public static boolean hasFogLightsUpgrade;
	
	/* owner() method, holds owner name and car year model */
	public static void owner() {
		ownName = "";
		ownYrMdl = 0;
	}
	
	/* upgradeAccessorries() method, holds the calculations for upgrades and the return value for amount after upgrade */
	public static int upgradeAccessories(int avAmnt) {
		amountAC = 21500;
		amountLeatherSeats = 14400;
		amountBackWipers = 6250;
		amountFogLights = 3300;
		
		if(availAmount >= amountAC && availAmount < amountAC+amountLeatherSeats) {
			System.out.println("Only AC Installed");
			System.out.print("Remaining amount = (" + availAmount + " - " + amountAC +") = ");
			avAmnt = availAmount-amountAC;
			System.out.println(avAmnt);
			hasACUpgrade = true;
		}
		else if(availAmount >=amountAC+amountLeatherSeats && availAmount < amountAC+amountLeatherSeats+amountBackWipers) {
			System.out.println("AC and Leather Seats Installed");
			System.out.print("Remaining amount = (" + availAmount + " - " + amountAC + " - " + amountLeatherSeats + ") = ");
			avAmnt = availAmount-amountAC-amountLeatherSeats;
			System.out.println(avAmnt);
			hasACUpgrade = true;
			hasLeatherSeatsUpgrade = true;
		}
		else if(availAmount >=amountAC+amountLeatherSeats+amountBackWipers && availAmount < amountAC+amountLeatherSeats+amountBackWipers+amountFogLights) {
			System.out.println("AC, Leather Seats, and Back Wipers Installed");
			System.out.print("Remaining amount = (" + availAmount + " - " + amountAC + " - " + amountLeatherSeats + " - " + amountBackWipers + ") = ");
			avAmnt = availAmount-amountAC-amountLeatherSeats-amountBackWipers;
			System.out.println(avAmnt);
			hasACUpgrade = true;
			hasLeatherSeatsUpgrade = true;
			hasBackWipersUpgrade = true;
		}
		else if(availAmount >= amountAC+amountLeatherSeats+amountBackWipers+amountFogLights) {
			System.out.println("AC, Leather Seats, Back Wipers, and Fog Lights Installed");
			System.out.print("Remaining amount = (" + availAmount + " - " + amountAC + " - " + amountLeatherSeats + " - " + amountBackWipers + " - " + amountFogLights + ") = ");
			avAmnt = availAmount-amountAC-amountLeatherSeats-amountBackWipers-amountFogLights;
			System.out.println(avAmnt);
			hasACUpgrade = true;
			hasLeatherSeatsUpgrade = true;
			hasBackWipersUpgrade = true;
			hasFogLightsUpgrade = true;
		}
		
		return avAmnt;
	}
}
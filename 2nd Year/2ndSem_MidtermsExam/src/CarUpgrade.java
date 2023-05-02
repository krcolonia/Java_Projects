import java.util.Scanner;
public class CarUpgrade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* Inputs */
		System.out.print("Owner: ");
		String ownerName = sc.nextLine();
		Car.ownName = ownerName;
		
		System.out.print("Year Model: ");
		int ownerYrMdl = sc.nextInt();
		Car.ownYrMdl = ownerYrMdl;
		
		System.out.print("Input your Available Amount: ");
		int availableAmount = sc.nextInt();
		Car.availAmount = availableAmount;
		
		System.out.println();
		
		/* Returned value of Available Amount after Upgrades */
		int avAmntAft = Car.upgradeAccessories(Car.availAmount);
		
		System.out.println("\nOwner: " + Car.ownName);
		System.out.println("Year Model: " + Car.ownYrMdl);
		System.out.println("Available Amount Before Upgrade: " + Car.availAmount);
		System.out.println("Installed AC: " + Car.hasACUpgrade);
		System.out.println("Installed Leather Seats: " + Car.hasLeatherSeatsUpgrade);
		System.out.println("Installed Back Wipers: " + Car.hasBackWipersUpgrade);
		System.out.println("Installed Fog Lights: " + Car.hasFogLightsUpgrade);
		System.out.println("Available Amount After Upgrade: " + avAmntAft);
	}

}

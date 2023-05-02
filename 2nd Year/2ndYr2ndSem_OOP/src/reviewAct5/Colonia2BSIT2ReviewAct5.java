package reviewAct5;

public class Colonia2BSIT2ReviewAct5 {
	public static void main(String[] args) {
		Dog dog1 = new Dog("Bulldog", "Large", "Light Gray", "5 Years");
		Dog dog2 = new Dog("Beagle", "Large", "Orange", "6 Years");
		Dog dog3 = new Dog("German Shepherd", "Large", "White & Orange", "6 Years");
				
		dog1.getDog();
		dog1.eat("Dog Food");
		dog1.run("Street");
		dog1.sleep(3);
		dog1.name("James");
		
		System.out.println();
		
		dog2.getDog();
		dog2.eat("Beefsteak");
		dog2.run("Dog Playground");
		dog2.sleep(5);
		dog2.name("Paul");
		
		System.out.println();
		
		dog3.getDog();
		dog3.eat("Porkchop");
		dog3.run("Park");
		dog3.sleep(4);
		dog3.name("Julian");
	}
}

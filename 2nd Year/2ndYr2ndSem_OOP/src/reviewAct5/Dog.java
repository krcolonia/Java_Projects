package reviewAct5;

public class Dog {
	private String breed;
	private String size;
	private String colour;
	private String age;
	
	Dog(String breed, String size, String colour, String age) {
		this.breed = breed;
		this.size = size;
		this.colour = colour;
		this.age = age;
	}
	
	void eat(String food) {
		System.out.println("The " + breed + " eats " + food);
	}
	
	void run(String place) {
		System.out.println("The " + breed + " runs in the " + place);
	}
	
	void sleep(int hrs) {
		System.out.println("The " + breed + " sleeps for " + hrs + " hours");
	}
	
	void name(String name) {
		System.out.println("The " + breed + "'s name is " + name);
	}
	
	void getDog() {
		System.out.println("This dog's breed is a " + breed + ", " + size + " in size, " + colour + " in colour, and an age of " + age + " old.");
	}
}

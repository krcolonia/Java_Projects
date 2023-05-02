package reviewAct8;

import java.time.Year;

public class Person {
	private String name;
	private int yob;
	
	Person(String name, int yob) {
		this.name = name;
		this.yob = yob;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		int year = Year.now().getValue();
		int age = year - yob;
		return age;
	}
	
	public int getYOB() {
		return yob;
	}
	
	public void setYOB(int yob) {
		this.yob = yob;
	}
	
	public void printInfo() {
		System.out.println("_____________________________________________________"
						 + "\n\n" 
						 + "Your Name is " + getName() + "\n"
						 + "Year of Birth is " + getYOB() + "\n"
						 + "Your Age is " + getAge());
	}
}

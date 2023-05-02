package bookPackage;

public class Author {
	// Local Variables
	private String name;
	private String email;
	private String gender;
		
	// Author Constructor
	Author(String name, String email, String gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
		
	// Getter for E-Mail
	String getEmail() {
		return email;
	}
	
	// Setter for E-Mail
	public void setEmail(String emailSet) {
		if(emailSet.contains("@")) {
			this.email = emailSet;
		}
		else {
			System.out.println("Invalid email! Set to empty string.");
			this.email = "";
		}
		//this.email = emailSet;
	}
	
	public void emailCheck(String email) {
		if(email.contains("@") || email.equals("")) {
			this.email = email;
		}
		else {
			System.out.println("Invalid email! Set to empty string.");
			this.email = "";
		}
	}
	
	public void genderCheck(String gender) {
		if(gender.equals("Male") || gender.equals("Female") || gender.equals("Unknown")) {
			this.gender = gender;
		}
		else {
			System.out.println("Invalid gender! Set to Unknown.");
			this.gender = "Unknown";
		}
	}
	
	// Print method for Author class
	public void print() {
		emailCheck(email);	
		genderCheck(gender);
		System.out.println("AUTHOR  : " + this.name);
		System.out.println("GENDER  : " + this.gender);
		System.out.println("E-MAIL  : " + this.email + "\n");
	}
}

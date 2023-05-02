package reviewAct6;

public class Employee {
	// Personal Data
	String lastName;
	String firstName;
	String midInit;
	int age;
	String gender;
	String birthDate;
	String placeOfBirth;
	String religion;
	String civStat;
	
	// Contact Information
	String strtBrgy;
	String cityMunicipal;
	String province;
	String emailAdd;
	String contactNo;
	
	// Government ID
	String sssNum;
	String tinNum;
	String pagibigNum;
	String philhealthNum;
	
	Employee(String lastName, String firstName, String midInit, int age, String gender, String birthDate, String placeOfBirth, String religion, String civStat, 
			 String strtBrgy, String cityMunicipal, String province, String emailAdd, String contactNo,
			 String sssNum, String tinNum, String pagibigNum, String philhealthNum) {
		
		// Personal Data
		this.lastName = lastName;
		this.firstName = firstName;
		this.midInit = midInit;
		this.age = age;
		this.gender = gender;
		this.birthDate = birthDate;
		this.placeOfBirth = placeOfBirth;
		this.religion = religion;
		this.civStat = civStat;
		
		// Contact Information
		this.strtBrgy = strtBrgy;
		this.cityMunicipal = cityMunicipal;
		this.province = province;
		this.emailAdd = emailAdd;
		this.contactNo = contactNo;
		
		// Government ID
		this.sssNum = sssNum;
		this.tinNum = tinNum;
		this.pagibigNum = pagibigNum;
		this.philhealthNum = philhealthNum;
	}
	
	void printPersonalData() {
		
		System.out.println(
		"----------------------------------------------------------------------------------------------------------\n"
	  + "PERSONAL DATA\n"
	  + "----------------------------------------------------------------------------------------------------------"
		);
		
		System.out.println("Name: " + firstName + " " + midInit + " " + lastName + "\n"
						 + "Age: " + age + "\n"
						 + "Gender: " + gender + "\n"
						 + "Date of Birth: " + birthDate + "\n"
						 + "Place of Birth: " + placeOfBirth + "\n"
						 + "Religion: " + religion + "\n"
						 + "Civil Status: " + civStat + "\n\n");
	}
	
	void printContactInfo() {
		
		System.out.println(
		"----------------------------------------------------------------------------------------------------------\n"
	  + "CONTACT INFORMATION\n"
	  + "----------------------------------------------------------------------------------------------------------"
		);
		
		System.out.println("Address: " + strtBrgy + " " + cityMunicipal + "\n"
				         + "Province: " + province + "\n"
				         + "E-Mail Address: " + emailAdd + "\n"
				         + "Contact No.: " + contactNo + "\n\n");
	}
	
	void printGovtId() {
		System.out.println(
		"----------------------------------------------------------------------------------------------------------\n"
	  + "PERSONAL DATA\n"
	  + "----------------------------------------------------------------------------------------------------------"
		);
		
		System.out.println("SSS#: " + sssNum + "\n"
						 + "TIN#: " + tinNum + "\n"
						 + "PAGIBIG#: " + pagibigNum + "\n"
						 + "PHILHEALTH: " + philhealthNum + "\n\n");
	}
}

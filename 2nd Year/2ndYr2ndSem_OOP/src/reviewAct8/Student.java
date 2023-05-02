package reviewAct8;

public class Student extends Person {

	private String stuID;
	private String major;
	private int nos;
	
	Student(String name, int yob, String stuID, String major, int nos) {
		super(name, yob);
		this.stuID = stuID;
		this.major = major;
		this.nos = nos;
	}

	public String getStuID() {
		return stuID;
	}

	public void setStuID(String stuID) {
		this.stuID = stuID;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getNos() {
		return nos;
	}
	
	public void setNos(int nos) {
		this.nos = nos;
	}
	
	public void printInfo() {
		super.printInfo();
		System.out.println("Your ID Number is " + getStuID() + "\n"
						 + "Your Program is " + getMajor() + "\n"
						 + "No of Students " + getNos() + "\n"
						 + "Incremented Number is " + ++nos);
	}
}

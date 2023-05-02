package reviewAct7;

public class Employee {
	
	// Personal Info
	private String empID;
	private String lastName;
	private String firstName;
	private String midInit;
	
	// Salary
	private double basicSal;
	private double incentivePay;
	private double houseRentAllow;
	private double mealAllow;
	
	// Deductions
	private double providentFund;
	private double professionalTax;
	private double loan;
	
	Employee(String empID, String lastName, String firstName, String midInit, double basicSal, double incentivePay,
			double houseRentAllow, double mealAllow, double providentFund, double professionalTax, double loan) {
		
		this.empID = empID;
		this.lastName = lastName;
		this.firstName = firstName;
		this.midInit = midInit;
		this.basicSal = basicSal;
		this.incentivePay = incentivePay;
		this.houseRentAllow = houseRentAllow;
		this.mealAllow = mealAllow;
		this.providentFund = providentFund;
		this.professionalTax = professionalTax;
		this.loan = loan;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidInit() {
		return midInit;
	}

	public void setMidInit(String midInit) {
		this.midInit = midInit;
	}

	public double getBasicSal() {
		return basicSal;
	}

	public void setBasicSal(double basicSal) {
		this.basicSal = basicSal;
	}

	public double getIncentivePay() {
		return incentivePay;
	}

	public void setIncentivePay(double incentivePay) {
		this.incentivePay = incentivePay;
	}

	public double getHouseRentAllow() {
		return houseRentAllow;
	}

	public void setHouseRentAllow(double houseRentAllow) {
		this.houseRentAllow = houseRentAllow;
	}

	public double getMealAllow() {
		return mealAllow;
	}

	public void setMealAllow(double mealAllow) {
		this.mealAllow = mealAllow;
	}

	public double getProvidentFund() {
		return providentFund;
	}

	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}

	public double getProfessionalTax() {
		return professionalTax;
	}

	public void setProfessionalTax(double professionalTax) {
		this.professionalTax = professionalTax;
	}

	public double getLoan() {
		return loan;
	}

	public void setLoan(double loan) {
		this.loan = loan;
	}
	
	public String getFullName() {
		String fullName = this.firstName + " " + this.midInit + " " + this.lastName;
		return fullName;
	}
	
	public double getTotalEarn() {
		double totalEarn = this.basicSal + this.incentivePay + this.houseRentAllow + this.mealAllow;
		return totalEarn;
	}
	
	public double getTotalDeduct() {
		double totalDeduct = this.providentFund + this.professionalTax + this.loan;
		return totalDeduct;
	}
	
	public double getNetPay() {
		double netPay = getTotalEarn() - getTotalDeduct();
		return netPay;
	}
}

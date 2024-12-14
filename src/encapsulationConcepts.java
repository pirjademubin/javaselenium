
public class encapsulationConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declare c;ass variables or attributes as private
		// Methods which will get and set to access the value of the private variables
		// Private variables can not be accessed from outside the class
		
		// better control of class variables and methods
		// class variables can be made read only (get method)
		// class variables can be made write only (set method)
		// It will increease the security of your code or data
		
		// Get method is used to return the variable value 
		// Set method is used to set the variable value 
		// interview - getters and setters
		// this keyword is used to refer current object

	}
	
	private String EmpName = "Suraj";
	private int EmpId = 1000;
	
	public String getEmpName() {
		return EmpName;
	}

}

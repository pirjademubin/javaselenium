
public class staticNonStatic {
	
	
	//method or function is same
	//It has a different nature
	//Method or function can be static or non-static
	//Calling method or function can be accessed in a diff way/approach
	//method or function can not be defined/created inside other function/method
	//method or function has its own scope
	//method or function should be inside the class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Object of a class
		// Classname obj_name = new Classname();
		
		staticNonStatic s1 = new staticNonStatic();
		s1.Mul(); //non static methods are called by objects
		
		//The static method Add() from the type staticNonStatic should be accessed in a static way
		s1.Add(); //static methods can also be called by objects, check warning but
		s1.Sub(); //static methods can also be called by objects, check warning but
		
		//OR
		Add();
		Sub();
	}
	
	//Static
	public static void Add() {
		System.out.println("I am inside a static method - Add");
	}
	
	//Static
	public static void Sub() {
		System.out.println("I am inside a static method -  Sub");
	}
	
	//Non static
	public void Mul() {
		System.out.println("I am inside a Non static method -  Mul");
	}

}


public class methodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Method overloading
		//
		
		methodOverloading m1 = new methodOverloading();
		
		int res = methodOverloading(30, 40);
		double res1 = methodOverloading(10.1, 40.5);
		System.out.println("res: " + res);
		System.out.println("res1: " + res1);
	}
	
	public static int methodOverloading(int x, int y) {
		return x + y;
	}
	
	public static double methodOverloading(double x, double y) {
		return x + y;
	}

}

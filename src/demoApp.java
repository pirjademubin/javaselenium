
public class demoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello. world");
		// initialize i 
        int i = 10; 
        int j = i++;
        System.out.println("Post-Increment"); 
  
        // i values is incremented to 1 after returning 
        // current value i.e; 0 
        System.out.println(i);
        System.out.println(j);
  
        // initialized to 0 
        int k = 10; 
        int l = ++k;
        System.out.println("Pre-Increment"); 
  
        // j is incremented to 1 and then it's value is 
        // returned 
        System.out.println(k);
        System.out.println(l);
        
        int m = 4; 
        int a1 = m++;
        int b1 = ++a1;
        System.out.println("Pre-Increment"); 
  
        // j is incremented to 1 and then it's value is 
        // returned 
        System.out.println(m);
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(a1);
        
        int c = 10; 
        int d = c--;
        System.out.println(c);
        System.out.println(d);
        
        int c1 = 10; 
        int d1 = --c1;
        System.out.println(c1);
        System.out.println(d1);
        
        int c2 = 0; 
        int d2 = 0;
        d2 = d2+1;
        c2 = d2;
        
        System.out.println(d2);
        System.out.println(c2);

	}

}

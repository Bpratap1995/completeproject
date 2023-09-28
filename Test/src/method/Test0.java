package method;

public class Test0 {
	
	public static void e(int num) {
		int c=45;
		int sum;
		 sum=num+c;
		 System.out.println("sum :"+sum);
		
		
	}
	
	
	
	public static void d(int num) {
		System.out.println(num+"bhanu");
		e(num);
		
		
	}
	
	
	public static void sum() {
		int a= 20;
		int b= 29;
		int c= a+b;
		d(c);
	   
	}

	public static void main(String[] args) {
		sum();
		
		System.out.println("====");
	

	}

}

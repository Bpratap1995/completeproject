package return1;

import java.util.Scanner;

public class FS1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.println("a :"+a);
		
		product(a);
		
	}
	public static int sum(int a) {
		int b=10;
		int sum = a+b;
		
		//product(sum);
		System.out.println("sum :"+ sum);
		return sum;
		
	}
	
	public static void product(int a) {
		
		int b=sum(a)*2;
		System.out.println("product :"+b);
		 
	
	}
int a =10;
int b=20;
int c= a+b;


public int get1() {
	
	return c;
}





}

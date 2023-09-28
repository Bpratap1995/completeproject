package practice;

import java.util.Scanner;

public class MethodAndFunction {
	
	public static int sum(int x,int y)
	{
		int add=x+y;
		System.out.println(add);
		return add;
		
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b = scan.nextInt();
		sum(a,b);
		
		

	}

}

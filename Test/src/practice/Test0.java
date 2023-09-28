package practice;

import java.util.Scanner;

public class Test0 {
	public static int sum(int a, int b) {
		int sum= a+b;
		System.out.println(sum);
		return sum;
		
	}

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
		System.out.println("enter the number");
		int a=scan.nextInt();
		int b=scan.nextInt();
		sum(a,b);
	}
	

	}



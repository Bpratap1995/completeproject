package practice;

import java.util.Scanner;

public class TestArray {

	public static void main(String[] args) {
		
Scanner scan = new Scanner(System.in);
System.out.println("enter the size");
int size = scan.nextInt();
for(int i =0;i<=size;i++) {
	System.out.println(i);
	if(i==3) {
		System.out.println("break statement initiated");
		
		break;
	}
	
}
	}

}

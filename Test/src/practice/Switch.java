package practice;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
	System.out.println("enter the number");
    
    
    int month=12;
    int i=1;
    
    while(i<=12) {
    switch(i) {
     case 1:System.out.print("january"+" ");
     case 2:System.out.print("Feburary"+" ");
     case 3:System.out.print("March"+" ");;break;
     case 4:System.out.print("April"+" ");
     case 5:System.out.print("May"+" ");
     case 12 :System.out.print("dec"+" ");
    }
    i++;
    }
    

}
}

package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Loan {
	@Test
	public void carLoan() {
		System.out.println("carloan");
	}
	@Test
	public void homeLoan() {
		System.out.println("HomeLoan");
	}
	@AfterSuite
	public void su() {
		System.out.println("after suite");
		
	}

}

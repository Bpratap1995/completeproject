package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class pure {

	@Test
	public void p1() {
		System.out.println("p1");
	}
	@BeforeTest
	public void p2() {
		System.out.println("p2");
		
	}
}

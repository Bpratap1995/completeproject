package test;

import org.testng.annotations.Test;

public class DOM {
	@Test(dependsOnMethods= {"cpi"})
	public void api() {
		System.out.println("Api");
	}
	@Test
	public void bpi() {
		System.out.println("Bpi");
	}
	@Test
	public void cpi() {
		System.out.println("Cpi");
	}

}

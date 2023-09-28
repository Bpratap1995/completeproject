package test1;

import org.testng.annotations.Test;

public class Dom1 {
	@Test(enabled=true,invocationCount=2)
	public void man() {
		System.out.println("Man");
	}
	@Test(enabled=false)
	public void nan() {
		System.out.println("Nan");
	}
	@Test(enabled=false)
	public void oan() {
		System.out.println("Oan");
	}
	@Test(timeOut=4000)
	public void pan() {
		System.out.println("Pan");
	}

}

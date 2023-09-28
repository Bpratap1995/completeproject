package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	@Test(groups= {"run"})
	public void run() {
		System.out.println("bhanu is running");
		}
	@Test(groups= {"run"})
	public void write() {
		System.out.println("pen is used to write");
	}
	@BeforeMethod
	public void copy() {
		System.out.println("copy everything");
	}
	@BeforeSuite
	public void login() {
		System.out.println("Beforesuite");
		
	}
	@AfterMethod
	public void m1() {
		System.out.println("after method");
	}

	
	@BeforeTest
	public void test() {
		System.out.println("BeforeTest");
		
	}
	@BeforeClass
	public void test1() {
		System.out.println("BeforeClass");
	}
	@BeforeTest
	public void t1() {
		System.out.println();
	}
	@BeforeClass
	public void p3() {
		System.out.println("Beforeclass");
	}
	
	@Test
	public void Bark() {
		System.out.println("dog is barking");
	}
	@Test 
	public void p4() {
		System.out.println("..........");
		
	}

}

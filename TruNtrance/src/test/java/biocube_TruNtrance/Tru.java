package biocube_TruNtrance;

import org.testng.annotations.Test;

import trun.LoginPage;
import trun.HomePage;
import trun_testcomponents.BaseTest;

public class Tru extends BaseTest {
	String ExpectedTitle="TruNtrance";
	
	@Test(dataProvider="drivenTest")
	public void LoginSuperAdmin(String id,String password,String data)  {
		
		LoginPage lp = new LoginPage(driver);
		lp.goTo();
		lp.Login(id,password);
		lp.validateLogin(ExpectedTitle,data);
		}
	@Test
	public void HomePage () {
		LoginPage lp= new LoginPage(driver);
		 HomePage hmg = lp.Login1();
		 hmg.HomePage();
		
		
	}

}

package test1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class Parametrisation {
	@Parameters({"URL","Username"})
	@Test
	public void WebLogin(String urlname,String Usernmae) {
		System.out.println(urlname);
		System.out.println(Usernmae);
		
	}
@Test(dataProvider="getData")
public void login(String username,String password) {
	System.out.println(username);
	System.out.println(password);
	
}
@DataProvider
public Object[][] getData() {
	Object[][]data =new Object[3][2];
	data[0][0]="firstusername";
	data[0][1]="firstpassword";
	data[1][0]="secondusername";
	data[1][1]="secondpassword";
	data[2][0]="thirdusername";
	data[2][1]="thirdpassword";
	return data;
	
}

}

package practice;




import org.testng.annotations.Test;

import files.Body;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;




public class DataProviderTestNg {
   @Test
	public void addBook(String isbn,String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").
				body(Body.Addbook(isbn,aisle)).when().post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String id=js.get("ID");
		System.out.println(id);
		
	}
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"ojfwty","9363"},{"cwefee","4253"}};

}
	@Test
	public void m() {
		
	}
}

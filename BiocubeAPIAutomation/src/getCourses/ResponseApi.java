package getCourses;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class ResponseApi {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com/getCourse.php";
		given().queryParam("access_token", "").when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
	}

}

package practice;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import files.Body;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Base26062023 {
	public static void main(String[] args) {
		
		RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key","qaclick").build();
		
	ResponseSpecification res=	new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		 Response r = given().spec(req).body(Body.Addplace()).when().post("maps/api/place/add/json").then().spec(res).extract().response();
		
		
	System.out.println(r.asString());
		
		
		
		
		
	
		
	}
}
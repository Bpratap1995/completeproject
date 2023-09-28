package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



import files.Body;

public class Basics {

	public static void main(String[] args) {
		
     RestAssured.baseURI = "https://rahulshettyacademy.com";
     
   String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
     .body(Body.Addplace()).when().post("maps/api/place/add/json")
     .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();
       System.out.println(response);
       
   JsonPath js = new JsonPath(response);
  String place_Id = js.getString("place_id");
  System.out.println(place_Id);
  //update place
  String updateAddress="70 winter walk, USA";
  
  given().log().all().queryParam("key","qaclick123").body("{\r\n"
  		+ "\"place_id\":\""+place_Id+"\",\r\n"
  		+ "\"address\":\""+updateAddress+"\",\r\n"
  		+ "\"key\":\"qaclick123\"\r\n"
  		+ "}").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
   //get place
  String getPlaceResponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id",place_Id ).when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
  .extract().response().asString();
  JsonPath js1 = new JsonPath(getPlaceResponse);
  String actualAddress=js1.getString("address");
  System.out.println(actualAddress);
 // Assert.assertEquals(actualAddress,updateAddress );
  
	}
	
}


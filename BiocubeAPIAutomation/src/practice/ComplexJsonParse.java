package practice;

import files.Body;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		int totalprice=0;
		
		JsonPath js = new JsonPath(Body.CourseContent());
		int count =js.getInt("courses.size()");
		System.out.println(count);
		
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		
		String title =js.getString("courses[0].title");
		System.out.println(title);
		System.out.println();
		
		//print all the titles and their respective price
		for(int i=0;i<count;i++) {
			String titleOfTheCourses=js.getString("courses["+i+"].title");
			int price=js.getInt("courses["+i+"].price");
			System.out.println(titleOfTheCourses);
			System.out.println(price);
		}
		System.out.println();
			//print number of copies sold by RPa Course
		for(int i=0;i<count;i++) {
			String titleOfTheCourses=js.getString("courses["+i+"].title");
			if(titleOfTheCourses .equalsIgnoreCase("RPA")) {
				int copies=js.getInt("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
			 System.out.println("=================");
			 //Verify if sum of all Course prices matches with purchase amount
			 for(int i =0;i<count;i++) {
				 int price=js.getInt("courses["+i+"].price");
				 int copies1=js.getInt("courses["+i+"].copies");
	
				 totalprice=totalprice+price*copies1;
				
				 
			 }
			 System.out.println(totalprice);
			 if(totalprice == purchaseAmount) {
					 System.out.println("pass :sum of all Course prices matches with purchase amount");
			 
			  
			 }
		

	}

}

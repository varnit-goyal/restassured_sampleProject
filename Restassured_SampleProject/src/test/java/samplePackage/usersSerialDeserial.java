package samplePackage;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;

public class usersSerialDeserial {

	
	@Test(priority=1)
	
	void serilizationConcept(){
	users us=new users();
	us.getname("aman1");
	us.getjob("manager1");
	
	given().contentType(ContentType.JSON)
	.when().post("https://reqres.in/api/users")
	.then().statusCode(201).log().all();
	
}
	@Test(priority=2)
	void deserilaization() {
		users us1=get("https://reqres.in/api/users?page=2").as(users.class);
		System.out.println(us1.job);
		
	}	

}

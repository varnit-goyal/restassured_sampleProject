package samplePackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class samplePostRequest {
	public static HashMap hm=new HashMap();
	String employeeAge=restUtils.empAge();
		
		@BeforeClass
		public void postdata() {
			hm.put("name", restUtils.getFirstName());
			hm.put("salary",restUtils.empSal());
			hm.put("age", employeeAge);
			RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
			RestAssured.basePath="/create";
			
		}
			@Test
			
		public void verifyPostRequest(){
		
		
		given().contentType("application/json").body(hm).
		
		when().post().
		
		then().statusCode(200).and().body("status",equalTo("success")).and().body("message",equalTo("Successfully! Record has been added.")).log().all();
		
	}


}

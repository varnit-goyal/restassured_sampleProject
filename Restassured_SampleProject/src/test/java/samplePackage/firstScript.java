package samplePackage;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*; 
import static io.restassured.RestAssured.*;

public class firstScript {


@Test

public void verifyStatusCode(){
	
	given().
	
	when().get("https://api-integration.customerlounge.app/api/Status").
	
	then().statusCode(200).statusLine("HTTP/1.1 200 OK").assertThat().body("Version",equalTo("1.16.0")).header("Content-Type", "application/json; charset=utf-8");
	
}

}

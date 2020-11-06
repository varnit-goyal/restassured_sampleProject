package samplePackage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class extractAll {
	public static HashMap hm = new HashMap();
	String employeeAge = restUtils.empAge();

	@BeforeClass
	public void postdata() {
		hm.put("name", restUtils.getFirstName());
		hm.put("salary", restUtils.empSal());
		hm.put("age", employeeAge);
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/create";

	}

	@Test(priority = 1)

	public void verifyPostRequest() {

		Response response = given().contentType("application/json").body(hm).when().post().then().statusCode(200).and()
				.body("status", equalTo("success")).and()
				.body("message", equalTo("Successfully! Record has been added.")).log().all().extract().response();
		String jsonAsString = response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! Record has been added."), true);
	}

	@Test(priority = 2)

	void jsonpathfinder() {

		given().contentType(ContentType.JSON).body(hm).when().post().then().statusCode(200).and().body("data.name",
				equalTo("test1"));

	}

	@Test(priority = 3)

	void jsonpathfinder2() {

		given().contentType("application/json").body(hm).when().post().then().statusCode(200).and().body("data.salary",
				hasItems("10", "20", "30"));

	}

	@Test(priority = 4)

	void settingParamHeader() {

		given().param("employee_name", "Tiger Nixon").header("Content-Type", "application/json").when()
				.get("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).log().all();

	}
}

//xml document
//body("customer.city",equal To("Lucknow""))
//body("customer.text()",equal To("15billclany319 upland"))
//body(hasXpath("/customer/firstname",containsString("bill")));
//body(hasXpath("/invoicelist/invoice[text()='30']");
/*==============================================
 * //"Courses" : [ "java", "selenium" ] Arraylist coursesList=new Arraylist();
 * coursesList.add("java") coursesList.add("selenium")
 * map.put("Courses",coursesList)
 */

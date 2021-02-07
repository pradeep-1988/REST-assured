package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;



//Ctrl/cmd+Shit+O : To organize your imports i.e. the imports which are not used, will be removed.

public class JSONSchemaValidator {
	
	@Test
	public void testGet() {
			
			baseURI="https://reqres.in/api";
			given().
				get("/users").
			then().
				assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
				statusCode(200);
			
		}

}

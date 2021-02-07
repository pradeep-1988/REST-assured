package tests;

import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPathandDeleteExamples {
	
	//@Test
	public void testPut() {

		JSONObject request = new JSONObject();
		request.put("name", "Pradeep");
		request.put("job", "Engineer");

		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		given().
			body(request.toJSONString()).
		when().
			put("/api/users/2"). 
		then(). 
			statusCode(200).log().all();		
		
	}
	
	//@Test
	public void testPatch() {

		JSONObject request = new JSONObject();
		request.put("name", "Pradeep");
		request.put("job", "Engineer");

		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		given().
			body(request.toJSONString()).
		when().
			patch("/api/users/2"). 
		then(). 
			statusCode(200).log().all();		
		
	}
	
	@Test
	public void testDelete() {

		
		baseURI="https://reqres.in";
		given().
		when().
			delete("/api/users/2"). 
		then(). 
			statusCode(204).log().all();		
		
	}

}

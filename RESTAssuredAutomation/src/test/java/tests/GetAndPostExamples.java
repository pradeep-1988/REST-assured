package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.HasItemInArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAndPostExamples {
	
	//@Test
	public void testGet() {
		
		baseURI="https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].first_name", equalTo("Lindsay")).
			body("data.first_name", hasItems("Tobias","Lindsay","George"));
		
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Pradeep");
		map.put("job", "Engineer");
		System.out.println(map);
		
		
		JSONObject request = new JSONObject();
		request.put("name", "Pradeep");
		request.put("job", "Engineer");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		given().
			body(request.toJSONString()).
		when().
			post("/users"). 
		then(). 
			statusCode(201).log().all();		
		
	}

}

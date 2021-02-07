package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsonLocalAPI {
	//@Test
	public void get() {
		baseURI="http://localhost:3000/";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	//Post request: Add a new record.
	//@Test
	public void post() {
		
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Naresh");
		request.put("lastName", "Chaudhary");
		request.put("subjectID", 2);
		
		baseURI="http://localhost:3000/";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log()
			.all();	
		
	}
	//Put request: update a record
	//@Test
	public void put() {
		
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Ramesh");
		request.put("lastName", "Kumar");
		request.put("subjectID", 2);
		//request.put("id", 4);
		
		baseURI="http://localhost:3000/";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/5")
		.then()
			.statusCode(200)
			.log()
			.all();
	}
	//Patch request: Update a part of the record
	//@Test
	public void patch() {
			
			
			JSONObject request = new JSONObject();
			request.put("lastName", "Thampi");
			
			baseURI="http://localhost:3000/";
			given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(request.toJSONString())
			.when()
				.patch("/users/5")
			.then()
				.statusCode(200)
				.log()
				.all();
		}
	
	//Delete request: delete the complete record.
	@Test
	public void delete() {
		baseURI="http://localhost:3000/";
		given()
		.when()
			.delete("/users/5")
		.then()
			.statusCode(200)
			.log()
			.all();
	}

}

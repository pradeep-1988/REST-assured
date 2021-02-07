package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

public class XMLSchemaValidator {
	@Test
	public void schemavalidation() throws IOException {
		
		// To get a request body from a file
		File file	=	new	File("./SoapRequest/Add.xml");
		if(file.exists()) {
			System.out.println(">> File exists");
		}	
		FileInputStream fileInputStream	=	new FileInputStream(file);
		String requestbody	=	IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI	= "http://www.dneonline.com/";
	
	given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestbody)
	.when()
		.post("/calculator.asmx")
	.then()
		.statusCode(200)
		.log()
		.all()
	.and()
		.body("//*:AddResult.text()", equalTo("11"))
	.and()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Calculator.xsd"));
		
		
	}

}

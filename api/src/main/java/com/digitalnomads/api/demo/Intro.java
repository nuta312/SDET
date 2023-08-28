package com.digitalnomads.api.demo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Intro {

    @Test
    void demoTest() {
        RestAssured.baseURI = "https://reqres.in/"; // base

        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON) // param types : path param, query,header,request body etc...
                        .accept(ContentType.JSON);

        Response response = requestSpecification
                .request(Method.GET,"api/users");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test
    void demoTest2() {
        RestAssured.baseURI = "https://reqres.in/";

        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON);

        Response response = requestSpecification
                .request(Method.GET,"api/users/2");

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    void createNewUserTest() {
        RestAssured.baseURI = "https://reqres.in/";

        String userPayload = "{\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(userPayload);

        Response response = requestSpecification
                .request(Method.POST,"api/users");

//        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("name");
        String job = jsonPath.getString("job");

        System.out.println(name);
        System.out.println(job);
        Assert.assertEquals(response.getStatusCode(),201);
        Assert.assertEquals(name,"John Doe");
        Assert.assertEquals(job,"leader");

    }




}

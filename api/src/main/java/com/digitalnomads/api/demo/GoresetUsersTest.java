package com.digitalnomads.api.demo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GoresetUsersTest {

    public static void main(String[] args) {

        String userPayload = "{\n" +
                "    \"name\": \"Trump\",\n" +
                "    \"email\": \"donuld@trump.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        RequestSpecification requestSpecification =
                given()
                        .baseUri("https://gorest.co.in/public/v2")
                        .header("Authorization","Bearer 9bb228962a5436bc9ac217ad3511d60faa102226c6a7b8f46b24690095d0f249")
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(userPayload);

        Response response = requestSpecification
                .request("POST","/users");
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),201);

    }
}

package com.digitalnomads.api.controllers;

import com.digitalnomads.api.ApiRequest;
import io.restassured.response.Response;

import static com.digitalnomads.api.application.TalentLMSBaseEndpoints.*;

public class UserController extends ApiRequest {
    public UserController(String url) {
        super(url, API_KEY);
    }

    public Response getAllUsers() {
        return this.response = super.get(getEndpoint(API, V1, USERS));
    }

    public Response getUserByEmail(String email) {
        return this.response = super.getWithParams(getEndpoint(API, V1, USERS)
                , generateParams(EMAIL, email));
    }

    public boolean isUserOnline(String id) {
        return super.getWithParams(getEndpoint(API, V1, ONLINE), generateParams("user_id", id)).jsonPath().getBoolean("online");
    }


}

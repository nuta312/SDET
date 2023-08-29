package com.digitalnomads.api.utils;

import com.digitalnomads.api.entities.BaseEntity;
import com.digitalnomads.api.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String fromObjectToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        User user = EntityManager.generateUser();
        System.out.println(user);
        String s = JacksonUtils.fromObjectToJson(user);
        System.out.println(s);
    }

}
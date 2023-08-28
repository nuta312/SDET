package com.digitalnomads.api.demo;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GsonDemo {

    @Test
    void test123()
    {
        String payload = "{\n" +
                "    \"brand\": \"BMW\",\n" +
                "    \"doors\": \"2\"\n" +
                "}";

        Gson gson = new Gson();
        Car car = gson.fromJson(payload, Car.class); // deserialization

        System.out.println(car.getBrand());
        System.out.println(car.getDoors());

        Assert.assertEquals(car.getBrand(),"BMW");


        Car subaru = new Car("Subaru Imprezza",4); // serialization

        String subaruPayload = gson.toJson(subaru);

        System.out.println(subaruPayload);

    }
}

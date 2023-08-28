package com.digitalnomads.apiTests.users;

import com.digitalnomads.api.entities.User;
import com.digitalnomads.apiTests.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserGetTest extends BaseApiTest {
    @Test
    public void getUsers() {
        String expectedEmail = "example23@example.com";
        String expectedEmailNegative = "example23@example.com1";
        userController.getUserByEmail(expectedEmail);
        User user = userController.extractObjectFromResponse(User.class);
        System.out.println(user.toString());
        assertEquals(user.getEmail(), expectedEmailNegative, "User email is not correct");
    }
}

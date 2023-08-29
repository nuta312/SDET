package com.digitalnomads.apiTests.users;

import com.digitalnomads.api.asserts.ApiAssert;
import com.digitalnomads.api.entities.User;
import com.digitalnomads.api.utils.EntityManager;
import com.digitalnomads.apiTests.BaseApiTest;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserGetTest extends BaseApiTest {
    @Test
    public void getUserByEmail() {
        String expectedEmail = "example23@example.com";
        String expectedEmailNegative = "example23@example.com1";
        userController.getUserByEmail(expectedEmail);
        User user = userController.extractObjectFromResponse(User.class);
        System.out.println(user.toString());
        assertEquals(user.getEmail(), expectedEmailNegative, "User email is not correct");
    }

    @Test
    public void getUsers() {
        User[] user = userController.getAllUsers().as(User[].class);
        System.out.println(Arrays.toString(user));
    }

    @Test
    public void isUserOnline() {
        userController.isUserOnline("1");
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200);
    }

    @Test
    public void createUser() {
        User user = EntityManager.generateUser();
        User createdUser = userController.createUser(user);
        assertNotNull(createdUser.getId());
    }

}

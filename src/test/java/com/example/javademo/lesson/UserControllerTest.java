package com.example.javademo.lesson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    @Test
    void introduceShouldFollowControllerServiceUserChain() {
        UserController controller = new UserController(new UserService());

        String result = controller.introduce("Alice", 17);

        assertEquals("Hello, I am Alice, age 17 You are a minor.", result);
    }

    @Test
    void birthdayShouldChangeTheReturnedMessage() {
        UserController controller = new UserController(new UserService());

        String result = controller.birthday("Alice", 17);

        assertEquals("Hello, I am Alice, age 18", result);
    }
}

package com.example.javademo.lesson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    void shouldWorkAsAClassExample() {
        User user = new User("Alice", 17);

        assertEquals("Alice", user.getName());
        assertEquals(17, user.getAge());
        assertFalse(user.isAdult());
        assertEquals("Hello, I am Alice, age 17", user.introduce());

        user.haveBirthday();

        assertEquals(18, user.getAge());
        assertTrue(user.isAdult());
    }
}

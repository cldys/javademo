package com.example.javademo.lesson;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserControllerTest {

    @Test
    void shouldCreateAndQueryUser() {
        UserController controller = new UserController(new UserService());

        UserCreateRequest request = new UserCreateRequest("Alice", 17);
        UserResponse created = controller.create(request).getBody();

        assertNotNull(created);
        assertNotNull(created.id());
        assertEquals("Alice", created.name());
        assertEquals(17, created.age());
        assertFalse(created.adult());

        UserResponse fetched = controller.getById(created.id());

        assertEquals(created, fetched);
    }

    @Test
    void shouldIncreaseAgeByBirthdayEndpoint() {
        UserController controller = new UserController(new UserService());

        UserResponse created = controller.create(new UserCreateRequest("Bob", 18)).getBody();
        UserResponse birthday = controller.birthday(created.id());

        assertEquals(19, birthday.age());
        assertTrue(birthday.adult());
    }

    @Test
    void shouldValidateCreateRequest() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<UserCreateRequest>> violations = validator.validate(
                new UserCreateRequest("", -1)
        );

        assertEquals(2, violations.size());
    }

    @Test
    void shouldThrowWhenUserNotFound() {
        UserController controller = new UserController(new UserService());

        assertThrows(UserNotFoundException.class, () -> controller.getById(999));
    }
}

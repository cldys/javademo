package com.example.javademo.lesson;

public record UserResponse(
        Long id,
        String name,
        int age,
        boolean adult
) {
}

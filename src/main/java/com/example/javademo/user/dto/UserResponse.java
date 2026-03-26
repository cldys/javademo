package com.example.javademo.user.dto;

public record UserResponse(
        Long id,
        String name,
        int age,
        boolean adult
) {
}

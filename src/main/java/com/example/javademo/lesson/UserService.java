package com.example.javademo.lesson;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String introduce(String name, int age) {
        User user = new User(name, age);
        return user.introduce() + userSuffix(user);
    }

    public String celebrateBirthday(String name, int age) {
        User user = new User(name, age);
        user.haveBirthday();
        return user.introduce();
    }

    private String userSuffix(User user) {
        return user.isAdult() ? " You are an adult." : " You are a minor.";
    }
}

package com.example.javademo.lesson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/introduce")
    public String introduce(@RequestParam String name, @RequestParam int age) {
        return userService.introduce(name, age);
    }

    @GetMapping("/birthday")
    public String birthday(@RequestParam String name, @RequestParam int age) {
        return userService.celebrateBirthday(name, age);
    }
}

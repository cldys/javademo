package com.example.javademo.user.domain;

public class User {

    private final Long id;
    private final String name;
    private int age;

    public User(String name, int age) {
        this(null, name, age);
    }

    public User(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public void haveBirthday() {
        age++;
    }

    public String introduce() {
        return "Hello, I am " + name + ", age " + age;
    }
}

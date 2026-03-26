package com.example.javademo.lesson;

public class User {

    private final String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

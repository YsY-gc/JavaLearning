package com.ysy.domain;

public class User {
    int age;
    String username;

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", userName='" + username + '\'' +
                '}';
    }
}

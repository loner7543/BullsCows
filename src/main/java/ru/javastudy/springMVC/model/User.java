package ru.javastudy.springMVC.model;

import org.springframework.stereotype.Component;


@Component
public class User {

    private String name;
    private String password;
    private int score;

    public User(){}

    public User(String name, String password, int score) {
        this.name = name;
        this.password = password;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

package com.example.planningpokerproject.Model;

import java.util.ArrayList;

public class User {

    private String id;
    private String name;
    private String answer;


    public User(){}
    public User(String id, String name, String answer) {
        this.id = id;
        this.name = name;
        this.answer = answer;

    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}

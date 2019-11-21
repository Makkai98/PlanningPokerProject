package com.example.planningpokerproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Question {

    private int id;
    private String question;
    private boolean stratus;
    private LocalDateTime time;
    private ArrayList<User> users;

    public Question(int id, String question, boolean stratus, LocalDateTime time, ArrayList<User> users) {
        this.id = id;
        this.question = question;
        this.stratus = stratus;
        this.time = time;
        this.users = users;
    }
    public Question(){}

    public Question(int id, String question, boolean stratus, ArrayList<User> users) {
        this.id = id;
        this.question = question;
        this.stratus = stratus;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", stratus=" + stratus +
                ", time=" + time +
                ", users=" + users +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isStratus() {
        return stratus;
    }

    public void setStratus(boolean stratus) {
        this.stratus = stratus;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}

package com.example.planningpokerproject.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Question {

    private int id;
    private String question;
    private boolean status;
    private LocalDateTime time;
    private ArrayList<User> users;

    public Question(int id, String question, boolean status, LocalDateTime time, ArrayList<User> users) {
        this.id = id;
        this.question = question;
        this.status = status;
        this.time = time;
        this.users = users;
    }
    public Question(){}

    public Question(int id, String question, boolean status, ArrayList<User> users) {
        this.id = id;
        this.question = question;
        this.status = status;
        this.users = users;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", status=" + status +
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean stratus) {
        this.status = status;
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

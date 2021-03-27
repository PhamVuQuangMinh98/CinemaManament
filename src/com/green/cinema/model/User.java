package com.green.cinema.model;

public class User {

    private int userId;
    private String email;
    private String password;

    public User(int id, String email, String password) {
        this.userId = id;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

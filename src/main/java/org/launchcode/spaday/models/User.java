package org.launchcode.spaday.models;

import java.util.Date;

public class User {
    private String username;
    private String email;
    private String password;
    private int id;
    private static int nextID=1;
    private Date date;

    public User(String username, String email){
        this.username = username;
        this.email = email;
        this.id = nextID;
        nextID++;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

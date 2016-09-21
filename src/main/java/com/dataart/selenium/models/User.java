package com.dataart.selenium.models;

public class User {
    private String username;
    private String password;
    private String fname;
    private String lname;
    private Role role;

    public User(String admin, String ivan, String petrov, Role user) {
    }


    public enum Role {
      USER, DEVELOPER
    }


    public User(String username, String fname, String lname, Role role, String password) {
        this.username = username;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

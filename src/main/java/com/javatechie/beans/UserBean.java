package com.javatechie.beans;

public class UserBean {

    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;
    private int points;
    private String referalCode;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getRoles() {
        return roles;
    }
    public void setRoles(String roles) {
        this.roles = roles;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getReferalCode() {
        return referalCode;
    }
    public void setReferalCode(String referalCode) {
        this.referalCode = referalCode;
    }
    @Override
    public String toString() {
        return "UserBean [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", roles="
                + roles + ", points=" + points + ", referalCode=" + referalCode + "]";
    }

    
}

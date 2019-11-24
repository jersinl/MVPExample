package com.example.mvp_pattern.main.model;

public class UserListDTO {
    private int UserId;
    private String UserName,Email;
    private boolean Admin;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean admin) {
        Admin = admin;
    }
}

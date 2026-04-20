package com.handmade.shop.dto;

public class LoginResponse {
    private String message;
    private String role;
    private String username;

    public LoginResponse(String message, String role, String username) {
        this.message = message;
        this.role = role;
        this.username = username;
    }

    public String getMessage() { return message; }
    public String getRole() { return role; }
    public String getUsername() { return username; }
}
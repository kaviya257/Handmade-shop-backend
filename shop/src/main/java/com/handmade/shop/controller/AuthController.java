package com.handmade.shop.controller;

import com.handmade.shop.dto.*;
import com.handmade.shop.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }


    @PostMapping("/forgot")
    public String forgot(@RequestBody ForgotPasswordRequest request) {
        return userService.resetPassword(request);
    }
}

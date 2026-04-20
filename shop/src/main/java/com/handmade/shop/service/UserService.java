package com.handmade.shop.service;

import com.handmade.shop.dto.*;
import com.handmade.shop.model.User;
import com.handmade.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String register(RegisterRequest request) {

        User existing = userRepository.findByUsername(request.getUsername());

        if (existing != null) {
            return "User already exists";
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setRole("USER");
        user.setBalance(1000); // optional (nice interview feature)
        userRepository.save(user);

        return "Registered Successfully";
    }


    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return new LoginResponse("User not found", null, null);
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponse("Wrong password", null, null);
        }

        return new LoginResponse(
                "Login Successful",
                user.getRole(),
                user.getUsername()
        );
    }


    public String resetPassword(ForgotPasswordRequest request) {

        if (request.getNewPassword() == null || request.getNewPassword().isBlank()) {
            return "Password not updated";
        }

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return "User not found";
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);

        return "Password updated successfully";
    }
}
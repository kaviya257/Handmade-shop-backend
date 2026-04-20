package com.handmade.shop.controller;

import com.handmade.shop.model.User;
import com.handmade.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }


    @PutMapping("/updateBalance/{username}")
    public User updateBalance(@PathVariable String username, @RequestParam double amount) {
        User user = userRepository.findByUsername(username);

        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        user.setBalance(user.getBalance() - amount);
        return userRepository.save(user);
    }
}
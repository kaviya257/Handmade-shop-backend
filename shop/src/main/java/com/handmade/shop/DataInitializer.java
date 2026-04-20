package com.handmade.shop;

import com.handmade.shop.model.User;
import com.handmade.shop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        User admin = userRepository.findByUsername("admin");

        if (admin == null) {

            User newAdmin = new User();
            newAdmin.setUsername("admin");
            newAdmin.setPassword("admin123");
            newAdmin.setRole("ADMIN");
            newAdmin.setBalance(0);

            userRepository.save(newAdmin);

            System.out.println("✅ Admin created");
        }
        else {

            // 🔥 FIX OLD DATA ISSUE (VERY IMPORTANT)
            if (admin.getRole() == null || admin.getRole().isEmpty()) {
                admin.setRole("ADMIN");
                userRepository.save(admin);

                System.out.println("⚠ Existing admin fixed (role updated)");
            }
        }
    }
}
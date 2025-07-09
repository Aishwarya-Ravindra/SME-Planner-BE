package com.accenture.sme_planner.services;

import com.accenture.sme_planner.dtos.LoginRequest;
import com.accenture.sme_planner.dtos.LoginResponse;
import com.accenture.sme_planner.models.User;
import com.accenture.sme_planner.repositories.UserRepository;
import com.accenture.sme_planner.security.JwtUtil;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initAdminUser() {
        if (!userRepository.existsByEmail("aish@example.com")) {
            User user = new User();
            user.setEmail("aish@example.com");
            user.setPassword(passwordEncoder.encode("password123")); // plain text
            userRepository.save(user);
            System.out.println("✅ User inserted at startup");
        }
    }

    public LoginResponse login(LoginRequest request) {
        System.out.println("Login request received for email: " + request.getEmail());

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {
                    System.out.println("❌ User not found for email: " + request.getEmail());
                    return new RuntimeException("User not found");
                });

        System.out.println("✅ User found: " + user.getEmail());

        boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), user.getPassword());
        System.out.println("Password match: " + isPasswordMatch);

        if (!isPasswordMatch) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        System.out.println("Generated token: " + token);
        return new LoginResponse(token);
    }

}


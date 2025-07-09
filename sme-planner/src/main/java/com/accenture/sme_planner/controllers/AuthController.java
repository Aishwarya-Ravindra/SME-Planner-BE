package com.accenture.sme_planner.controllers;

import com.accenture.sme_planner.dtos.LoginRequest;
import com.accenture.sme_planner.dtos.LoginResponse;
import com.accenture.sme_planner.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}

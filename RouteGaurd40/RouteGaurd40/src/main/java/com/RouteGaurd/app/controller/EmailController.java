package com.RouteGaurd.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.RouteGaurd.app.service.EmailService;


@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam String toEmail,
                                             @RequestParam String username,
                                             @RequestParam String password) {
        try {
            emailService.sendAdminCredentials(toEmail, username, password);
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to send email");
        }
    }
}


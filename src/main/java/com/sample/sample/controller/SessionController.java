package com.sample.sample.controller;

import com.sample.sample.model.Session;
import com.sample.sample.service.SessionService;
import com.sample.sample.service.SessionControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private SessionControlService sessionControlService;

    @GetMapping("/active")
    public boolean getActiveSessions(@RequestParam String userId) {
        return sessionService.getUserSessions(userId);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestParam String userId) {
        // Enforce session limit on login
//        sessionControlService.enforceSessionLimit(userId);
        sessionService.setSession(userId);
        session.setAttribute("userId", userId);
        return ResponseEntity.ok("User logged in with session ID: " + session.getId());
    }
}

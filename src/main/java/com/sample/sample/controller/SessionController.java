package com.sample.sample.controller;

import com.sample.sample.Repository.UserDetailsRepo;
import com.sample.sample.model.Session;
import com.sample.sample.model.UserDetailsDTO;
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

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @CrossOrigin(origins = "https://abdur1r.github.io")
    @GetMapping("/active")
    public boolean getActiveSessions(@RequestParam String userId) {
        return sessionService.getUserSessions(userId);
    }

    @CrossOrigin(origins = "https://abdur1r.github.io")
    @PostMapping("/login")
    public ResponseEntity<String> login(HttpSession session, @RequestParam String userId, @RequestParam String password) {
        // Enforce session limit on login
//        sessionControlService.enforceSessionLimit(userId);
        UserDetailsDTO requiredUser=userDetailsRepo.findByEmailId(userId);
        System.out.println("requiredUser "+requiredUser);
        if(!(requiredUser!=null && requiredUser.getPassword().equals(password))){
            return ResponseEntity.ok("Invalid Credentials");
        }
        sessionService.setSession(userId);
        session.setAttribute("userId", userId);
        return ResponseEntity.ok("User logged in with session ID: " + userId);
    }
}

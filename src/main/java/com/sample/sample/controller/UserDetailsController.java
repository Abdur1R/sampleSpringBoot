package com.sample.sample.controller;

import com.sample.sample.Repository.UserDetailsRepo;
import com.sample.sample.model.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Optional;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @CrossOrigin(origins = "https://abdur1r.github.io/training-ui/")
    @PostMapping("/save")
    private UserDetailsDTO postUserData(@RequestBody UserDetailsDTO userDetails){
        return userDetailsRepo.save(userDetails);
    }

    @CrossOrigin(origins = "https://abdur1r.github.io/training-ui/")
    @GetMapping("/getData/{userId}")
    private Optional<UserDetailsDTO> gerUserData(@PathVariable String userId){
        return userDetailsRepo.findById(userId);
    }
}

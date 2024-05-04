package com.sample.sample.controller;

import com.sample.sample.Repository.UserDetailsRepo;
import com.sample.sample.model.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {
    @Autowired
    UserDetailsRepo userDetailsRepo;

    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    private UserDetailsDTO postUserData(@RequestBody UserDetailsDTO userDetails){
        return userDetailsRepo.save(userDetails);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getData/{userId}")
    private Optional<UserDetailsDTO> gerUserData(@PathVariable String userId){
        return userDetailsRepo.findById(userId);
    }
}

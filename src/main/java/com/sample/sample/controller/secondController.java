package com.sample.sample.controller;

import com.sample.sample.model.SecondModel;
import com.sample.sample.service.SecondService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class secondController {

  @Autowired
  SecondService secondservice;

  @GetMapping("/second")
  public List<SecondModel> secondMethod() {
    List<SecondModel> response = secondservice.getData();
    SecondModel secondModel = new SecondModel();
    secondModel.setName("name");
    secondModel.set_id("id");
    System.out.println(response);
    response.add(secondModel);
    return response;
  }

  @PostMapping("/addModel")
  SecondModel addModel(@RequestBody SecondModel model) {
    return secondservice.addModel(model);
  }
}

package com.sample.sample.controller;

import com.sample.sample.model.FirstModel;
import com.sample.sample.service.FirstService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstController {

  @Autowired
  FirstService firstService;

  @GetMapping("first")
  public List<FirstModel> firstMethod() {
    List<FirstModel> response = firstService.getData();
    return response;
  }
}

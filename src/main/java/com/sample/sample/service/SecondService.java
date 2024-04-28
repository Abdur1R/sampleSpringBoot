package com.sample.sample.service;

import com.sample.sample.model.SecondModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SecondService {

  @Autowired
  MongoTemplate mongoTemplate;

  Query query = new Query();

  public List<SecondModel> getData() {
    List<SecondModel> response = mongoTemplate.findAll(SecondModel.class);
    return response;
  }
  public SecondModel addModel(SecondModel model) {
    SecondModel response = mongoTemplate.save(model);
    return response;
  }
}

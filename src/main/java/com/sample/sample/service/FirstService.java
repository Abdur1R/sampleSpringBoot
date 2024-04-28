package com.sample.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sample.sample.model.FirstModel;

@Service
public class FirstService {
    @Autowired
    MongoTemplate mongoTemplate;
    Query query=new Query();
    public List<FirstModel> getData(){
      List<FirstModel>response=  mongoTemplate.findAll(FirstModel.class);
    return response;
    }
}

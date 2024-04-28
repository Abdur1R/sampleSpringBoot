package com.sample.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("test")
@Data
public class SecondModel {
    public String _id;   
    public String name;   
}

package com.sample.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("startup_log")
@Data
public class FirstModel {
    private String hostname;
}

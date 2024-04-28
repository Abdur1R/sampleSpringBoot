package com.sample.sample.DTO;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("test")
@Data
public class SecondDTO {
    public String _id;   
    public String name;   
}

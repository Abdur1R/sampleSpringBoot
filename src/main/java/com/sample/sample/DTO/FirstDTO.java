package com.sample.sample.DTO;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("startup_log")
@Data
public class FirstDTO {
    private String hostname;
}

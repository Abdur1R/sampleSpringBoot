package com.sample.sample.model;

import com.sample.sample.DTO.SessionAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Sessions")
@NoArgsConstructor
@AllArgsConstructor
public class Session {
//    {
//    "_id": "uniqueSessionId",
//    "userId": "user123",
//    "attributes": {
//        "username": "JohnDoe",
//        "role": "user",
//        ...
//    },
//    "creationTime": "2024-11-05T12:34:56",
//    "lastAccessedTime": "2024-11-05T12:56:34",
//    "expirationTime": "2024-11-05T13:34:56"
//}
    @Id
    private String userId;
    private String creationTime;
    private Date lastAccessedTime;
    private Date expirationTime;
    private SessionAttributes attributes;
}

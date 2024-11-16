package com.sample.sample.DTO;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Sessions")
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
    private String _id;
    private String userId;
    private String creationTime;
    private String lastAccessedTime;
    private String expirationTime;
    private SessionAttributes attributes;
}

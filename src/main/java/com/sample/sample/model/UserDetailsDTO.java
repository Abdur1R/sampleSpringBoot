package com.sample.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.net.URL;
import java.util.Date;

@Builder
@Document(collection = "userDetailsDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {
    @Id
    private String userId;
    private String userName;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String emailId;
    private String password;
    private Date lastLogin;
    private String linkedInUrl;
    private URL instagramUrl;
}

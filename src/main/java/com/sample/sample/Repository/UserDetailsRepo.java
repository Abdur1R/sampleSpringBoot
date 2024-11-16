package com.sample.sample.Repository;

import com.sample.sample.model.UserDetailsDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepo extends MongoRepository<UserDetailsDTO,String> {
    UserDetailsDTO findByEmailId(String emailId);
}

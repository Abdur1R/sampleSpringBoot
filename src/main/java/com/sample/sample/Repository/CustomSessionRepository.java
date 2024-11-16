package com.sample.sample.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sample.sample.model.Session;
import java.util.List;

public interface CustomSessionRepository extends MongoRepository<Session, String> {
    List<Session> findByUserId(String userId);
}

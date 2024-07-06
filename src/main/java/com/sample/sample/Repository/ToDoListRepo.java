package com.sample.sample.Repository;

import com.sample.sample.model.ToDoListModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ToDoListRepo extends MongoRepository<ToDoListModel,String> {
}

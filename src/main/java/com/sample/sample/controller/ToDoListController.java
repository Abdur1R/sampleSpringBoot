package com.sample.sample.controller;

import java.util.*;
import com.sample.sample.model.ToDoListModel;
import com.sample.sample.Repository.ToDoListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toDoList")
public class ToDoListController {
    @Autowired
    ToDoListRepo toDoListRepo;

    @PostMapping("/save")
    private ToDoListModel PostList(@RequestBody List<ToDoListModel> toDoList){
        try {
            for (ToDoListModel item : toDoList) {
                toDoListRepo.save(item);
            }
            ToDoListModel resp=new ToDoListModel();
            resp.setTaskTitle("Success");
            return resp;
        }
        catch (Exception e){
            return new ToDoListModel();
        }
    }

    @GetMapping("/getList")
    private List<ToDoListModel> GetList(){
        return toDoListRepo.findAll();
    }

    @DeleteMapping("/delete/{date}")
    public List<ToDoListModel> deleteObject(@PathVariable String date) {
        // Logic to delete the object with the given ID
        // For example:
        toDoListRepo.deleteById(date);

        return toDoListRepo.findAll();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> UpdateObj(@RequestBody ToDoListModel obj){
        toDoListRepo.save(obj);
        return ResponseEntity.noContent().build();
    }
}

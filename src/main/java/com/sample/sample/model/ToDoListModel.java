package com.sample.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListModel {
    @Id
    private Date timeStamp;
    private String taskTitle;
}

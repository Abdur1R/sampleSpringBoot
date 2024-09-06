package com.sample.sample.model;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.apache.commons.net.ntp.TimeStamp;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Builder
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoListModel {
    @Id
    private String date;
    private String taskTitle;
    @Nullable
    @Builder.Default
    private boolean completed=Boolean.FALSE;
}

package com.praktika.worktime.persistence.bindings;

import org.hibernate.validator.constraints.Length;

import java.time.Duration;

public class TaskAddBindingModel {
    private String name;
    private String comment;


    public TaskAddBindingModel() {
    }
    @Length(min = 2 , max = 20,message = "Name length should be between 2-20")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Length(min = 2 , max = 500,message = "Name length should be between 2-500")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}

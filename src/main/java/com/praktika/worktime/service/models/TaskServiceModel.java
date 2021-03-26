package com.praktika.worktime.service.models;

import java.math.BigInteger;

public class TaskServiceModel {
    private String name;
    private String comment;
    private BigInteger duration;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }
}

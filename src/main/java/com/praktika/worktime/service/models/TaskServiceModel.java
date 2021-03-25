package com.praktika.worktime.service.models;

import java.time.Duration;

public class TaskServiceModel {
    private String name;
    private String comment;
    private Duration duration;

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

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

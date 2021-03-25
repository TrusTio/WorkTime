package com.praktika.worktime.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Duration;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String name;
    private String comment;
    private Duration duration;

    public Task() {

    }

    @Column(name = "name", nullable = false, updatable = true, unique = true)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "comment", nullable = true)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    @Column(name = "duration", nullable = false)
    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

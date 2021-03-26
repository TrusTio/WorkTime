package com.praktika.worktime.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String name;
    private String comment;
    private BigInteger duration;

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
    @Column(name = "duration")
    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }
}

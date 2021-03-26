package com.praktika.worktime.service;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.service.models.TaskServiceModel;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void save(TaskServiceModel taskServiceModel);
    void save(Task task);
    List<Task> getAll();
    Optional<Task> getByName(String name);
}

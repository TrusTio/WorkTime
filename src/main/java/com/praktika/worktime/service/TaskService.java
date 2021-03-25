package com.praktika.worktime.service;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.service.models.TaskServiceModel;

import java.util.List;

public interface TaskService {
    void save(TaskServiceModel taskServiceModel);
    List<Task> getAll();
}

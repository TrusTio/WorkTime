package com.praktika.worktime.service.impl;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.persistence.entity.User;
import com.praktika.worktime.persistence.repository.TaskRepository;
import com.praktika.worktime.service.TaskService;
import com.praktika.worktime.service.models.TaskServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void save(TaskServiceModel taskServiceModel) {
        Task task= modelMapper.map(taskServiceModel, Task.class);
         taskRepository.save(task);
    }
}

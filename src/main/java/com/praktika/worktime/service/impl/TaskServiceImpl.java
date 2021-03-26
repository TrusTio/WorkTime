package com.praktika.worktime.service.impl;

import com.praktika.worktime.persistence.entity.Task;
import com.praktika.worktime.persistence.repository.TaskRepository;
import com.praktika.worktime.service.TaskService;
import com.praktika.worktime.service.models.TaskServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Task task = modelMapper.map(taskServiceModel, Task.class);
        taskRepository.save(task);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAllByDurationIsNull();
    }

    @Override
    public Optional<Task> getByName(String name) {
        return taskRepository.findByName(name);
    }

    @Override
    public List<Task> getAllCompleted() {

        return taskRepository.findAllByDurationIsNotNull();
    }

}

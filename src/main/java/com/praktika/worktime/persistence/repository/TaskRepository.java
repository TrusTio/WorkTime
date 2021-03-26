package com.praktika.worktime.persistence.repository;

import com.praktika.worktime.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Optional<Task> findByName(String name);
    List<Task> findAllByDurationIsNull();
    List<Task> findAllByDurationIsNotNull();
}

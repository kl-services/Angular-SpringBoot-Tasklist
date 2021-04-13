package com.klservices.tasklist.repository;

import com.klservices.tasklist.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}

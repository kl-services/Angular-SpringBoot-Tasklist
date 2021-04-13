package com.klservices.tasklist.service;

import com.klservices.tasklist.domain.Task;

public interface TaskService {

    Iterable<Task> list();

    Task save(Task task);
}

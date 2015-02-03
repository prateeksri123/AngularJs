package com.task.service;

import com.task.main.model.Task;

public interface TaskService  {
   public Task getTaskById(Long id);
   public void saveTask(Task task);
   
}

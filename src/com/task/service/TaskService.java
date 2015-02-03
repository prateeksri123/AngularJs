package com.task.service;

import java.util.List;

import com.task.main.model.Task;

public interface TaskService  {
   public Task getTaskById(Long id);
   public void saveTask(Task task);
   public List<Task> getTaskList();
   public void deleteTaskById(Long id);
   
}

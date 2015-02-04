package com.task.service;

import java.util.List;

import com.task.main.model.Task;

public interface TaskService  {
   public Task getTaskById(Long id,Long userId);
   public void saveTask(Task task);
   public List<Task> getTaskList(int userId);
   public int deleteTaskById(Long id);

}

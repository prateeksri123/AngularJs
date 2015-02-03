package com.task.service;

import com.task.main.TestPerson;
import com.task.main.model.Task;


public class TaskServiceImpl extends TestPerson implements TaskService {

	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTask(Task task) {
		// TODO Auto-generated method stub
       saveTaskData(task);
	}
	
	private void saveTaskData(Task task) {
		session.save(task);
	}

}

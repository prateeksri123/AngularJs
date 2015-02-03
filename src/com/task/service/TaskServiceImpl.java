package com.task.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.task.main.BaseTaskManagement;
import com.task.main.model.Task;
import com.task.main.model.User;


public class TaskServiceImpl extends BaseTaskManagement implements TaskService {

	private Transaction transaction;
	public TaskServiceImpl(){
		super();
	}
	@Override
	public Task getTaskById(Long id) {
		 Query query = session.createQuery("from Task where id=" + id);
	        List <Task>list = query.list();
	                session.getTransaction().commit();
	         return list.get(0);
	}

	@Override
	public void saveTask(Task task) {
		// TODO Auto-generated method stub
       saveTaskData(task);
	}
	
	private void saveTaskData(Task task) {
		transaction = session.beginTransaction();
		if(task.getId() != 0) {
			session.update(task);
		} else {
			session.save(task);
		}
		
		transaction.commit();
	}
	
	public List<Task> getTaskList() {
		 Query query = session.createQuery("from Task");
	        List <Task>list = query.list();
	                session.getTransaction().commit();
	         return list;
		//return null;
	}
	public void deleteTaskById(Long id) {
		 Query query = session.createQuery("from Task where id=" + id);
	        List <Task>list = query.list();
		Task task = list.get(0);
		//session.beginTransaction();
		session.delete(task);
		
		
	}

}

package com.task.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.task.main.BaseTaskManagement;
import com.task.main.model.Task;
import com.task.main.model.User;

public class UserServiceImpl extends BaseTaskManagement implements UserService {

	public void saveUser(User user) {
		// TODO Auto-generated method stub
        saveUserData(user);
	}

	private Transaction transaction;
	private void saveUserData(User user){
		transaction = session.beginTransaction();
		if(user.getId() != 0) {
			session.update(user);
		} else {
			session.save(user);
		}

		transaction.commit();
	}
	@Override
	public User authenticateUser(User user) {
		Query query = session.createQuery("from User where userName='" + user.getUserName() + "'and password='" + user.getPassword() + "'");
        List <User>list = query.list();
                session.getTransaction().commit();
         return list.get(0);

	}
}

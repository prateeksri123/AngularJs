package com.task.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.task.main.model.SessionFactoryUtil;
import com.task.main.model.User;


public class BaseTaskManagement {

	/**
	 * @param args Testing Git
	 */
	public Session session;
	private Transaction transaction;
	public BaseTaskManagement() {
		 session = SessionFactoryUtil.getSessionFactory().getCurrentSession();

		 transaction = session.beginTransaction();

        // createPerson();

         //queryPerson(session);
        System.out.println("done");
	}
	
	public void createSession(){
		
			session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
			 session.beginTransaction();
		
	}

	public List<User> getPersons() {
        Query query = session.createQuery("from User");
        List <User>list = query.list();
                session.getTransaction().commit();
         return list;
	}

	public void createPerson() {
        User person = new User();

        person.setUserName("Prateek1");
        person.setPassword("Srivastava");

        person.setFirstName("Prateek");
        person.setLastName("Prateek");

        session.save(person);
	}
}


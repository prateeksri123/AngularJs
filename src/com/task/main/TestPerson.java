package com.task.main;

import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;

import com.task.main.model.Person;
import com.task.main.model.SessionFactoryUtil;
import com.task.main.model.User;
 

public class TestPerson {
  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = SessionFactoryUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();

         createPerson(session);
          
         queryPerson(session);


        System.out.println("done");
	}

	private static void queryPerson(Session session) {
        Query query = session.createQuery("from User");                 
        List <User>list = query.list();
        java.util.Iterator<User> iter = list.iterator();
        while (iter.hasNext()) {
          
        	User person = iter.next();
          System.out.println("Person: \"" + person.getFirstName() +
                          "\", " + person.getLastName() +
                          "\", " + person.getId());

        }
        
        session.getTransaction().commit();
		
	}

	public static void createPerson(Session session) {
        User person = new User();

        person.setUserName("Prateek1");
        person.setPassword("Srivastava");
        
        person.setFirstName("Prateek");
        person.setLastName("Prateek");
        
        session.save(person);
	}
}


package com.task.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.main.model.User;

public class TaskManagement {
	public static void main(String[] args) {
		System.out.println("Hello Eclipse!");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Bean.xml");

		User obj = (User) context.getBean("helloWorld");
		System.out.println("Hello Eclipse! " + obj.getFirstName());
		TestPerson tp = new TestPerson();
		List<User> list = tp.getPersons();
		java.util.Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {

			User person = iter.next();
			System.out.println("Person: \"" + person.getFirstName() + "\", "
					+ person.getLastName() + "\", " + person.getId());

		}

	}
}

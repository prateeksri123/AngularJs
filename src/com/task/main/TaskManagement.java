package com.task.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.mapping.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.main.model.User;


@Path("/task")
public class TaskManagement {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getPerson() {
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
		return list;

	}
}

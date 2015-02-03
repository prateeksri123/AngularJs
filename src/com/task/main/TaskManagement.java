package com.task.main;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.mapping.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jmx.snmp.tasks.Task;
import com.task.main.model.User;
import com.task.service.TaskServiceImpl;


@Path("/task")
public class TaskManagement {

	public ApplicationContext context = new ClassPathXmlApplicationContext(
	"Bean.xml");
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public java.util.List<User> getPerson() {
		System.out.println("Hello Eclipse!");
		

		User obj = (User) context.getBean("helloWorld");
		System.out.println("Hello Eclipse! " + obj.getFirstName());
		TestPerson tp = new TestPerson();
		java.util.List<User> list = tp.getPersons();
		java.util.Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {

			User person = iter.next();
			System.out.println("Person: \"" + person.getFirstName() + "\", "
					+ person.getLastName() + "\", " + person.getId());

		}
		return list;

	}
	
	@POST
	public java.util.List<Task> saveTask(com.task.main.model.Task task) {
		TaskServiceImpl taskServiceImpl = (TaskServiceImpl) context.getBean("taskService");
		taskServiceImpl.saveTask(task);
		System.out.println(task.getPriority());
		return null;
	}
}

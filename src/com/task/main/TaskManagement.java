package com.task.main;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.jmx.snmp.tasks.Task;
import com.task.service.TaskServiceImpl;


@Path("/task")
public class TaskManagement {

	public ApplicationContext context = new ClassPathXmlApplicationContext(
	"Bean.xml");
	TaskServiceImpl taskServiceImpl = (TaskServiceImpl) context.getBean("taskService");
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public java.util.List<com.task.main.model.Task> getTaskList(@PathParam("userId") int userId) {
		return taskServiceImpl.getTaskList(userId);

	}

	@GET
	@Path("/{taskId}/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public com.task.main.model.Task getTaskbyId(@PathParam("taskId") Long taskId, @PathParam("userId") Long userId) {
		return taskServiceImpl.getTaskById(taskId,userId);

	}

	@POST
	public java.util.List<Task> saveTask(com.task.main.model.Task task) {

		//taskServiceImpl.createSession();
		taskServiceImpl.saveTask(task);
		System.out.println(task.getPriority());
		return null;
	}

	@DELETE
	@Path("/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.task.main.model.Task> deleteTaskbyId(@PathParam("taskId") Long taskId) {
		int userId = taskServiceImpl.deleteTaskById(taskId);
		return taskServiceImpl.getTaskList( userId);

	}
}

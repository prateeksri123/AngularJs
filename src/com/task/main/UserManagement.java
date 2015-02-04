package com.task.main;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.main.model.User;
import com.task.service.*;

@Path("/user")
public class UserManagement {
	public ApplicationContext context = new ClassPathXmlApplicationContext(
	"Bean.xml");
	UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userService");

	@POST
	public void saveUser(User user) {
		userServiceImpl.saveUser(user);
	}

	@GET
	@Path("/{userName}/{password}")
	public User getUser(@PathParam("userName") String userName, @PathParam("password") String password ) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		User loggedinUser = userServiceImpl.authenticateUser(user);
		return loggedinUser;
	}
}

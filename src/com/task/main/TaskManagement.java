package com.task.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.main.model.User;

public class TaskManagement {
	 public static void main(String[] args) {
		    System.out.println("Hello Eclipse!");
		    ApplicationContext context =
	             new ClassPathXmlApplicationContext("Bean.xml");

	      User obj = (User) context.getBean("helloWorld");
	      System.out.println("Hello Eclipse! " + obj.getFirstName());
	      obj.getFirstName();
		  }
}

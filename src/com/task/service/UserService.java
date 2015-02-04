package com.task.service;

import com.task.main.model.User;

public interface UserService {
 public void saveUser(User user);
 public User authenticateUser(User user);
}

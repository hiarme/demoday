package com.arproject.arproject.service;

import com.arproject.arproject.model.User;

public interface UserService {

  // *** User ***
    void addUser(User user);
    void updateUser(User user);
    User findUserByUserName(String username);
    User findUserById(int id);

  // -- for db development --
    void deleteUser(int id);
    void deleteAllUsers();

}

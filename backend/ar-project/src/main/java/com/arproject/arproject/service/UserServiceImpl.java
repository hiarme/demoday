package com.arproject.arproject.service;

import com.arproject.arproject.model.User;
import com.arproject.arproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByUserName(String username) {
        List<User> allUsers = userRepository.findAll();
        List<User> usersFound = allUsers.stream()
                .filter(user -> user.getUserName().equals(username))
                .collect(Collectors.toList());
         return usersFound.get(0);
    }

    @Override
    public User findUserById(int id) {
        List<User> allUsers = userRepository.findAll();
        List<User> usersFound = allUsers.stream()
                .filter(user -> user.getUserName().equals(id))
                .collect(Collectors.toList());
        return usersFound.get(0);
    }

    // -- for db development --
    @Override
    public void deleteUser(int id) {
        List<User> allUsers = userRepository.findAll();
        List<User> usersFound = allUsers.stream()
                .filter(user -> user.getUserName().equals(id))
                .collect(Collectors.toList());
        User userFound = usersFound.get(0);
        userRepository.delete(userFound);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}

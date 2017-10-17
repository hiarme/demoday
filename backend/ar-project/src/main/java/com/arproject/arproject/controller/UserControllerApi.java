package com.arproject.arproject.controller;


import com.arproject.arproject.model.User;
import com.arproject.arproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 10000)
@RestController
public class UserControllerApi {

    @Autowired
    UserService userService;

  // *** GET User ***
    @GetMapping("/api/get_user")
    public User getUser(@RequestBody String username) {
       return userService.findUserByUserName(username);
    }

  // *** UPDATE User ***
    @PostMapping("/api/update_user")
    public String updateUser(@RequestBody User user) {
        String userName = user.getUserName();
        User updateUser = userService.findUserByUserName(userName);
        updateUser.setName(user.getName());
        updateUser.setResume(user.getResume());
        updateUser.setGithub(user.getGithub());
        updateUser.setPortfolio(user.getPortfolio());
        updateUser.setImage(user.getImage());
            userService.updateUser(updateUser);

        return "USER UPDATED";
    }

  // *** ADD User ***
    @PostMapping("/api/add_user")
    public String addUser(@RequestBody User user) {
        User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setName(user.getName());
            newUser.setResume(user.getResume());
            newUser.setGithub(user.getGithub());
            newUser.setPortfolio(user.getPortfolio());
            newUser.setImage(user.getImage());
                userService.updateUser(newUser);
            return "USER ADDED";
    }

  // *** DELETE METHODS FOR DB DEVELOPMENT AND TESTING ***
    @DeleteMapping("/api/delete_one")
    public String deleteOne(@RequestBody int id) {
        User found = userService.findUserById(id);
        userService.deleteUser(id);
        return "USER DELETED";
    }

    @DeleteMapping("/api/delete_all")
    public String deleteAll() {
        userService.deleteAllUsers();
        return "ALL USERS DELETED";
    }
}

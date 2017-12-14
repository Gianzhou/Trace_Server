package com.bst530.group26.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bst530.group26.models.database.*;
import com.bst530.group26.repository.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    

    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping("/user/{userID}/groups")
    @ResponseBody
    public List<Group> getUserGroups(@PathVariable("userID") long userID){
        User user = userRepository.findOne(userID);
        List<Group> groups = user.getGroups();
        return groups;
    }
}
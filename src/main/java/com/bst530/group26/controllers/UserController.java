package com.bst530.group26.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bst530.group26.model.Group;
import com.bst530.group26.model.GroupMember;
import com.bst530.group26.model.User;
import com.bst530.group26.repositories.GroupMemberRepository;
import com.bst530.group26.repositories.GroupRepository;
import com.bst530.group26.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @RequestMapping("/users")
    @ResponseBody
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping("/user/{userID}/groups")
    @ResponseBody
    public List<Group> getUserGroups(@PathVariable("userID") long userID){
        List<GroupMember> groupMembers = groupMemberRepository.findAllByUserId(userID);
        List<Group> groups = new ArrayList<>();
        
        for(int i = 0; i < groupMembers.size(); i++){
            GroupMember member = groupMembers.get(i);
            Group group = groupRepository.findOne(member.getGroup().getID());
            groups.add(group);
        }

        return groups;
    }
}
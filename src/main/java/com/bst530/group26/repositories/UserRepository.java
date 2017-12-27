package com.bst530.group26.repositories;


import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
}

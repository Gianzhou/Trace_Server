package com.bst530.group26.repository;



import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.models.database.Point;
import com.bst530.group26.models.database.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();
   
}

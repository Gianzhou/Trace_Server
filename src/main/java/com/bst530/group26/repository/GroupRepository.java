package com.bst530.group26.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.models.database.Group;


public interface GroupRepository extends CrudRepository<Group, Long> {
	List<Group> findAll();
}

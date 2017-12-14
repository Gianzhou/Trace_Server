package com.bst530.group26.repository;


import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.models.database.Point;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Long> {
    List<Point> findAll();
    List<Point> findAllByUserId(long user_id);
}

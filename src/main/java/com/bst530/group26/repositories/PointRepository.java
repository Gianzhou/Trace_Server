package com.bst530.group26.repositories;


import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.model.Point;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Long> {
    List<Point> findAllByGroupId(long group_id);
    List<Point> findAllByGroupIdAndGroupMemberId(long group_id, long group_member_id);
}

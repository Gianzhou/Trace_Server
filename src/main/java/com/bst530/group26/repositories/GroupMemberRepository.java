package com.bst530.group26.repositories;


import org.springframework.data.repository.CrudRepository;

import com.bst530.group26.model.GroupMember;

import java.util.List;

public interface GroupMemberRepository extends CrudRepository<GroupMember, Long> {
    List<GroupMember> findAllByUserId(long user_id);
    GroupMember findOneByUserIdAndGroupId(long user_id, long group_id);
}

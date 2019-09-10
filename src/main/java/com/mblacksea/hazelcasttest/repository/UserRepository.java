package com.mblacksea.hazelcasttest.repository;

import com.mblacksea.hazelcasttest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


}

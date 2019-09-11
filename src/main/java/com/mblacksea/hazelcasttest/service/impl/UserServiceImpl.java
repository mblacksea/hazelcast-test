package com.mblacksea.hazelcasttest.service.impl;

import com.mblacksea.hazelcasttest.base.AbstractService;
import com.mblacksea.hazelcasttest.entity.UserEntity;
import com.mblacksea.hazelcasttest.mapper.DozzerMapperUtility;
import com.mblacksea.hazelcasttest.model.User;
import com.mblacksea.hazelcasttest.repository.UserRepository;
import com.mblacksea.hazelcasttest.response.UserResponse;
import com.mblacksea.hazelcasttest.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl extends AbstractService implements IUserService {

  private final UserRepository userRepository;
  private final DozzerMapperUtility dozzerMapperUtility;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, DozzerMapperUtility dozzerMapperUtility) {
    this.userRepository = userRepository;
    this.dozzerMapperUtility = dozzerMapperUtility;
  }

  @Override
  @Cacheable()
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public UserResponse inquireAllUsers() {
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();

    final UserResponse userResponse = new UserResponse();
    final List<UserEntity> userEntities = userRepository.findAll();
    final List<User> allUsers = this.dozzerMapperUtility.map(userEntities, User.class, "UserEntity_User");

    if (CollectionUtils.isNotEmpty(allUsers)) {
      userResponse.setUsers(allUsers);
    }

    stopWatch.stop();

    this.performanceLog(stopWatch, "UserServiceImpl.inquireAllUsers", "getAllUsers");
    return userResponse;
  }
}

package com.mblacksea.hazelcasttest.service.impl;

import com.mblacksea.hazelcasttest.base.AbstractService;
import com.mblacksea.hazelcasttest.base.response.GenericResponse;
import com.mblacksea.hazelcasttest.base.response.OperationResult;
import com.mblacksea.hazelcasttest.base.util.GeneralEnumDefination.OperationResultCodeType;
import com.mblacksea.hazelcasttest.entity.UserEntity;
import com.mblacksea.hazelcasttest.mapper.DozzerMapperUtility;
import com.mblacksea.hazelcasttest.model.User;
import com.mblacksea.hazelcasttest.repository.UserRepository;
import com.mblacksea.hazelcasttest.response.UserResponse;
import com.mblacksea.hazelcasttest.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService implements IUserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private DozzerMapperUtility dozzerMapperUtility;

  @Override
  @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
  public GenericResponse<UserResponse> inquireAllUsers() {
    final GenericResponse<UserResponse> genericResponse = new GenericResponse<>();

    final List<UserEntity> userEntities = userRepository.findAll();
    final List<User> allUsers = this.dozzerMapperUtility.map(userEntities, User.class, "UserEntity_User");
    if (CollectionUtils.isNotEmpty(allUsers)) {
      UserResponse userResponse = new UserResponse();
      userResponse.setUsers(allUsers);

      genericResponse.setData(userResponse);
      genericResponse.setOperationResult(OperationResult.newInstance(OperationResultCodeType.SUCCESS));

    }

    return genericResponse;
  }
}

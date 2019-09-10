package com.mblacksea.hazelcasttest.service;

import com.mblacksea.hazelcasttest.base.response.GenericResponse;
import com.mblacksea.hazelcasttest.response.UserResponse;


public interface IUserService {

  GenericResponse<UserResponse> inquireAllUsers();

}

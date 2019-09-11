package com.mblacksea.hazelcasttest.controller;

import com.mblacksea.hazelcasttest.base.AbstractController;
import com.mblacksea.hazelcasttest.response.UserResponse;
import com.mblacksea.hazelcasttest.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

  private final IUserService userService;

  @Autowired
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/inquireAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public ResponseEntity<UserResponse> generateReferCode() {
    final UserResponse userResponse = userService.inquireAllUsers();
    if (userResponse != null && CollectionUtils.isNotEmpty(userResponse.getUsers())) {
      return new ResponseEntity<>(userService.inquireAllUsers(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}

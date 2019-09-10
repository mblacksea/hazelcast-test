package com.mblacksea.hazelcasttest.response;

import com.mblacksea.hazelcasttest.base.AbstractGenericType;
import com.mblacksea.hazelcasttest.model.User;

import java.util.List;

public class UserResponse extends AbstractGenericType {

  public UserResponse() {
  }

  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}

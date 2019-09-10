package com.mblacksea.hazelcasttest.model;

import com.mblacksea.hazelcasttest.base.AbstractGenericType;

public class User extends AbstractGenericType {

  private String userId;
  private String userName;
  private String userSurname;

  public User() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserSurname() {
    return userSurname;
  }

  public void setUserSurname(String userSurname) {
    this.userSurname = userSurname;
  }
}

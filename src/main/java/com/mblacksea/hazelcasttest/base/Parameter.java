package com.mblacksea.hazelcasttest.base;

import java.io.Serializable;

public class Parameter implements Serializable {
  protected String name;
  protected String value;
  protected String resolvedValue;
  protected String shortCode;
  protected String parameterType;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getResolvedValue() {
    return resolvedValue;
  }

  public void setResolvedValue(String resolvedValue) {
    this.resolvedValue = resolvedValue;
  }

  public String getShortCode() {
    return shortCode;
  }

  public void setShortCode(String shortCode) {
    this.shortCode = shortCode;
  }

  public String getParameterType() {
    return parameterType;
  }

  public void setParameterType(String parameterType) {
    this.parameterType = parameterType;
  }
}
